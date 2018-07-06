package com.zyx.sfa.boot;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.zyx.sfa.bo.BusinessTargetObject;

public class SpringAopBoot {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("spring-xml-configuration.xml").getPath());
		BusinessTargetObject target = (BusinessTargetObject) context.getBean("simpleServiceProxy");
		target.sayHello();
		target.performTransaction("spring aop");
		target.throwException();
		context.close();
	}

}
