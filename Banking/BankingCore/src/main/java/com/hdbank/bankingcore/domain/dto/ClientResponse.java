package com.hdbank.bankingcore.domain.dto;

public record ClientResponse(

        String username,
        String name,
        AccountResponse account
) {
}

