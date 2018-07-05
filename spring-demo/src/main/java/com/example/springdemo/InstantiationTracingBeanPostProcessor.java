package com.example.springdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
	Logger log = LoggerFactory.getLogger(BeanPostProcessor.class);

	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) {
		log.info("Bean '" + beanName + "' created : " + bean.toString());
		return bean;

	}
}
