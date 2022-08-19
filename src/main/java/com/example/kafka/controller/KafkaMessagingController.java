package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.services.Producer;

@RestController
@RequestMapping("/rest/api")
public class KafkaMessagingController {

	@Autowired
	Producer prodeucer;

	@GetMapping("/producerMessage")
	public void getMessageFromProducer(@RequestParam("message") String message) {
		prodeucer.sendMsgToTopic(message);
	}

}
