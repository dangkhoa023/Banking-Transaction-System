package com.hdbank.bankingcore.service.transaction;

import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.repository.AccountRepository;
import com.hdbank.bankingcore.domain.dto.TransactionRequest;
import com.hdbank.bankingcore.domain.dto.mapper.TransactionMapper;
import com.hdbank.bankingcore.service.account.AccountService;
import com.hdbank.bankingcore.service.bankaccount.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements  TransactionService {
    private final TransactionCommandService commandService;
    private final TransactionMapper mapper;
    private final AccountService accountService;
    private final BankAccountService bankAccountService;
    private final AccountRepository accountRepository;

    @Override
    public Transaction findById(Long id) {
        return null;
    }

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(Transaction object) {

    }

    @Override
    public void createTransaction(TransactionRequest newTransaction) {
        Transaction transaction = mapper.toEntity(newTransaction);
        commandService.save(transaction);
    }


}
