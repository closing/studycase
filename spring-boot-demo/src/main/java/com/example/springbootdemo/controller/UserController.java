package com.example.springbootdemo.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping(value = "/springbootdemo")
public class UserController {

	@RequestMapping(value = "/getUserByGet", method = RequestMethod.GET)
	public String getUserByGet(@RequestParam(value = "userName") String userName) {
		return "hello " + userName;
	}

	@RequestMapping(value = "/getUserByPost", method = RequestMethod.POST)
	public String getUserByPost(@RequestParam(value = "userName") String userName) {
		return "Hello " + userName;
	}

	@RequestMapping(value = "/getUserByJson", method = RequestMethod.POST)
	public String getUserByJson(@RequestBody String data) {
		return "Json is " + data;
	}
}
