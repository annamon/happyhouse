package com.ssafy.happyhouse.help;

public class LoginAlert {
	private String message;
	private String id;
	private String name;
	private boolean canLogin = false;
	
	public LoginAlert() {
		super();
	}
	public LoginAlert(String message, String id, String name, boolean canLogin) {
		super();
		this.message = message;
		this.id = id;
		this.name = name;
		this.canLogin = canLogin;
	}
	public LoginAlert(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public boolean isCanLogin() {
		return canLogin;
	}
	public void setCanLogin(boolean canLogin) {
		this.canLogin = canLogin;
	}
	
	
	
	
}
