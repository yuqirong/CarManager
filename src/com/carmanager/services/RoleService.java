package com.carmanager.services;

import java.util.Set;

import com.carmanager.entities.Role;

public interface RoleService extends BaseService<Role> {

	public Set<String> findRoles(Set<Role> set);

}
