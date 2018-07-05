package com.example.springdemo.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppBoot {
	static Logger log = LoggerFactory.getLogger(AppBoot.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MyService myService = context.getBean(MyService.class);
		log.info(myService.toString());
		context.close();

	}

}
