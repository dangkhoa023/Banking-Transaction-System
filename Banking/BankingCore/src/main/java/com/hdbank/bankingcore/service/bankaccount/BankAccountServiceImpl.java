package com.hdbank.bankingcore.service.bankaccount;

import com.hdbank.bankingcommon.domain.model.BankAccount;
import com.hdbank.bankingcommon.event.BankAccountCreateEvent;
import com.hdbank.bankingcore.domain.dto.BankingAccountRequest;
import com.hdbank.bankingcore.domain.dto.mapper.BankAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{

    private  final BankAccountCommandService bankAccountCommandService;
    private final BankAccountMapper mapper;

    @Override
    public void createBankAccount(BankingAccountRequest newBankAccount) {
        BankAccount bankAccount = mapper.toEntity(newBankAccount);
        bankAccountCommandService.save(bankAccount);
    }

    @Override
    public BankAccount findById(Long id) {
        return null;
    }

    @Override
    public Page<BankAccount> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(BankAccount object) {

    }
}
