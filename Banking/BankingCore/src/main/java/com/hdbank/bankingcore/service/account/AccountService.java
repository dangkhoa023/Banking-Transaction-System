package com.hdbank.bankingcore.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.service.QueryService;
import com.hdbank.bankingcommon.service.account.AccountQueryService;
import com.hdbank.bankingcore.domain.dto.AccountRequest;
import com.hdbank.bankingcore.domain.dto.ClientRequest;
import com.hdbank.bankingcore.domain.dto.UpdateBalanceRequest;
import com.hdbank.bankingcore.service.CommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
   // void createAccount(AccountRequest newAccount);


    void updateBalance(UpdateBalanceRequest updateBalance);
    Account getById(long accountId);
}
