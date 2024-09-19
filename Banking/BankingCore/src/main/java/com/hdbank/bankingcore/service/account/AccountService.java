package com.hdbank.bankingcore.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.service.QueryService;
import com.hdbank.bankingcore.domain.dto.UpdateBalanceRequest;
import com.hdbank.bankingcore.domain.dto.UpdateBalanceResponse;
import com.hdbank.bankingcore.service.CommandService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
   // void createAccount(AccountRequest newAccount);


    UpdateBalanceResponse updateBalance(UpdateBalanceRequest updateBalance);
    Account getById(long accountId);
}
