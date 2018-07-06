package com.zyx.sfa.profiler;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundTxn implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("***** spring aop ***** LogAroundTxn: Method name: " + invocation.getMethod().getName());

		System.out.println("***** spring aop ***** LogAroundTxn: Method arguments: " + invocation.getArguments());
		System.out.println("***** spring aop ***** LogAroundTxn: Before method executing!");

		try {
			Object result = invocation.proceed();
			System.out.println("***** spring aop ***** LogAroundTxn: After  method executing!");
			return result;
		} catch (NullPointerException ex) {
			System.out
					.println("***** spring aop ***** LogAroundTxn:  When method throws exception!");
			throw ex;

		}

	}

}
