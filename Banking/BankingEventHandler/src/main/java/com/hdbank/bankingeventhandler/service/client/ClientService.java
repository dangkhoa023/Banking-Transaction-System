package com.hdbank.bankingeventhandler.service.client;

import com.hdbank.bankingcommon.domain.model.Client;
import org.springframework.stereotype.Service;

public interface ClientService {
    void createClient(Client payload);
}
