package com.hdbank.bankingcore.service.event;

import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.event.Event;
import com.hdbank.bankingcore.producer.KafkaProducer;
import com.hdbank.bankingcore.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final KafkaProducer kafkaProducer;
    private final EventRepository eventRepository;

    @Override
    public void create(Event event) {
        eventRepository.save(event);
        kafkaProducer.send(event);
    }




}
