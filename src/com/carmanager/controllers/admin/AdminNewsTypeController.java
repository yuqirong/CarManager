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

import com.carmanager.entities.NewsType;
import com.carmanager.services.NewsTypeService;

@Controller
@RequestMapping("/admin/newstype")
public class AdminNewsTypeController {

	@Autowired
	private NewsTypeService newsTypeService;
	
	/**
	 * 新闻栏目列表
	 * @param pageNo
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="newstype:query")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getAllNewsType(Map<String, Object> map) {
		map.put("newsTypes", newsTypeService.findAllEntities());
		return "newstype/list";
	}
	
	/**
	 * 删除新闻栏目
	 * @param id
	 * @return
	 */
	@RequiresPermissions(value="newstype:delete")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteNewsTypr(@PathVariable("id") int id) {
		newsTypeService.deleteNewsType(id);
		return "redirect:/admin/newstype/list";
	}
	
	/**
	 * 编辑新闻栏目
	 * @param id
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="newstype:update")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editNewsType(@PathVariable("id") int id, Map<String, Object> map) {
		map.put("newsType", newsTypeService.getEntity(id));
		return "newstype/edit";
	}
	
	/**
	 * 更新新闻栏目
	 * @param news
	 * @return  
	 */
	@RequiresPermissions(value="newstype:save")
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public String update(NewsType newsType, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getObjectName() + " : "
						+ error.getDefaultMessage());
			}
		}
		newsTypeService.updateEntity(newsType);
		return "redirect:/admin/newstype/list";
	}
	
	/**
	 * 保存新闻栏目
	 * @param news
	 * @return  
	 */
	@RequiresPermissions(value="newstype:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid NewsType newsType, BindingResult bindingResult,
			Map<String, Object> map) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getObjectName() + " : "
						+ error.getDefaultMessage());
			}
			return "newstype/add";
		}
		newsTypeService.saveEntity(newsType);
		return "redirect:/admin/newstype/list";
	}
	
	/**
	 * 添加新闻栏目
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="newstype:create")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNews(Map<String, Object> map) {
		map.put("newsType", new NewsType());
		return "newstype/add";
	}
	
}
