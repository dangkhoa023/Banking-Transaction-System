package com.hdbank.bankingcore.domain.dto.mapper;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcore.domain.dto.ClientRequest;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public Client toEntity(ClientRequest request, Account account) {
        return Client.builder()
                .username(request.username())
                .password(request.password())
                .name(request.name())
                .account(account)
                .build();
    }
}