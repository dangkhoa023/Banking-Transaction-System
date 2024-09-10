package com.hdbank.bankingcore.domain.dto;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.TransactionStatus;

public record TransactionRequest
        (Account fromAccountId,
        Account toAccountId,
        Long amount,
        String description)
{
}
