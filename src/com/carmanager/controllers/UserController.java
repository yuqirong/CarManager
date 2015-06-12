package com.carmanager.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.constant.WebConstant;
import com.carmanager.entities.CarType;
import com.carmanager.entities.Feel;
import com.carmanager.entities.News;
import com.carmanager.entities.Page;
import com.carmanager.entities.Record;
import com.carmanager.entities.User;
import com.carmanager.services.CarTypeService;
import com.carmanager.services.FeelService;
import com.carmanager.services.GradeService;
import com.carmanager.services.NewsService;
import com.carmanager.services.RecordService;
import com.carmanager.services.UserService;
import com.carmanager.services.impl.SenderMailService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private RecordService recordService;
	@Autowired
	private FeelService feelService;
	@Autowired
	private SenderMailService senderMailService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private CarTypeService carTypeService;
	
	private final static int PAGE_SIZE = WebConstant.PAGE_SIZE;
	
	
	/**
	 * 跳转到首页
	 * 
	 * @return
	 */
	@RequiresUser
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Map<String, Object> map) {
		List<News> zixun = newsService.getRecentNews(1, 5);
		List<News> xinwen = newsService.getRecentNews(2, 5);
		List<News> daogou = newsService.getRecentNews(3, 5);
		List<CarType> carTypes = carTypeService.findAllEntities();
		map.put("carTypes", carTypes);
		map.put("zixun", zixun);
		map.put("xinwen", xinwen);
		map.put("daogou", daogou);
		return "user/home";
	}

	/**
	 * 激活用户
	 * 
	 * @param email
	 * @param activeCode
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/site/active/u/{email}/e/{activeCode}", method = RequestMethod.GET)
	public String active(@PathVariable("email") String email,
			@PathVariable("activeCode") String activeCode,
			Map<String, Object> map) {
		User user = userService.activeUserByEmail(email, activeCode);
		if (user != null) {
			return "user/active_success";
		}
		return "user/active_fail";
	}

	/**
	 * 我的空间
	 * 
	 * @param req
	 * @param map
	 * @return
	 */
	@RequiresUser
	@RequestMapping(value = "/myzone", method = RequestMethod.GET)
	public String myZone() {
		return "user/my_zone";
	}

	@RequestMapping(value = "/scorehistory", method = RequestMethod.GET)
	public String scoreHistory(HttpServletRequest req, Map<String, Object> map) {
		User user = (User) req.getAttribute("user");
		map.put("user", user);
		List<Record> records = recordService.findScoreHistoryById(user.getId());
		map.put("records", records);
		return "user/score_history";
	}

	@RequiresUser
	@RequestMapping(value = "/review/{pageNo}", method = RequestMethod.GET)
	public String feel(@PathVariable("pageNo") int pageNo,
			Map<String, Object> map) {
		Page<Feel> page = feelService.getFeels(pageNo, PAGE_SIZE);
		map.put("page", page);
		return "review/feel";
	}
	
	/**
	 * 提交登录表单
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req, Model model) {
		String exceptionClassName = (String) req
				.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(
				exceptionClassName)) {
			error = "用户名/密码错误";
		} else if ("jCaptcha.error".equals(exceptionClassName)) {
			error = "验证码错误";
		} else if (exceptionClassName != null) {
			System.out.println(exceptionClassName);
			error = "用户名/密码错误";
		}
		model.addAttribute("error", error);
		return "user/login";
	}
	
	/**
	 * 跳转到注册页面
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String toRegister(Map<String, Object> map) {
		map.put("user", new User());
		return "user/register";
	}

	/**
	 * 提交注册表单
	 * 
	 * @param req
	 * @param user
	 * @param bindingResult
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String register(HttpServletRequest req, @Valid User user,
			BindingResult bindingResult, Map<String, Object> map) {
		String exceptionClassName = (String) req
				.getAttribute("shiroLoginFailure");
		if (bindingResult.hasErrors()) { // //校检出错返回页面
			return "user/register";
		}
		userService.validate(user, bindingResult); // 注册用户校检
		if (bindingResult.hasErrors()) { // 校检出错返回页面
			return "user/register";
		}
		if ("jCaptcha.error".equals(exceptionClassName)) { // 验证码校检
			map.put("error", "验证码错误！");
			return "user/register";
		}
		String password = user.getPassword();
		userService.createUser(user); // 创建用户
		this.subjectLogin(user, password);
		senderMailService.sendMail(user); // 给注册用户发送激活邮件
		return "redirect:/user/reg_success";
	}

	/**
	 * 注册用户自动登录
	 * 
	 * @param user
	 * @param password
	 */
	private void subjectLogin(User user, String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(); // 生成令牌
		token.setUsername(user.getUsername());
		token.setPassword(password.toCharArray());
		SecurityUtils.getSubject().login(token); // 注册用户登录
	}

}
