package com.zyx.sfa.bo;

import org.springframework.stereotype.Component;

@Component
public class BusinessTargetObject {
	public String performTransaction(String arg) {
		System.out.println("Performing Txn for: " + arg);
		return "Transaction " + arg + " Successful";
	}

	public void merryGoAround() {
		System.out.println("Running merryGoAround for Business");
	}

	public void sayHello() {
		System.out.println("Hello says Hello...");
	}

	public void throwException() {
		System.out.println("Business class about throw an NPE..");
		throw new NullPointerException("Throwing custom Exception");

	}
}
