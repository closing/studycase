package com.example.springdemo;

import java.beans.ConstructorProperties;

public class ExampleBean {
	private int years;
	private String ultimateAnswer;

	@ConstructorProperties({ "year", "ultimateAnswer" })
	public ExampleBean(int years, String ultimateAnswer) {
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public String getUltimateAnswer() {
		return ultimateAnswer;
	}

	public void setUltimateAnswer(String ultimateAnswer) {
		this.ultimateAnswer = ultimateAnswer;
	}
}
