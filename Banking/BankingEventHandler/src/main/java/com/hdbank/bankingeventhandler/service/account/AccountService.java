package com.hdbank.bankingeventhandler.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface AccountService {
    //void createAccount(Account account);


    void updateBalance(Account payload);
}
