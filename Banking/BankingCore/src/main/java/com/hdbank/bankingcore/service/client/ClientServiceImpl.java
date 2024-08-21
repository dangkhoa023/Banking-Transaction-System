package com.hdbank.bankingcore.service.client;

import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcommon.service.ClientQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientQueryService queryService;
    private final ClientCommandService commandService;


    @Override
    public Client findById(Long id) {
        return queryService.findById(id);
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return queryService.findAll(pageable);
    }

    @Override
    public List<Client> findAll() {
        return queryService.findAll();
    }

    @Override
    public void save(Client object) {
        commandService.save(object);
    }
}
