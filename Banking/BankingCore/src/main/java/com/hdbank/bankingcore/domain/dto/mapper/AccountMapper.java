package com.hdbank.bankingcore.domain.dto.mapper;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcore.domain.dto.AccountRequest;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account toEntity(AccountRequest request) {
        return Account.builder()
                .clientId(request.clientId())
                .balance(request.balance())
                .build();
    }
}
