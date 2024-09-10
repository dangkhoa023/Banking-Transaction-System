package com.hdbank.bankingcore.domain.dto;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.TransactionStatus;

public record TransactionRequest
        (Long fromAccountId,
        Long toAccountId,
        Long amount,
        String description)
{
}
