package com.carmanager.services;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.carmanager.entities.CarType;

public interface CarTypeService extends BaseService<CarType> {

	public void updateCarType(CarType carType, MultipartFile file,
			HttpSession httpSession);

}
