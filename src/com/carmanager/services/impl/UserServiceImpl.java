package com.carmanager.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.carmanager.daos.impl.UserDaoImpl;
import com.carmanager.entities.Page;
import com.carmanager.entities.Role;
import com.carmanager.entities.User;
import com.carmanager.services.GradeService;
import com.carmanager.services.PermissionService;
import com.carmanager.services.RoleService;
import com.carmanager.services.UserService;
import com.carmanager.utils.DataUtils;
import com.carmanager.utils.DateUtils;
import com.carmanager.utils.ValidateUtils;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	/**
	 * 根据用户名查找用户
	 */
	@Override
	public User findByUsername(String username) {
		if (ValidateUtils.isValid(username)) {
			return userDao.findByUsername(username);
		}
		return null;
	}

	/**
	 * 根据Email查找用户
	 */
	@Override
	public User findByEmail(String email) {
		if (ValidateUtils.isValid(email)) {
			return userDao.findByEmail(email);
		}
		return null;
	}

	/**
	 * 创建用户
	 */
	@Override
	public void createUser(User user) {
		user.setState(0);
		user.setActiveCode(DataUtils.stringCode());
		user.setGrade(gradeService.getEntity(1));
		passwordHelper.encryptPassword(user); // 加密密码
		userDao.saveEntity(user);
	}

	/**
	 * 用户注册校检
	 */
	@Override
	public void validate(User user, BindingResult bindingResult) {
		if (!ValidateUtils.isValid(user.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword",
					"NotEmpty.user.confirmPassword");
			return;
		}
		if (user.getPhone().length() != 11) {
			bindingResult.rejectValue("phone", "Length.user.phone");
			return;
		}
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			bindingResult.rejectValue("password", "Match.user.password");
			return;
		}
		if (!(user.getUsername().length() >= 4 && user.getUsername().length() <= 8)) {
			bindingResult.rejectValue("username", "Length.user.username");
			return;
		}
		if (!(user.getPassword().length() >= 6 && user.getPassword().length() <= 16)) {
			bindingResult.rejectValue("password", "Length.user.password");
			return;
		}
		if (this.findByUsername(user.getUsername()) != null) {
			bindingResult.rejectValue("username", "Occupy.user.username");
			return;
		}
		if (this.findByEmail(user.getEmail()) != null) {
			bindingResult.rejectValue("email", "Occupy.user.email");
			return;
		}
	}

	@Override
	public User activeUserByEmail(String email, String activeCode) {
		User user = this.findByEmail(email);
		long days = DateUtils.daysOfDateDifference(user.getCreateTime());
		if (user != null && user.isEnabled() == true && user.getState() == 0
				&& user.getActiveCode().equals(activeCode) && days <= 2) {
			user.setState(1);
			user.setActiveTime(new Date());
			this.updateEntity(user);
			return user;
		}
		return null;
	}

	@Override
	public Set<String> findRoles(String username) {
		User user = this.findByUsername(username);
		if (user == null) {
			return null;
		}
		for (Role role : user.getRoles()) {
			role.getRole();
			System.out.println(role.getRole());
		}
		return roleService.findRoles(user.getRoles());
	}

	@Override
	public Set<String> findPermissions(String username) {
		User user = this.findByUsername(username);
		if (user == null) {
			return null;
		}
		for (Role role : user.getRoles()) {
			role.getRole();
		}
		return permissionService.findPermissions(user.getRoles());
	}

	@Override
	public List<User> getAllAdmins() {
		return userDao.getAllAdmins();
	}

	@Override
	public Page<User> getGradeList(int pageNo, int pageSize) {
		Page<User> p = userDao.getGradeList(pageNo, pageSize);
		for (User user : p.getList()) {
			user.getGrade().getGradeName();
		}
		return p;
	}

	@Override
	public Page<User> getScoreList(int pageNo, int pageSize) {
		Page<User> p = userDao.getScoreList(pageNo, pageSize);
		return p;
	}
}
