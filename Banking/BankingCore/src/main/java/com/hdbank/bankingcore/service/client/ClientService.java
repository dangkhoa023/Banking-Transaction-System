package com.hdbank.bankingcore.service.client;

import ch.qos.logback.core.net.server.Client;
import com.hdbank.bankingcommon.service.ClientQueryService;
import org.springframework.stereotype.Service;

@Service
public interface ClientService extends ClientCommandService, ClientQueryService {
}
