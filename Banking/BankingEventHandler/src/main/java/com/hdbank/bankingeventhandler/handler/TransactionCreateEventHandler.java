package com.hdbank.bankingeventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.event.TransactionCreateEvent;
import com.hdbank.bankingeventhandler.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEventHandler implements EventHandler{

    private final Gson gson;

    private final TransactionService transactionService;

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
