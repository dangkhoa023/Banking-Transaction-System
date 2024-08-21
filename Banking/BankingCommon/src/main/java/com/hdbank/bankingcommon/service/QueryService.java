package com.hdbank.bankingcommon.service;

import com.hdbank.bankingcommon.domain.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryService<T> {
    T findById(Long id);

    Page<T> findAll(Pageable pageable);

    List<T> findAll();
}
