package com.hdbank.bankingcommon.service.bankaccount;

import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcommon.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountQueryServiceImpl implements BankAccountQueryService{

    private final BankAccountRepository repository;
    @Override
    public BankAccount findById(Long id) {
        return null;
    }

    @Override
    public Page<BankAccount> findAll(Pageable pageable) {
        return null;
    }
    @Override
    public BankAccount getById(long bank_account_id){
        return repository.findById(bank_account_id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + bank_account_id));
    }
}
