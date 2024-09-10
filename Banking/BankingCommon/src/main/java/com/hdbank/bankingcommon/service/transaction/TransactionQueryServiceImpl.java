package com.hdbank.bankingcommon.service.transaction;

import com.hdbank.bankingcommon.domain.exception.ResourceNotFoundException;
import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.repository.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class TransactionQueryServiceImpl implements TransactionQueryService {

    private AccountRepository repository;


    @Override
    public Transaction findById(Long id) {
        return null;
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return null;
    }



}
