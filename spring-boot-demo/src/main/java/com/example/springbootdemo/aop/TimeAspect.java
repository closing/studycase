package com.example.springbootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	Logger LOGGER = LoggerFactory.getLogger(TimeAspect.class);

	@Around("execution(* com.example.springbootdemo.controller.JsonController..*(..))")
	public Object method(ProceedingJoinPoint pjp) throws Throwable {

		LOGGER.debug("========== Aspect ============");
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			LOGGER.debug("Arguments:" + arg);
		}

		long start = System.currentTimeMillis();

		Object object = pjp.proceed();

		LOGGER.debug("Aspect times:" + (System.currentTimeMillis() - start));

		return object;
	}
}
