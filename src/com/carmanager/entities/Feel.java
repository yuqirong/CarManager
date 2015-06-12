package com.carmanager.entities;

import java.util.Date;

public class Feel extends BaseEntity {

	private static final long serialVersionUID = 7608850202777454242L;
	private String content;
	private Date createTime;
	private User user;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
