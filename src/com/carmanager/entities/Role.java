package com.carmanager.entities;

import java.util.HashSet;
import java.util.Set;

public class Role extends BaseEntity {

	private static final long serialVersionUID = 1698039731536838628L;
	private String role; // 角色标识 程序中判断使用,如"admin"
	private String description; // 角色描述,UI界面显示使用
	private boolean available = false; // 是否可用
	private Set<Permission> permissions = new HashSet<Permission>(); // 权限
	private boolean inherent = false; // 是否内置

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public boolean isInherent() {
		return inherent;
	}

	public void setInherent(boolean inherent) {
		this.inherent = inherent;
	}

}
