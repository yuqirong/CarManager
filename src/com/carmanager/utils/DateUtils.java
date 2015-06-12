package com.carmanager.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;

public final class DateUtils {

	private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private DateUtils() {

	}

	/**
	 * 把String转换为Date
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String str) throws ParseException {
		if (ValidateUtils.isValid(str)) {
			DateFormat format = new SimpleDateFormat(TIME_FORMAT);
			Date date = (Date) format.parse(str);
			return date;
		}
		return null;
	}

	/**
	 * 把Date转换为String
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateToString(Date date) throws ParseException {
		if (date == null) {
			return null;
		}
		FastDateFormat dateFormat = FastDateFormat.getInstance(TIME_FORMAT);
		String str = dateFormat.format(date);
		return str;
	}

	/**
	 * 计算当前系统时间与方法参数Date的天数差
	 * 
	 * @param date
	 * @return
	 */
	public static long daysOfDateDifference(Date date) {
		long days = 0l;
		long difference = System.currentTimeMillis() - date.getTime();
		days = difference / (1000 * 60 * 60 * 24);
		return days;
	}
	

}
