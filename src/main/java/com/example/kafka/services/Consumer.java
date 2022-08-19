package com.example.kafka.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

//	@KafkaListener(topics="message_topic",groupId="msg_group")
//	public void listenToTopic(String receivedMessage) {
//		System.out.println("The message recived is :"+receivedMessage);
//	}
}
