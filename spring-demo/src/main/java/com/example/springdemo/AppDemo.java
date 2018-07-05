package com.example.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AppDemo {
	public static void main(String[] args) {
		//		Logger logger = LoggerFactory.getLogger(AppDemo.class);
		//		logger.info("Log:Hello World");
		//		System.out.println("#####################");
		//		System.out.println("Hello World!");
		//		System.out.println("#####################");
		ApplicationContext context = new ClassPathXmlApplicationContext("springdemo.xml");
		//		HelloWorldBean helloWorld = context.getBean("helloWorld", HelloWorldBean.class);
		//		System.out.println(helloWorld.sayHello() + " by " + helloWorld.toString());
		//		helloWorld.setState("Setted by HelloBean");
		//
		//		// alias
		//		HelloWorldBean hello = context.getBean("hello", HelloWorldBean.class);
		//		System.out.println(hello.sayHello() + " by " + hello.toString());
		//		ClientService clientService = context.getBean("clientService", ClientService.class);
		//		clientService.SayHello();
		//
		//		ClientService clientServiceLocator = context.getBean("clientServiceLocator", ClientService.class);
		//		clientServiceLocator.SayHello();
		//
		//		ExampleBean example = context.getBean("example", ExampleBean.class);
		//		System.out.println("Years:" + example.getYears() + " UltimateAnswer:" + example.getUltimateAnswer() + " by "
		//				+ example.toString());
		//
		//		ExampleBean indexExample = context.getBean("indexExample", ExampleBean.class);
		//		System.out.println("Years:" + indexExample.getYears() + " UltimateAnswer:" + indexExample.getUltimateAnswer()
		//				+ " by " + indexExample.toString());
		//
		//		ExampleBean nameExample = context.getBean("nameExample", ExampleBean.class);
		//		System.out.println("Years:" + nameExample.getYears() + " UltimateAnswer:" + nameExample.getUltimateAnswer()
		//				+ " by " + nameExample.toString());
		//
		//		OneExampleBean oneExample = context.getBean("oneExample", OneExampleBean.class);
		//		System.out.print("i: " + oneExample.getI() + "Another: " + oneExample.getAnotherExample().toString() + "Yet:"
		//				+ oneExample.getYetAnothorExample().toString());

		//		GenericApplicationContext genericContext = new GenericApplicationContext();
		//		new XmlBeanDefinitionReader(genericContext).loadBeanDefinitions("springdemo.xml");
		//		genericContext.refresh();
		//		helloWorld = genericContext.getBean("helloWorld", HelloWorldBean.class);
		//		System.out.println(helloWorld.sayHello() + " by " + helloWorld.toString());
		//		LifeCycleExampleBean exampleBean = genericContext.getBean("lifeCycleExampleBean", LifeCycleExampleBean.class);
		//		System.out.println(exampleBean.toString());
		HelloWorldBean helloWorld = context.getBean("helloWorld", HelloWorldBean.class);
		System.out.println(helloWorld);
	}
}
