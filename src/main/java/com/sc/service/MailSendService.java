package com.sc.service;

import com.sc.entity.User;

public interface MailSendService {
	
	void sendMail(User user);
}
