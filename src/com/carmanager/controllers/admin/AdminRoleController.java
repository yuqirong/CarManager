package com.carmanager.controllers.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmanager.entities.Role;
import com.carmanager.services.PermissionService;
import com.carmanager.services.RoleService;

@Controller
@RequestMapping("/admin/role")
public class AdminRoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getRoles(Map<String, Object> map) {
		map.put("roles", roleService.findAllEntities());
		return "role/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addRole(Map<String, Object> map) {
		map.put("role", new Role());
		map.put("permissions", permissionService.findAllEntities());
		return "role/add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRole(Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getObjectName() + " : "
						+ error.getDefaultMessage());
			}
		}
		roleService.saveEntity(role);
		return "redirect:/admin/role/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editRole(@PathVariable("id") int id, Map<String, Object> map) {
		map.put("role", roleService.getEntity(id));
		map.put("permissions", permissionService.findAllEntities());
		return "role/edit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	public String save(Role role, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				System.out.println(error.getObjectName() + " : "
						+ error.getDefaultMessage());
			}
		}
		roleService.updateEntity(role);
		return "redirect:/admin/role/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		roleService.deleteEntityById(id);
		return "redirect:/admin/role/list";
	}

}
