package io.github.jhipster.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SampleWebApplicationKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(SampleWebApplicationKafkaConsumer.class);
    private static final String TOPIC = "topic_samplewebapplication";

    @KafkaListener(topics = "topic_samplewebapplication", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
