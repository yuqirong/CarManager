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
import com.carmanager.services.NewsTypeService;

@Controller
@RequestMapping("newstype")
public class NewsTypeController {

	@Autowired
	private NewsTypeService newsTypeService;
	@Autowired
	private NewsService newsService;

	private Page<News> p = null;
	private int pageSize = WebConstant.PAGE_SIZE;

	/**
	 * 得到栏目的专页
	 * 
	 * @param id
	 * @param pageNo
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/column/{id}/{pageNo}", method = RequestMethod.GET)
	public String getColumn(@PathVariable int id, @PathVariable int pageNo,
			Map<String, Object> map) {
		p = new Page<News>();
		p = newsService.getNews(id, pageNo, pageSize);
		map.put("page", p);
		map.put("newsType", newsTypeService.getEntity(id));
		return "newstype/column";
	}

}
