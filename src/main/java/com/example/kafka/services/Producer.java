package com.example.kafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
public class Producer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	public void sendMsgToTopic(String message) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("message_topic", message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println(
						"Send message [" + message + "] with offset = [" + result.getRecordMetadata().offset() + "]");

			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("unable to send message [" + message + "] due to  : " + ex.getMessage());

			}

		});
	}
}
