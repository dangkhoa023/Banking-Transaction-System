package com.hdbank.bankingcore.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.event.AccountCreateEvent;
//import com.hdbank.bankingcore.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

//    private final KafkaProducer kafkaProducer;

    @Override
    public void save(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
//        kafkaProducer.send(event);
    }
}
