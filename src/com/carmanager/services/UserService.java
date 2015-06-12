package com.carmanager.services;

import java.util.List;
import java.util.Set;

import org.springframework.validation.BindingResult;

import com.carmanager.entities.Page;
import com.carmanager.entities.User;

public interface UserService extends BaseService<User> {

	public User findByUsername(String username);

	public void createUser(User user);

	public void validate(User user, BindingResult bindingResult);

	public User findByEmail(String email);

	public User activeUserByEmail(String email, String activeCode);

	public Set<String> findRoles(String username);

	public Set<String> findPermissions(String username);

	public List<User> getAllAdmins();

	public Page<User> getGradeList(int pageNo, int pageSize);

	public Page<User> getScoreList(int pageNo, int pageSize);

}
