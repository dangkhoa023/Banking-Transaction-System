package com.hdbank.bankingcore.service.client;

import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcommon.service.QueryService;
import com.hdbank.bankingcore.domain.dto.ClientRequest;
import com.hdbank.bankingcore.service.CommandService;
import org.springframework.transaction.annotation.Transactional;

public interface ClientService extends QueryService<Client>, CommandService<Client>{


    @Transactional
    void createClientWithAccount(ClientRequest clientRequest);
}
