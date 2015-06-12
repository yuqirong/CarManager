package com.carmanager.converter;

import java.text.ParseException;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.carmanager.utils.DateUtils;

@Component
public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String str) {
		try {
			Date date = DateUtils.stringToDate(str);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
