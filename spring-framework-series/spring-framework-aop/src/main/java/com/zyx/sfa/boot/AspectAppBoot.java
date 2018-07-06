package com.zyx.sfa.boot;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.zyx.sfa.bo.BusinessTargetObject;

public class AspectAppBoot {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-configuration.xml").getPath());
		BusinessTargetObject target = context.getBean(BusinessTargetObject.class);
		target.sayHello();
		target.performTransaction("springframeworkaop");
		target.merryGoAround();
		target.throwException();
		context.close();
	}

}
