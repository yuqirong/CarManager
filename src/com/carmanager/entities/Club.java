package com.carmanager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Club extends BaseEntity{
	
	private static final long serialVersionUID = 8035736337219260785L;
	private String clubName;
	private String introduction;
	private String constitution;
	private Date createTime;
	private Set<ClubActivity> clubActivities = new HashSet<ClubActivity>();
	
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public String getConstitution() {
		return constitution;
	}
	public void setConstitution(String constitution) {
		this.constitution = constitution;
	}
	public Set<ClubActivity> getClubActivities() {
		return clubActivities;
	}
	public void setClubActivities(Set<ClubActivity> clubActivities) {
		this.clubActivities = clubActivities;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

}
