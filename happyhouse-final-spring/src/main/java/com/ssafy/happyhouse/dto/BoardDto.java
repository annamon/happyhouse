package com.ssafy.happyhouse.dto;

public class BoardDto {
	String id;
	int no;
	String title;
	String content;
	String regtime;
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(String id, int no, String title, String content, String regtime) {
		super();
		this.id = id;
		this.no = no;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
	}

	public BoardDto(String id, int no, String title, String content) {
		super();
		this.id = id;
		this.no = no;
		this.title = title;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return "게시글 [id=" + id + ", title=" + title + "]";
	}
	
	
	
	
}
