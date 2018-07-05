package com.example.springdemo;

public class HelloWorldBean {
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String sayHello() {
		return "Hello World!";
	}

}
