package com.skh.standalone;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;
import java.util.Properties;

public class SimpleProducer {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);


            ProducerRecord<String, String> record =
                    new ProducerRecord<>("test-topic",  LocalDateTime.now().getMinute()+"", LocalDateTime.now().toString());

            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.println("Sent to partition "
                            + metadata.partition());
                } else {
                    exception.printStackTrace();
                }
            });


        producer.close();
    }
}
