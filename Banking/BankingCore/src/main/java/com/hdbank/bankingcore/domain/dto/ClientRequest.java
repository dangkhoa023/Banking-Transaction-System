package com.hdbank.bankingcore.domain.dto;

public record ClientRequest(
        String username,
        String password,
        String name
) {
}
