package com.hdbank.bankingcommon.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.service.QueryService;

public interface AccountQueryService extends QueryService<Account> {
    Account findById(Long accountId);

    Account getById(long id);

   // Account findAccountById(Account accountId);

    Account findAccountById(Long accountId);
}
