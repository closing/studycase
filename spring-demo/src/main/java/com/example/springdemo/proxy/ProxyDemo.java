package com.example.springdemo.proxy;

import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

public class ProxyDemo {

	public static void main(String[] args) {
		Hello helloProxy = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader(),
				new Class<?>[] { Hello.class }, new LogInvocationHandler(new HelloImp()));

		helloProxy.sayHello();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CGLibHello.class);
		enhancer.setCallbacks(new Callback[] { new MyMethodInterceptor(), NoOp.INSTANCE });
		enhancer.setCallbackFilter(new CGLibCallbackFilter());
		CGLibHello cglibHello = (CGLibHello) enhancer.create();
		cglibHello.sayHello();
	}

}
