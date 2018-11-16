package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public boolean login(String username,String pwd,String email) {
		//这里简单模拟正常注册，没有数据库交互
		//执行注册逻辑
		userService.login(username,pwd,email);
		return true;
	}
}
