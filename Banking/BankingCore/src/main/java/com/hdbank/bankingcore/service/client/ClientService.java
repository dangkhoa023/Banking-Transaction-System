package com.hdbank.bankingcore.service.client;

import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcommon.service.ClientQueryService;
import com.hdbank.bankingcommon.service.QueryService;
import com.hdbank.bankingcore.service.CommandService;
import org.springframework.stereotype.Service;

@Service
public interface ClientService extends QueryService<Client>, CommandService<Client> {
}
