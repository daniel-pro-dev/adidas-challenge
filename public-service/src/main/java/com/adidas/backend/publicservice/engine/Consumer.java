package com.adidas.backend.publicservice.engine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "${topic.name}", groupId = "group-id")
    public boolean consume(String message) throws IOException {
        logger.info(String.format("Kafka produced message: " + message));

        return true;
    }
}