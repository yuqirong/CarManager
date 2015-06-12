package com.carmanager.entities;

import java.util.Date;

public class ClubActivity extends BaseEntity{
	
	private static final long serialVersionUID = 8544343526743888686L;
	private String activityName;
	private String content;
	private Date startTime;
	private Date createTime;
	private Date deadline;
	
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	

}
