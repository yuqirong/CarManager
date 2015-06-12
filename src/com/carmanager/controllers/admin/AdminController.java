package com.carmanager.controllers.admin;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.entities.User;
import com.carmanager.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

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
			error = "其他错误：" + exceptionClassName;
		}
		model.addAttribute("error", error);
		return "admin/login";
	}

	/**
	 * 跳转到首页
	 * 
	 * @return
	 */
	@RequiresRoles(value = { "admin", "superadmin" }, logical = Logical.OR)
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest req, Map<String, Object> map) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		User user = userService.findByUsername(username);
		if (!req.getRemoteAddr().equals(user.getIpAddress())) {
			user.setIpAddress(req.getRemoteAddr());
			userService.updateEntity(user);
		}
		return "admin/home";
	}

}
