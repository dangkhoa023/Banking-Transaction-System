package com.hdbank.bankingcommon.service;

import com.hdbank.bankingcommon.domain.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryService {
    Transaction findById(Long id);

    Page<Transaction> findAll(Pageable pageable);

    List<Transaction> findAll();
}
