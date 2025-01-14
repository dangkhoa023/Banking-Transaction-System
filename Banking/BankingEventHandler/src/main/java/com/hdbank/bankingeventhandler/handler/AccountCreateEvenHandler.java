package com.hdbank.bankingeventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.event.AccountCreateEvent;
import com.hdbank.bankingeventhandler.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEvenHandler implements EventHandler {

    private final AccountService accountService;
    private final Gson gson;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void handle(JsonObject json) {
        AccountCreateEvent event = gson.fromJson(json, AccountCreateEvent.class);

        Account account = gson.fromJson(gson.toJson(event.getPayload()), Account.class);

        accountService.updateBalance(account);

        String successMessage = "UPDATE BALANCE " + account.getAccountId() + " succeeded.";
        kafkaTemplate.send("UPDATE_SUCCESS", successMessage);
    }

}