package com.nagarro.hrmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	@Column(name="userId")
	private int userId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="userName")
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Login(int userId, String password, String userName) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
