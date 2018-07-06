package com.zyx.sfa.profiler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Profiler {

	@Before("execution(* com.zyx.sfa.bo.BusinessTargetObject.sayHello(..))")
	public void logBeforeTxn(JoinPoint joinPoint) {
		System.out.println("Beginning execution for " + joinPoint.getSignature().getName());

	}

	@After("execution(* com.zyx.sfa.bo.BusinessTargetObject.sayHello(..))")
	public void logAfterTxn(JoinPoint joinPoint) {
		System.out.println("Execution completed for " + joinPoint.getSignature().getName());
	}

	@Around("execution(* com.zyx.sfa.bo.BusinessTargetObject.merryGoAround(..))")
	public void logAroundTxn(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Beginning execution for " + proceedingJoinPoint.getSignature().getName());
		proceedingJoinPoint.proceed();
		System.out.println("Execution completed for " + proceedingJoinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut = "execution(* com.zyx.sfa.bo.BusinessTargetObject.performTransaction(..))", returning = "retVal")
	public void logResultsAfterTxn(JoinPoint joinPoint, Object retVal) {
		System.out.println("Execution completed for " + joinPoint.getSignature().getName());
		System.out.println("Value being returned is " + retVal);

	}

	@AfterThrowing(pointcut = "execution(* com.zyx.sfa.bo.BusinessTargetObject.throwException(..))", throwing = "exception")
	public void logResultsAfterError(JoinPoint joinPoint, Throwable exception) {
		System.out.println("Exception completed for " + joinPoint.getSignature().getName());
		System.out.println("Error in Join Point due to " + exception.getMessage());
		System.out.println("Advice complete");
	}

}
