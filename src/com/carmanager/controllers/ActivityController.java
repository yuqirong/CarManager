package com.carmanager.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.constant.WebConstant;
import com.carmanager.entities.News;
import com.carmanager.entities.Page;
import com.carmanager.services.NewsService;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private NewsService newsService;
	
	private final static int DISCOUNT_NEWS_ID = WebConstant.DISCOUNT_NEWS_ID;
	private final static int SELF_DRIVING_TOUR_ID = WebConstant.SELF_DRIVING_TOUR_ID;
	private final static int PAGE_SIZE = WebConstant.PAGE_SIZE;
	
	

	@RequestMapping(value = "/discount/{pageNo}", method = RequestMethod.GET)
	public String discount(@PathVariable Integer pageNo, Map<String, Object> map) {
		Page<News> page = newsService.getNews(DISCOUNT_NEWS_ID, pageNo, PAGE_SIZE);
		map.put("page", page);
		return "activity/discount";
	}
	
	@RequestMapping(value = "/tour/{pageNo}", method = RequestMethod.GET)
	public String tour(@PathVariable int pageNo, Map<String, Object> map) {
		Page<News> page = newsService.getNews(SELF_DRIVING_TOUR_ID, pageNo, PAGE_SIZE);
		map.put("page", page);
		return "activity/tour";
	}

}
