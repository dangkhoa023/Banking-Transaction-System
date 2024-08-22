package com.hdbank.bankingeventhandler.service.client;

import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcommon.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }
}
