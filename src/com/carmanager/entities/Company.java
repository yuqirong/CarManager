package com.carmanager.entities;

public class Company extends BaseEntity{

	private static final long serialVersionUID = 5545613676956829855L;
	
	private String companyName;
	private String description;
	private String address;
	private String map;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}

}
