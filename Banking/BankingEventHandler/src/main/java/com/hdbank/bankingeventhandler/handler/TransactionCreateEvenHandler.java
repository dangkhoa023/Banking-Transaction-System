package com.hdbank.bankingeventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.event.AccountCreateEvent;
import com.hdbank.bankingcommon.event.TransactionCreateEvent;
import com.hdbank.bankingeventhandler.service.account.AccountService;
import com.hdbank.bankingeventhandler.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEvenHandler implements EventHandler {

    private final TransactionService transactionService;
    private final Gson gson;

    @Override
    public void handle(JsonObject json) {
        TransactionCreateEvent event = gson.fromJson(
                json,
                TransactionCreateEvent.class
        );

        Transaction transaction = gson.fromJson(gson.toJson(event.getPayload()), Transaction.class);

        transactionService.createTransaction(transaction);

    }
}