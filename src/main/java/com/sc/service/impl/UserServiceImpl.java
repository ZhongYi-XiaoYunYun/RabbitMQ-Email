package com.sc.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.entity.User;
import com.sc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendEmailToUser(String text) {
        
    }

	@Override
	public void regist(String username, String pwd, String email) {
		//TODO 执行注册的业务逻辑，这里主要是介绍消息队列发送邮件，这里就忽略
		//TODO 注册成功发送消息到注册这邮箱
		User user = new User(username, pwd, email);
		rabbitTemplate.convertAndSend("info", user);
	}
}
