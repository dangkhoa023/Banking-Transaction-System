package com.hdbank.bankingeventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hdbank.bankingcommon.domain.exception.ResourceNotFoundException;
import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.domain.model.TransactionStatus;
import com.hdbank.bankingcommon.event.TransactionCreateEvent;
import com.hdbank.bankingeventhandler.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;


@Service("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEvenHandler implements EventHandler {

    private final TransactionService transactionService;
    private final Gson gson;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void handle(JsonObject json) {
        TransactionCreateEvent event = gson.fromJson(
                json,
                TransactionCreateEvent.class
        );

        Transaction transaction = gson.fromJson(gson.toJson(event.getPayload()), Transaction.class);
        transaction.setStatus(TransactionStatus.valueOf(transaction.getStatus().name())); // back enum ve dung kieu

        try {

            transactionService.transferMoney(transaction);

            String successMessage = "Transaction " + transaction.getTransactionId() + " succeeded.";
            kafkaTemplate.send("TRANSACTION_SUCCESS", successMessage);

        } catch (ResourceNotFoundException e) {

            transaction.setStatus(TransactionStatus.FAILED);

            String failureMessage = "Transaction " + transaction.getTransactionId() + " failed: " + e.getMessage();
            kafkaTemplate.send("TRANSACTION_FAILED", failureMessage);

        }
    }
}
