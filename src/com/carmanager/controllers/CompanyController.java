package com.carmanager.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.services.CompanyService;

@Controller
@RequestMapping(value = "/about")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/lianxi")
	public String lianxi(Map<String, Object> map) {
		map.put("companys", companyService.findAllEntities());
		return "about/lianxi";
	}

	@RequestMapping(value = "/comp_info", method = RequestMethod.GET)
	public String companyInfo() {
		return "about/comp_info";
	}

	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String help() {
		return "about/help";
	}
	
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String config() {
		return "about/config";
	}

}
