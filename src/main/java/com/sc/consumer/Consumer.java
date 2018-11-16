package com.sc.consumer;

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
	
	@Autowired
	private MailSendService mailSendService;

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		try {
			if(StringUtils.isEmpty(new String(message.getBody(),"UTF-8"))) {
				return;
			}
			User user = (User) SerializationUtils.deserialize(message.getBody());
			System.out.println("消费者消费："+user);
			mailSendService.sendMail(user);
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}