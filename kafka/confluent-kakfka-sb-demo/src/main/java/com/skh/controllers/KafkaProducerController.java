package com.skh.controllers;

import com.skh.services.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProducerController {

    /*

    .\bin\windows\kafka-topics.bat --create --topic test-topic-1 --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092

    Below is for confluent docker:
    $ docker exec -it broker kafka-topics --create --topic test-topic-1 --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

     */
    private final KafkaProducerService producerService;

    public KafkaProducerController(
            KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/produce")
    public CompletableFuture<ResponseEntity<String>> produceMessage(
            @RequestParam("message") String message) {

        return producerService.sendMessage(message)
                .thenApply(result ->
                        ResponseEntity.ok(
                                "Message sent successfully to topic: "
                                        + result.getRecordMetadata().topic()
                        )
                );
    }
}