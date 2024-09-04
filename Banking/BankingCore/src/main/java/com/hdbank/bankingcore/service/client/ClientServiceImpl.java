package com.hdbank.bankingcore.service.client;

import com.hdbank.bankingcommon.domain.exception.ResourceNotFoundException;
import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcommon.service.client.ClientQueryService;
import com.hdbank.bankingcore.domain.dto.ClientRequest;
import com.hdbank.bankingcore.domain.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientCommandService commandService;
//    private final ClientQueryService queryService;

    private final ClientMapper mapper;

    @Override
    public void createClient(ClientRequest newClient) {
        try {

            if (newClient.username() == null || newClient.username().isEmpty()) {
                throw new ResourceNotFoundException("Username cannot be null or empty.");
            }

            if (newClient.password() == null || newClient.password().isEmpty()) {
                throw new ResourceNotFoundException("Password cannot be null or empty.");
            }

            if (newClient.name() == null || newClient.name().isEmpty()) {
                throw new ResourceNotFoundException("Name cannot be null or empty.");
            }

            Client client = mapper.toEntity(newClient);
            commandService.save(client);

        } catch (ResourceNotFoundException exception) {
            throw exception;
        }
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Client object) {

    }
}
