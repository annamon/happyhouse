package com.ssafy.happyhouse.dto;

public class LikeDto {
	String id;
	String no;
	
	public LikeDto() {
		super();
	}
	public LikeDto(String id, String no) {
		super();
		this.id = id;
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "LikeDto [id=" + id + ", no=" + no + "]";
	}
	
}
