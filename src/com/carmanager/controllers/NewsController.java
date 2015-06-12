package com.carmanager.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.entities.News;
import com.carmanager.services.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	/**
	 * 得到新闻页面
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	private String getView(@PathVariable("id") Integer id,
			Map<String, Object> map) {
		News news = newsService.getEntity(id);
		map.put("news", news);
		return "news/view";
	}

}
