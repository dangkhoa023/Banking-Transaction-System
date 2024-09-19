package com.hdbank.bankingcore.domain.dto;

public record TransactionResponse (
        Long fromAccountId,
        long fromAccountNewBalance,
        Long toAccountId,
        long toAccountNewBalance,
        String status,
        String message
){
}
