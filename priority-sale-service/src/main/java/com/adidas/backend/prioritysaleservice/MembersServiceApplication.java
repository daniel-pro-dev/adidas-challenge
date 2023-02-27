package com.adidas.backend.prioritysaleservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class MembersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MembersServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}


	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("topic1")
				.partitions(10)
				.replicas(1)
				.build();
	}

	@KafkaListener(id = "myId", topics = "topic1")
	public void listen(String in) {
		System.out.println(in);
	}
}

