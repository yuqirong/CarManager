package com.carmanager.services.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.carmanager.daos.impl.CarTypeDaoImpl;
import com.carmanager.entities.CarType;
import com.carmanager.services.CarTypeService;

@Service("carTypeService")
public class CarTypeServiceImpl extends BaseServiceImpl<CarType> implements
		CarTypeService {

	@Autowired
	private CarTypeDaoImpl carTypeDao;

	@Override
	public void updateCarType(CarType carType, MultipartFile file,
			HttpSession httpSession) {
		try {
			if (!file.isEmpty()) {
				InputStream inputStream = file.getInputStream();
				ServletContext servletContext = httpSession.getServletContext();
				String realPath = servletContext.getRealPath("/");
				String picturePath = "/file/"
						+ System.currentTimeMillis()
						+ file.getOriginalFilename().substring(
								file.getOriginalFilename().lastIndexOf("."),
								file.getOriginalFilename().length());
				OutputStream outputStream = new FileOutputStream(realPath
						+ picturePath);
				byte[] buffer = new byte[1024];
				int length = 0;
				while ((length = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, length);
				}
				outputStream.close();
				inputStream.close();
				carType.setPicture(picturePath);
			}
			this.saveOrUpdateEntity(carType);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
