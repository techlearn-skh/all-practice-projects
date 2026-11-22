package com.skh.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {
    private static final Logger log =
            LoggerFactory.getLogger(KafkaProducerService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topicName}")
    private String topicName;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public CompletableFuture<SendResult<String, String>> sendMessageSimple(
            String message) {
        String key = UUID.randomUUID().toString();
        return kafkaTemplate.send(topicName, key, message);
    }

    public CompletableFuture<SendResult<String, String>> sendMessage(
            String message) {

        String key = UUID.randomUUID().toString();

        return kafkaTemplate.send(topicName, key, message)
                .whenComplete((result, exception) -> {
                    if (exception == null) {
                        log.info("Message sent successfully. Topic: {}, Offset: {}",
                                result.getRecordMetadata().topic(), result.getRecordMetadata().offset());
                    } else {
                        log.error("Failed to send message to topic: {}", topicName, exception
                        );
                    }
                });
    }

}