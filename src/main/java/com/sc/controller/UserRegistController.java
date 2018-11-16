package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserRegistController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/regist", method=RequestMethod.POST)
	@ResponseBody
	public boolean regist(String username,String pwd,String email) {
		//这里简单模拟正常注册，没有数据库交互
		//执行注册逻辑
		userService.regist(username,pwd,email);
		return true;
	}
}
