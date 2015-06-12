package com.carmanager.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.carmanager.entities.Permission;
import com.carmanager.services.PermissionService;
import com.carmanager.utils.ValidateUtils;

@Component
public class StringArrToPermissionConverter implements
		Converter<String[], Set<Permission>> {

	@Autowired
	private PermissionService permissionService;

	@Override
	public Set<Permission> convert(String[] arr) {
		if (ValidateUtils.isValid(arr)) {
			Set<Permission> permissions = new HashSet<Permission>();
			for (int i = 0; i < arr.length; i++) {
				Integer id = Integer.parseInt(arr[i]);
				Permission permission = permissionService.getEntity(id);
				permissions.add(permission);
			}
			return permissions;
		}
		return null;
	}

}
