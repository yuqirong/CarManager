package com.carmanager.controllers.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.constant.WebConstant;
import com.carmanager.entities.Page;
import com.carmanager.entities.User;
import com.carmanager.services.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

	private Page<User> p = null;
	private int pageSize = WebConstant.PAGE_SIZE;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/grade/{pageNo}", method = RequestMethod.GET)
	public String gradeList(@PathVariable int pageNo, Map<String, Object> map) {
		p = userService.getGradeList(pageNo, pageSize);
		map.put("page", p);
		return "admin/gradelist";
	}
	
	@RequestMapping(value = "/score/{pageNo}", method = RequestMethod.GET)
	public String scoreList(@PathVariable int pageNo, Map<String, Object> map) {
		p = userService.getScoreList(pageNo, pageSize);
		map.put("page", p);
		return "admin/scorelist";
	}

}
