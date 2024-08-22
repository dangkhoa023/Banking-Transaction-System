package com.hdbank.bankingcore.service.transaction;

import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.event.TransactionCreateEvent;
import com.hdbank.bankingcore.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {
    private final EventService eventService;

    @Override
    public void save(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}

