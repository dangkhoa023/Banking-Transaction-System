package com.hdbank.bankingcore.service.event;

import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.event.Event;

public interface EventService {
    void create(Event event);
    void transferMoneyEvent(Transaction transfer);


}
