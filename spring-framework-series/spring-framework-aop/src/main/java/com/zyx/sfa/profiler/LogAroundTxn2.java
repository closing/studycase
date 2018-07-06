package com.zyx.sfa.profiler;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundTxn2 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("***** spring aop ***** LogAroundTxn2: Method name: " + invocation.getMethod().getName());

		System.out.println("***** spring aop ***** LogAroundTxn2: Method arguments: " + invocation.getArguments());
		System.out.println("***** spring aop ***** LogAroundTxn2: Before method executing!");

		try {
			Object result = invocation.proceed();
			System.out.println("***** spring aop ***** LogAroundTxn2: After  method executing!");
			return result;
		} catch (NullPointerException ex) {
			System.out
					.println("***** spring aop ***** LogAroundTxn2:  When method throws exception!");
			throw ex;

		}

	}

}
