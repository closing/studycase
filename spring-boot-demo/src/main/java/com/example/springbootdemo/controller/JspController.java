package com.example.springbootdemo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {

	@RequestMapping("hello")
	public String hello(Map<String, Object> map) {

		map.put("msg", "Hello JSP");
		return "hello";
	}
}
