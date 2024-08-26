package com.hdbank.bankingcore.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.event.AccountCreateEvent;
import com.hdbank.bankingcore.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {
    private AccountService accountService;
    private final EventService eventService;

    @Override
    public void save(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }


}
