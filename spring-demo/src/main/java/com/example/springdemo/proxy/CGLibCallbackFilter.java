package com.example.springdemo.proxy;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.springframework.cglib.proxy.CallbackFilter;

public class CGLibCallbackFilter implements CallbackFilter {

	@Override
	public int accept(Method arg0) {
		LocalDateTime dte = LocalDateTime.now();
		if ((dte.getMinute() % 2) == 0) {
			return 1;
		} else {

			return 0;
		}
	}

}
