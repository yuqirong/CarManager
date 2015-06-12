package com.carmanager.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carmanager.daos.impl.PermissionDaoImpl;
import com.carmanager.daos.impl.RoleDaoImpl;
import com.carmanager.entities.Role;
import com.carmanager.services.RoleService;
import com.carmanager.utils.ValidateUtils;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {

	@Autowired
	private RoleDaoImpl roleDao;
	@Autowired
	private PermissionDaoImpl permissionDao;

	@Override
	public Set<String> findRoles(Set<Role> roles) {
		if (ValidateUtils.isValid(roles)) {
			Set<String> rls = new HashSet<String>();
			for (Role role : roles) {
				rls.add(role.getRole());
			}
			return rls;
		}
		return null;
	}

}
