package com.producer.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.producer.bean.Student;
import com.producer.service.ProducerService;

@RestController
public class KafkaController {

	@Autowired
	private ProducerService producerService;

	@PostMapping("/produce")
	public ResponseEntity<String> produce(@RequestParam String topicName, @RequestBody Student student)
			throws InterruptedException, ExecutionException {
		
		String successMessage = null;
		producerService.sendMessage(topicName, "Producing Student Details: " + student);
		successMessage = String.format(
				"Successfully produced student information to the '%s' topic. Please check the consumer.", topicName);
		return ResponseEntity.status(HttpStatus.OK).body(successMessage);
	}
}
