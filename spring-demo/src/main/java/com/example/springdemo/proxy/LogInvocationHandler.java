package com.example.springdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {

	private Hello hello;

	public LogInvocationHandler(Hello hello) {
		this.hello = hello;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("Proxy: Before Say Hello!");
		return method.invoke(hello, args);
	}

}
