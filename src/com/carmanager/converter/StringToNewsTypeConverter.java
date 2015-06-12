package com.carmanager.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.carmanager.entities.NewsType;
import com.carmanager.services.NewsTypeService;

@Component
public class StringToNewsTypeConverter implements Converter<String,NewsType>{
	
	@Autowired
	private NewsTypeService newsTypeService;

	@Override
	public NewsType convert(String id) {
		NewsType newsType = newsTypeService.getEntity(Integer.valueOf(id));
		return newsType;
	}
	
	

}
