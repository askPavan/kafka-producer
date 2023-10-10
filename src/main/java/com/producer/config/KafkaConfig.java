package com.producer.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	
	public static final String FIRST_TOPIC = "student-enrollments";
	public static final String SECOND_TOPIC = "student-grades";
	public static final String THIRD_TOPIC = "student-achievements";

	@Bean
	List<NewTopic> topics() {
	    List<String> topicNames = Arrays.asList(FIRST_TOPIC, SECOND_TOPIC, THIRD_TOPIC);
	    return topicNames.stream()
	        .map(topicName -> TopicBuilder.name(topicName).build())
	        .collect(Collectors.toList());
	}
	
}
