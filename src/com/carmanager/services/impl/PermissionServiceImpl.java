package com.carmanager.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.PermissionDaoImpl;
import com.carmanager.entities.Permission;
import com.carmanager.entities.Role;
import com.carmanager.services.PermissionService;
import com.carmanager.utils.ValidateUtils;

@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Permission>
		implements PermissionService {

	@Autowired
	private PermissionDaoImpl permissionDao;

	@Override
	public Set<String> findPermissions(Set<Role> roles) {
		if (ValidateUtils.isValid(roles)) {
			Set<String> ps = new HashSet<String>();
			for (Role role : roles) {
				for (Permission p : role.getPermissions()) {
					ps.add(p.getPermission());
				}
			}
			return ps;
		}
		return null;
	}

}
