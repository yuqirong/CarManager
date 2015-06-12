package com.carmanager.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.CarDaoImpl;
import com.carmanager.entities.Car;
import com.carmanager.services.CarService;
import com.carmanager.utils.ValidateUtils;

@Service("carService")
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarService {

	@Autowired
	private CarDaoImpl carDao;

	@Override
	public List<Car> findCarByCarTypeId(int id) {
		if (ValidateUtils.isValid(id)) {
			return carDao.findCarByCarTypeId(id);
		}
		return null;
	}

}
