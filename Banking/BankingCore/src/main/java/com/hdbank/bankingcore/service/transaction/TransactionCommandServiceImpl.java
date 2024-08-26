package com.hdbank.bankingcore.service.transaction;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.event.TransactionCreateEvent;
import com.hdbank.bankingcore.service.account.AccountService;
import com.hdbank.bankingcore.service.bankaccount.BankAccountService;
import com.hdbank.bankingcore.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {
    private final AccountService accountService;
    private final EventService eventService;
    private final BankAccountService bankAccountService;
    @Override
    public void save(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }


//    @Override
//    public void create(
//            final Transaction object
//    ) {
//        BankAccount from = bankAccountService.getById(
//                object.getFrom().getNumber(),
//                object.getFrom().getDate(),
//                object.getFrom().getCvv()
//        );
//        Account to = accountService.getByNumberAndDate(
//                object.getTo().getNumber(),
//                object.getTo().getDate()
//        );
//        object.setFrom(from);
//        object.setTo(to);
//        TransactionCreateEvent event = new TransactionCreateEvent(object);
//        eventService.create(event);
//    }
}


