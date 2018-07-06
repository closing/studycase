package com.zyx.sfa.profiler;

import org.springframework.aop.ThrowsAdvice;

public class LogResultsAfterError implements ThrowsAdvice {

	public void afterThrowing(NullPointerException e) throws Throwable {

		System.out
				.println("***** spring aop ***** LogResultsAfterError: Executing when method throws exception!");
	}

}
