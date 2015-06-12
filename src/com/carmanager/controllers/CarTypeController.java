package com.carmanager.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.entities.Car;
import com.carmanager.entities.CarType;
import com.carmanager.services.CarService;
import com.carmanager.services.CarTypeService;

@Controller
@RequestMapping("/cartype")
public class CarTypeController {

	@Autowired
	private CarTypeService carTypeService;
	@Autowired
	private CarService carService;

	/**
	 * 车型的详细介绍
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getCarType(@PathVariable("id") int id, Map<String, Object> map) {
		CarType carType = carTypeService.getEntity(id);
		List<Car> cars = carService.findCarByCarTypeId(id);
		map.put("carType", carType);
		map.put("cars", cars);
		return "cartype/type";
	}


}
