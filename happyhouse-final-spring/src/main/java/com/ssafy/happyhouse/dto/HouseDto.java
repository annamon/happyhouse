package com.ssafy.happyhouse.dto;

import java.util.List;

public class HouseDto {
	String no;
	String lat;
	String lng;
	String dong;
	String aptName;
	String dealAmount;
	String area;
	String buildYear;
	
	public HouseDto() {
		super();
	}

	public HouseDto(String no, String lat, String lng, String dong, String aptName, String dealAmount, String area,
			String buildYear) {
		super();
		this.no = no;
		this.lat = lat;
		this.lng = lng;
		this.dong = dong;
		this.aptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.buildYear = buildYear;
	}

	public HouseDto(String no, String dong, String aptName, String dealAmount, String area, String buildYear) {
		super();
		this.no = no;
		this.dong = dong;
		this.aptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.buildYear = buildYear;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	@Override
	public String toString() {
		return "HouseDto [no=" + no + ", lat=" + lat + ", lng=" + lng + ", dong=" + dong + ", aptName=" + aptName
				+ ", dealAmount=" + dealAmount + ", area=" + area + ", buildYear=" + buildYear + "]";
	}

	
	
	
	
}
