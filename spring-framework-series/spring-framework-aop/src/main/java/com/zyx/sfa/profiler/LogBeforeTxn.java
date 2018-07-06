package com.zyx.sfa.profiler;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeTxn implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("***** spring aop ***** LogBeforeTxn: Executing before method!");
	}

}
