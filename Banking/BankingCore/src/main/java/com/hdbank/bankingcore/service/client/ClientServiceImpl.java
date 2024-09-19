package com.hdbank.bankingcore.service.client;

import com.hdbank.bankingcommon.domain.exception.ResourceNotFoundException;
import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcore.domain.dto.AccountResponse;
import com.hdbank.bankingcore.domain.dto.ClientRequest;
import com.hdbank.bankingcore.domain.dto.ClientResponse;
import com.hdbank.bankingcore.domain.dto.mapper.AccountMapper;
import com.hdbank.bankingcore.domain.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientCommandService commandService;
    private final AccountMapper accountMapper;

    private final ClientMapper clientMapper;

    @Transactional
    @Override
    public ClientResponse createClientWithAccount(ClientRequest clientRequest) {
        try {
            if (clientRequest.username() == null || clientRequest.username().isEmpty()) {
                throw new ResourceNotFoundException("Username cannot be null or empty.");
            }
            if (clientRequest.password() == null || clientRequest.password().isEmpty()) {
                throw new ResourceNotFoundException("Password cannot be null or empty.");
            }
            if (clientRequest.name() == null || clientRequest.name().isEmpty()) {
                throw new ResourceNotFoundException("Name cannot be null or empty.");
            }

            // Convert AccountRequest to Account entity
            Account account = accountMapper.toEntity(clientRequest.account());

            // Convert ClientRequest to Client entity
            Client client = clientMapper.toEntity(clientRequest, account);

            // Save Client and Account
            commandService.save(client);

            AccountResponse accountResponse = new AccountResponse(account.getBalance());
            return new ClientResponse(client.getUsername(), client.getName(), accountResponse);

        } catch (Exception e) {
            throw new RuntimeException("Failed ", e);
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
