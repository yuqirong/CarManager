package com.carmanager.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;

import com.carmanager.utils.StringUtils;

public class OAKeyGenerator implements KeyGenerator {
	@Override
	public Object generate(Object arg0, Method arg1, Object... arg2) {
		String className = arg0.getClass().getSimpleName();
		String mname = arg1.getName();
		String params = StringUtils.arr2String(arg2);
		String key = className + "@" + arg0.hashCode() + "." + mname + "("
				+ params + ")";
		return key;
	}

}
