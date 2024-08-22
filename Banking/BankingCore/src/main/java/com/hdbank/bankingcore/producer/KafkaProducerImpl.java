package com.hdbank.bankingcore.producer;

import com.hdbank.bankingcommon.event.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaProducerImpl implements KafkaProducer {

    // Gửi topic nào thì sẽ gửi event đó
    private final KafkaTemplate<String, Event> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topic;

    @Override
    public void send(Event event) {
        CompletableFuture<SendResult<String, Event>> future = kafkaTemplate.send(topic, event);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + event + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + event + "] due to : " + ex.getMessage());
            }
        });
    }
}
