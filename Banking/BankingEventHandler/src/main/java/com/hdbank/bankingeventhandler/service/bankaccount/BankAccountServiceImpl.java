package com.hdbank.bankingeventhandler.service.bankaccount;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcommon.repository.AccountRepository;
import com.hdbank.bankingcommon.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor

public class BankAccountServiceImpl implements BankAccountService{
    private final BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public void createBankAccount (BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }
}


