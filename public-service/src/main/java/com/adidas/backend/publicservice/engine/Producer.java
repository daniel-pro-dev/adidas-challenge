package com.adidas.backend.publicservice.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Value("${topic.name}")
    private String TOPIC;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean subscribeMessage(String email) {
        logger.info(String.format("Kafka producing message: " + email));
        return this.kafkaTemplate.send(TOPIC, email).isDone();
    }
}