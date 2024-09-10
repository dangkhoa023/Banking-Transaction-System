package com.hdbank.bankingeventhandler.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

//    @Override
//    @Transactional
//    public void createAccount(Account account) {
//        accountRepository.save(account);
//    }

    @Transactional
    @Override
    public void updateBalance(Account account){
        accountRepository.save(account);
    }
}
