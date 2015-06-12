package com.carmanager.entities;

import java.util.Date;

public class Car extends BaseEntity {

	private static final long serialVersionUID = 6558828827656056765L;
	private String carName; //车名
	private String guidePrice; //指导价
	private String salePrice; //本店报价
	private String listTime; //上市时间
	private String type; //级别
	private String displacement; //排量
	private Date priceTime; //报价时间
	private CarType carType; //车型
	private String picture; //图片
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getGuidePrice() {
		return guidePrice;
	}
	public void setGuidePrice(String guidePrice) {
		this.guidePrice = guidePrice;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public Date getPriceTime() {
		return priceTime;
	}
	public void setPriceTime(Date priceTime) {
		this.priceTime = priceTime;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public CarType getCarType() {
		return carType;
	}
	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	public String getListTime() {
		return listTime;
	}
	public void setListTime(String listTime) {
		this.listTime = listTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDisplacement() {
		return displacement;
	}
	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

}
