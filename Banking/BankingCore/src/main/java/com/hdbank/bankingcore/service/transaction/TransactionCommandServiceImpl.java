package com.hdbank.bankingcore.service.transaction;

import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.event.TransactionCreateEvent;
//import com.hdbank.bankingcore.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {
//    private final KafkaProducer kafkaProducer;

    @Override
    public void save(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
//        kafkaProducer.send(event);
    }
}
