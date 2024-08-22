package com.hdbank.bankingeventhandler.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventConsumer {
    @KafkaListener(topics = "banking", groupId = "banking-event-handler")
    public void consume(final String payload) {
        try {
            log.info("Received message: {}", payload);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
