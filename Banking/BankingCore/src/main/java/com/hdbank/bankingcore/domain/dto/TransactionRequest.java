package com.hdbank.bankingcore.domain.dto;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.TransactionStatus;

public record TransactionRequest
        (Long amount,
        Account toAccountId,
        Account fromAccountId,
        String description)
{
}
