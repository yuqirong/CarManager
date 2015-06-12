package com.carmanager.controllers.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.entities.Car;
import com.carmanager.services.CarService;
import com.carmanager.services.CarTypeService;

@Controller
@RequestMapping("/admin/car")
public class AdminCarController {

	@Autowired
	private CarService carService;
	@Autowired
	private CarTypeService carTypeService;

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public String carList(@PathVariable("id") int id, Map<String, Object> map) {
		List<Car> cars = carService.findCarByCarTypeId(id);
		map.put("cars", cars);
		map.put("carType", carTypeService.getEntity(id));
		return "car/list";
	}
}
