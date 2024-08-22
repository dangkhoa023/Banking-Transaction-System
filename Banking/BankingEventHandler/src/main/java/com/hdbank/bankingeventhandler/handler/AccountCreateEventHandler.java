package com.hdbank.bankingeventhandler.handler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.event.AccountCreateEvent;
import com.hdbank.bankingeventhandler.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("ACCOUNT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService accountService;

    private final Gson gson;

    @Override
    public void process(JsonObject json) {
        AccountCreateEvent event = gson.fromJson(
                json,
                AccountCreateEvent.class
        );

        Account account = gson.fromJson(gson.toJson(event.getPayload()), Account.class);

        accountService.createAccount(account);
    }
}