package com.hdbank.bankingcommon.service.account;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements  AccountQueryService{

    private  final AccountRepository repository;


    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public Page<Account> findAll(Pageable pageable)
    {
        return null;
    }

    @Override
    public Account getById(long accountId){

        return repository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + accountId));
    }
}
