package com.ssafy.happyhouse.dto;

public class UserDto {
	
	private String id;
	private String name;
	private String password;
	private String email;
	private String number;
	private String job;
	private String passhint;
	private String joindate;
	
	public UserDto() {
		super();
	}
	
	public UserDto(String id, String email, String passhint) {
		super();
		this.id = id;
		this.email = email;
		this.passhint = passhint;
	}

	public UserDto(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public UserDto(String id, String name, String password, String email, String number, String job, String passhint,
			String joindate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.number = number;
		this.job = job;
		this.passhint = passhint;
		this.joindate = joindate;
	}
	
	public UserDto(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPasshint() {
		return passhint;
	}
	public void setPasshint(String passhint) {
		this.passhint = passhint;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
