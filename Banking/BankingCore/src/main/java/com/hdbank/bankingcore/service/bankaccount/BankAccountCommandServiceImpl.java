package com.hdbank.bankingcore.service.bankaccount;

import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcommon.event.BankAccountCreateEvent;
import com.hdbank.bankingcommon.event.ClientCreateEvent;
import com.hdbank.bankingcore.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountCommandServiceImpl implements  BankAccountCommandService{

    private final EventService eventService;

    @Override
    public void save(BankAccount object) {
        BankAccountCreateEvent event = new BankAccountCreateEvent(object);
        eventService.create(event);
    }
}
