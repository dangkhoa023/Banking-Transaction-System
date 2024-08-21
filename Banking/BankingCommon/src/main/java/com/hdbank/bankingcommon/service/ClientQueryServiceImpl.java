package com.hdbank.bankingcommon.service;

import com.hdbank.bankingcommon.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientQueryServiceImpl implements ClientQueryService {
    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }
}
