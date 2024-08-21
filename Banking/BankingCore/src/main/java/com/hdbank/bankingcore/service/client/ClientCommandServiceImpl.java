package com.hdbank.bankingcore.service.client;

import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcommon.event.ClientCreateEvent;
import com.hdbank.bankingcore.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientCommandServiceImpl implements ClientCommandService{
    private final KafkaProducer kafkaProducer;

    @Override
    public void save(Client object) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        kafkaProducer.send(event);
    }
}
