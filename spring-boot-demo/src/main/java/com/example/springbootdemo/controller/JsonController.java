package com.example.springbootdemo.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdemo.data.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "JsonTest", tags = { "Test API" })
@RestController
@RequestMapping("json")
@CrossOrigin(origins = "http://localhost:8088")
public class JsonController {

	@ApiOperation("Get UserInfo")
	@ApiImplicitParam(name = "name", value = "UserName", dataType = "String", paramType = "query")
	@RequestMapping(value = "user")
	@ResponseBody
	public User getUser() {
		User user = new User();
		user.setId(1);

		user.setUserName("Bob");
		user.setPassword("pass");
		user.setBirthday(new Date());
		return user;
	}

}
