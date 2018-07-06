package com.zyx.sfa.profiler;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogResultsAfterTxn implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("***** spring aop ***** LogResultsAfterTxn: Executing after method return!");
	}

}
