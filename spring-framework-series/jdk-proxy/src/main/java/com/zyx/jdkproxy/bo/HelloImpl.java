package com.zyx.jdkproxy.bo;

public class HelloImpl implements IHello {

	@Override
	public void sayHello() {
		System.out.println("Hello JDK Proxy!");
	}

}
