package com.hdbank.bankingcore.producer;

import com.hdbank.bankingcommon.event.Event;
import org.springframework.stereotype.Service;

@Service
public interface KafkaProducer {
    void send(Event event);
}
