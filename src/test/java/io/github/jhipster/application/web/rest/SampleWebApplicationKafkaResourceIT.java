package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.SampleWebApplicationApp;
import io.github.jhipster.application.service.SampleWebApplicationKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = SampleWebApplicationApp.class)
public class SampleWebApplicationKafkaResourceIT {

    @Autowired
    private SampleWebApplicationKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        SampleWebApplicationKafkaResource kafkaResource = new SampleWebApplicationKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/sample-web-application-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
