package com.zyx.jdkproxy.invocations;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloInvocation implements InvocationHandler {

	private Object target;

	public HelloInvocation(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("===== Before Invocation! =====");
		Object result;
		result = method.invoke(target, args);
		System.out.println("===== After Invocation! =====");
		return result;
	}

}
