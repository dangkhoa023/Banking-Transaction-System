package com.hdbank.bankingcore.domain.dto.mapper;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcore.domain.dto.AccountRequest;
import com.hdbank.bankingcore.domain.dto.BankingAccountRequest;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccount toEntity(BankingAccountRequest request) {
        return BankAccount.builder()
                .account_id(request.account_id())
                .build();
    }
}
