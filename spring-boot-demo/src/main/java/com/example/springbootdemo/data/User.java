package com.example.springbootdemo.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private String userName;
	private String password;
	private Integer id;
	private Date birthday;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	@JsonFormat(pattern = "yyyy/MM/dd")
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
