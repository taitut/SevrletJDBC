package com.laptrinhjavaweb.model;


public class User extends abstractnodel <User> {


	private Long role;
	private String userName;
	private String password;
	private String fullname;
	private int status;



	public User() {
	}

	public User(Long role, String userName, String password, int status) {
		this.role = role;
		this.userName = userName;
		this.password = password;
		this.status = status;
	}

	

	

	public Long getRole() {
		return this.role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}
