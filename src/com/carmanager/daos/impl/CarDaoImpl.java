package com.carmanager.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.carmanager.entities.Car;

@Repository("carDao")
public class CarDaoImpl extends BaseDaoImpl<Car> {

	public List<Car> findCarByCarTypeId(Integer id) {
		String hql = "FROM Car c WHERE c.carType.id = ?";
		return this.findEntityByHQL(hql, id);
	}

}
