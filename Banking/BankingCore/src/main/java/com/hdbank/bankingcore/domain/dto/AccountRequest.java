package com.hdbank.bankingcore.domain.dto;

public record AccountRequest(
        long clientId,
        long balance
) {
}
