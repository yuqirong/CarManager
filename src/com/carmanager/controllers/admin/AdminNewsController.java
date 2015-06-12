package com.carmanager.controllers.admin;

import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.constant.WebConstant;
import com.carmanager.entities.News;
import com.carmanager.entities.Page;
import com.carmanager.services.NewsService;
import com.carmanager.services.NewsTypeService;

@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private NewsTypeService newsTypeService;
	
	private Page<News> p = null;	
	private int pageSize = WebConstant.PAGE_SIZE;
	
	/**
	 * 后台得到新闻页面
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="news:view")
	@RequestMapping(value = "/views/{id}", method = RequestMethod.GET)
	private String getAdminView(@PathVariable("id") Integer id,
			Map<String, Object> map) {
		News news = newsService.getEntity(id);
		map.put("news", news);
		return "news/admin_view";
	}
	
	/**
	 * 新闻列表
	 * 
	 * @param pageNo
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="news:query")
	@RequestMapping(value = "/list/{pageNo}", method = RequestMethod.GET)
	public String getAllNews(@PathVariable int pageNo, Map<String, Object> map) {
		p = new Page<News>();
		p = newsService.listAllNewsPage(pageNo, pageSize);
		map.put("page", p);
		return "news/list";
	}

	/**
	 * 编辑新闻
	 * @param id
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="news:update")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editNews(@PathVariable("id") int id, Map<String, Object> map) {
		map.put("allNewsTypes", newsTypeService.findAllEntities());
		map.put("news", newsService.getEntity(id));
		return "news/edit";
	}
	
	/**
	 * 删除新闻
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions(value="news:delete")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteNews(@PathVariable("id") int id) {
		newsService.deleteEntityById(id);
		return "redirect:/admin/news/list/1";
	}
	
	/**
	 * 保存新闻
	 * 
	 * @param news
	 * @param bindingResult
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="news:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid News news, BindingResult bindingResult,
			Map<String, Object> map) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getObjectName() + " : "
						+ error.getDefaultMessage());
			}
			map.put("allNewsTypes", newsTypeService.findAllEntities());
			return "news/add";
		}
		newsService.saveEntity(news);
		return "redirect:/admin/news/list/1";
	}

	/**
	 * 更新新闻
	 * 
	 * @param news
	 * @return  
	 */
	@RequiresPermissions(value="news:save")
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public String update(News news, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getObjectName() + " : "
						+ error.getDefaultMessage());
			}
		}
		newsService.updateEntity(news);
		return "redirect:/admin/news/list/1";
	}
	
	/**
	 * 添加新闻
	 * 
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="news:create")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNews(Map<String, Object> map) {
		map.put("allNewsTypes", newsTypeService.findAllEntities());
		map.put("news", new News());
		return "news/add";
	}

}
