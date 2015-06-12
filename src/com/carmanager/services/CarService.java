package com.carmanager.services;

import java.util.List;

import com.carmanager.entities.Car;

public interface CarService extends BaseService<Car> {

	public List<Car> findCarByCarTypeId(int id);

}
