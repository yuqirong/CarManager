package com.carmanager.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.constant.WebConstant;
import com.carmanager.services.ClubActivityService;
import com.carmanager.services.ClubService;

@Controller
@RequestMapping("/club")
public class ClubController {

	@Autowired
	private ClubService clubService;
	@Autowired
	private ClubActivityService clubActivityService;
	private int maxResult = WebConstant.PAGE_SIZE;

	@RequestMapping(value = "/browse", method = RequestMethod.GET)
	private String getClubs(Map<String, Object> map) {
		map.put("clubs", clubService.findAllEntities());
		return "club/club";
	}
	
	@RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
	private String getClubDetails(@PathVariable("id") Integer id, Map<String, Object> map) {
		map.put("club", clubService.getEntity(id));
		return "club/detail";
	}
	
	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	private String getClubActivities(Map<String, Object> map) {
		map.put("clubActivities", clubActivityService.getWeekClubActivities(maxResult));
		return "club/activity";
	}

}
