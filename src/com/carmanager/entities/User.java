package com.carmanager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 会员
 * 
 * @author Anyway
 *
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = 1891766086629980881L;
	@NotEmpty
	private String username; // 用户名
	@NotEmpty
	private String password; // 密码
	private String confirmPassword;
	private String salt; // 加盐
	@NotEmpty
	@Email
	private String email; // email
	private boolean enabled = true; // 是否启用
	private int loginFailureCount = 0; // 失败登录次数
	private Date lockedTime; // 锁定时间
	private String ipAddress; // ip地址
	private Date loginTime; // 登陆时间
	private Grade grade; // 等级
	private int experience; //经验
	private int score = 0; // 积分
	private int gender = 1; // 性别   1：male 0：female
	@NotEmpty
	private String phone; // 电话号码
	private String description; // 简介
	private Date createTime = new Date(); // 创建时间
	private int state = 0; //状态   1：激活  0：未激活
	private String activeCode; //激活码
	private Date activeTime; //激活时间
	private Set<Role> roles = new HashSet<Role>(); //角色
	private boolean admin = false; //是否为admin
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public int getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(int loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public Date getLockedTime() {
		return lockedTime;
	}

	public void setLockedTime(Date lockedTime) {
		this.lockedTime = lockedTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public Date getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
