package com.carmanager.entities;

public class FaultCode extends BaseEntity {

	private static final long serialVersionUID = 8578622588650057757L;
	private String code;
	private String information;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

}
