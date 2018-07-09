package com.zyx.jdkproxy.boot;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import com.zyx.jdkproxy.bo.HelloImpl;
import com.zyx.jdkproxy.bo.IHello;
import com.zyx.jdkproxy.invocations.HelloInvocation;

public class ProxyAppBoot {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class proxyHello = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
		Constructor constructorHello = proxyHello.getConstructor(InvocationHandler.class);
		IHello iHello = (IHello) constructorHello.newInstance(new HelloInvocation(new HelloImpl()));
		iHello.sayHello();


	}

}
