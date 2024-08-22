package com.hdbank.bankingcore.domain.dto;

import com.hdbank.bankingcommon.domain.model.TransactionStatus;

public record TransactionRequest
        (Long amount,
        String description)
{
}
