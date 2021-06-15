package com.ssafy.happyhouse.dto;

public class HouseSearchDto {

	String city = null;
	String gugun = null;
	String dong = null;
	String word = null;
	public HouseSearchDto() {
		super();
	}
	public HouseSearchDto(String city, String gugun, String dong, String word) {
		super();
		this.city = city;
		this.gugun = gugun;
		this.dong = dong;
		this.word = word;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "HouseSearchDto [city=" + city + ", gugun=" + gugun + ", dong=" + dong + ", word=" + word + "]";
	}
	
	
	
	
}
