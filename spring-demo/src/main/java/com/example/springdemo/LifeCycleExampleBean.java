package com.example.springdemo;

public class LifeCycleExampleBean {
	public void init() {
		System.out.println("Called after initialization been performed! ");
	}
	public void cleanup() {
		System.out.println("Called when it is destroyed!");
	}


}
