package com.carmanager.entities;

import java.util.Date;

/**
 * 积分记录
 * 
 * @author Anyway
 *
 */
public class Record extends BaseEntity {

	private static final long serialVersionUID = -8148470490586481212L;
	private String operation;
	private int change; // 积分增加或减少
	private Date changeTime; // 时间
	private String details;
	private User user; // 用户
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getChange() {
		return change;
	}
	public void setChange(int change) {
		this.change = change;
	}
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
