package com.example.demo.controller;

import com.example.demo.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducerService kafkaProducerService;

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }
// create table in ksql server
//    CREATE STREAM demo_stream (
//        key VARCHAR,
//        value VARCHAR
//    ) WITH (
//    KAFKA_TOPIC='demo-topic',
//    VALUE_FORMAT='JSON'
//        );
// SELECT * FROM demo_stream EMIT CHANGES;

    @PostMapping("/publish")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        kafkaProducerService.sendMessage(topic, message);
        return "Message sent to topic " + topic;
    }
}
