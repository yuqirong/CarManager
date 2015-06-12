package com.carmanager.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.services.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	/**
	 * 车的详细介绍
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String getCarDetail(@PathVariable("id") int id,
			Map<String, Object> map) {
		map.put("car", carService.getEntity(id));
		return "car/detail";
	}

}
