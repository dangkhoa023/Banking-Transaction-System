package com.hdbank.bankingcore.service.transaction;

import com.hdbank.bankingcommon.domain.exception.ResourceNotFoundException;
import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.domain.model.TransactionStatus;
import com.hdbank.bankingcommon.repository.AccountRepository;
import com.hdbank.bankingcommon.service.account.AccountQueryService;
import com.hdbank.bankingcommon.service.transaction.TransactionQueryService;
import com.hdbank.bankingcore.domain.dto.TransactionRequest;
import com.hdbank.bankingcore.domain.dto.mapper.TransactionMapper;
import com.hdbank.bankingcore.service.account.AccountService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements  TransactionService {
    private final TransactionCommandService commandService;
    private final TransactionMapper mapper;
    private final AccountQueryService accountQueryService;

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

    @Transactional
    @Override
    public void transferMoney(TransactionRequest request) {
        // Lấy thông tin tài khoản gửi và nhận qua AccountQueryService
        Account fromAccount = accountQueryService.findAccountById(request.fromAccountId());
        Account toAccount = accountQueryService.findAccountById(request.toAccountId());

        // Kiểm tra số dư tài khoản gửi
        if (fromAccount.getBalance() < request.amount()) {
            throw new ResourceNotFoundException("Insufficient balance in the sender's account.");
        }

        // Cập nhật số dư tài khoản gửi và nhận
        fromAccount.setBalance(fromAccount.getBalance() - request.amount());
        toAccount.setBalance(toAccount.getBalance() + request.amount());

        // Lưu thay đổi vào database
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Tạo và lưu transaction
        Transaction transaction = mapper.toEntity(request);
        //transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setCreatedAt(LocalDateTime.now());


        commandService.save(transaction);
    }


}
