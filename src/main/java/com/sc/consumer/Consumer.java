package com.sc.consumer;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.rabbitmq.client.Channel;
import com.sc.entity.User;
import com.sc.service.MailSendService;


/**
 * 消费的消费者 实现 MessageListener或ChannelAwareMessageListener(需手动确认的实现此接口)
 */

public class Consumer implements ChannelAwareMessageListener{
	
	private static final Logger log = LoggerFactory.getLogger(Consumer.class);
	
	@Autowired
	private MailSendService mailSendService;

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		try {
			if(StringUtils.isEmpty(new String(message.getBody(),"UTF-8"))) {
				return;
			}
			User user = (User) SerializationUtils.deserialize(message.getBody());
			log.info("消费者消费{}",user);
			//发送邮件
			mailSendService.sendMail(user);
			//手动确认
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
