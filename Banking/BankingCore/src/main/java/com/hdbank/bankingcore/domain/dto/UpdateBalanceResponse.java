package com.hdbank.bankingcore.domain.dto;

public record UpdateBalanceResponse(
        long accountId,

        long newBalance){
}
