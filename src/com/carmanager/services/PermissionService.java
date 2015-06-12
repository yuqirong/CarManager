package com.carmanager.services;

import java.util.Set;

import com.carmanager.entities.Permission;
import com.carmanager.entities.Role;

public interface PermissionService extends BaseService<Permission> {

	public Set<String> findPermissions(Set<Role> roles);

}
