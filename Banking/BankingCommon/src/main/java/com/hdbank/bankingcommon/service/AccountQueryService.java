package com.hdbank.bankingcommon.service;

import com.hdbank.bankingcommon.domain.model.Account;

public interface AccountQueryService extends QueryService<Account> {
    Account findById(Long id);
}
