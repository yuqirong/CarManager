package com.carmanager.controllers.admin;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.services.UserService;

@Controller
@RequestMapping("/admin/employee")
public class AdminEmployeeController {
	
	@Autowired
	private UserService userService;
	
	@RequiresPermissions(value="employee:query")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Map<String, Object> map) {
		map.put("admins", userService.getAllAdmins());
		return "admin/list";
	}

}
