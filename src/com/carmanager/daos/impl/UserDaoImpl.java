package com.carmanager.daos.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.carmanager.entities.Page;
import com.carmanager.entities.User;
import com.carmanager.utils.ValidateUtils;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> {

	public User findByUsername(String username) {
		if (ValidateUtils.isValid(username)) {
			String hql = "FROM User WHERE username = ?";
			User user = (User) this.uniqueResult(hql, username);
			if (user != null) {
				user.getGrade().getGradeName();
			}
			return user;
		}
		return null;
	}

	public User findByEmail(String email) {
		if (ValidateUtils.isValid(email)) {
			String hql = "FROM User WHERE email = ?";
			User user = (User) this.uniqueResult(hql, email);
			if (user != null) {
				user.getGrade().getGradeName();
			}
			return user;
		}
		return null;
	}

	public List<User> getAllAdmins() {
		String hql = "FROM User u WHERE u.admin = true";
		return this.findEntityByHQL(hql);
	}

	public Page<User> getGradeList(int pageNo, int pageSize) {
		String hql = "FROM User u ORDER BY u.grade.id DESC";
		String hql2 = "SELECT count(*) FROM User";
		return this.listPage(hql, hql2, pageNo, pageSize);
	}

	public Page<User> getScoreList(int pageNo, int pageSize) {
		String hql = "FROM User u ORDER BY u.score DESC";
		String hql2 = "SELECT count(*) FROM User";
		return this.listPage(hql, hql2, pageNo, pageSize);
	}

}
