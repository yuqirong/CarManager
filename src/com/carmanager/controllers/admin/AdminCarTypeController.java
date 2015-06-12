package com.carmanager.controllers.admin;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.carmanager.entities.CarType;
import com.carmanager.services.CarService;
import com.carmanager.services.CarTypeService;

@Controller
@RequestMapping("/admin/cartype")
public class AdminCarTypeController {
	
	@Autowired
	private CarTypeService carTypeService;
	@Autowired
	private CarService carService;
	
	/**
	 * 车型列表
	 * 
	 * @param pageNo
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="cartype:query")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getCarTypes(Map<String, Object> map) {
		map.put("carTypes", carTypeService.findAllEntities());
		return "cartype/list";
	}

	/**
	 * 添加车型
	 * 
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="cartype:create")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCarType(Map<String, Object> map) {
		map.put("carType", new CarType());
		return "cartype/add";
	}

	/**
	 * 删除车型
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions(value="cartype:delete")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteCarType(@PathVariable("id") int id) {
		carTypeService.deleteEntityById(id);
		return "redirect:/admin/cartype/list";
	}

	/**
	 * 编辑车型
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequiresPermissions(value="cartype:update")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCarType(@PathVariable("id") int id,
			Map<String, Object> map) {
		map.put("carType", carTypeService.getEntity(id));
		return "cartype/edit";
	}

	@RequiresPermissions(value="cartype:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String editCarType(CarType carType, BindingResult bindingResult,
			@RequestParam(value = "file") MultipartFile file,
			HttpSession httpSession) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getObjectName() + " : "
						+ error.getDefaultMessage());
			}
		}
		carTypeService.updateCarType(carType,file,httpSession);
		return "redirect:/admin/cartype/list";
	}

}
