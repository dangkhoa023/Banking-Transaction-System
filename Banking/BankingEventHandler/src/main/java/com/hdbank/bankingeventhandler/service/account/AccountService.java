package com.hdbank.bankingeventhandler.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import org.springframework.stereotype.Service;

public interface AccountService {
    void createAccount(Account account);
}
