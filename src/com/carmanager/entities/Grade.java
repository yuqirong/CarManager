package com.carmanager.entities;

/**
 * 等级
 * 
 * @author Anyway
 *
 */
public class Grade extends BaseEntity {

	private static final long serialVersionUID = -2231776183620547840L;
	private String gradeName;
	private String leastExperience;

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getLeastExperience() {
		return leastExperience;
	}

	public void setLeastExperience(String leastExperience) {
		this.leastExperience = leastExperience;
	}

}
