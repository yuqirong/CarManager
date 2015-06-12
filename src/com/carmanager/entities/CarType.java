package com.carmanager.entities;

import java.util.HashSet;
import java.util.Set;

public class CarType extends BaseEntity {

	private static final long serialVersionUID = 5730850531431011967L;
	private String typeName; // 车型
	private String introduction; // 介绍
	private String brand; // 品牌
	private String guidePrice; // 厂商指导价
	private String salePrice; // 本店报价
	private String stock; // 库存
	private String picture; // 图片
	private Set<Car> cars = new HashSet<Car>(); // 车

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
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

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
