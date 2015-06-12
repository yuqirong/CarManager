package com.carmanager.utils;

import java.util.Collection;

public final class ValidateUtils {

	private ValidateUtils() {

	}

	/**
	 * 判断字符串的有效性
	 */
	public static boolean isValid(String str) {
		if (str == null || "".equals(str.trim())) {
			return false;
		}
		return true;
	}

	/**
	 * 判断Integer的有效性
	 */
	public static boolean isValid(Integer id) {
		if (id == null || id < 0) {
			return false;
		}
		return true;
	}

	/**
	 * 判断集合的有效性
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(Collection collection) {
		if (collection == null || collection.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * 判断数组是否有效
	 */
	public static boolean isValid(Object[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		return true;
	}

}
