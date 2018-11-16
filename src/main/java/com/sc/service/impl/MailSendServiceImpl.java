package com.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.sc.entity.User;
import com.sc.service.MailSendService;

@Service
public class MailSendServiceImpl implements MailSendService {
	
	@Autowired
	private MailSender mailSender;
	
	/**
	 * 发送邮件
	 */
	@Override
	public void sendMail(User use) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("xiaoqingcaivip@163.com");
        message.setTo(use.getEmail());
        message.setSubject(use.getUsername());
        //这里暂时已用户名作为发送的内容
        message.setText(use.getUsername());
        mailSender.send(message);
	}

}
