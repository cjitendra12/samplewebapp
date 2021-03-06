package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.SampleWebApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sample-web-application-kafka")
public class SampleWebApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(SampleWebApplicationKafkaResource.class);

    private SampleWebApplicationKafkaProducer kafkaProducer;

    public SampleWebApplicationKafkaResource(SampleWebApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
