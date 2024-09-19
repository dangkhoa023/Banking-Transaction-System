package com.hdbank.bankingcore.service.transaction;

import com.hdbank.bankingcommon.domain.exception.ResourceNotFoundException;
import com.hdbank.bankingcommon.domain.model.Account;
import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.domain.model.TransactionStatus;
import com.hdbank.bankingcommon.repository.AccountRepository;
import com.hdbank.bankingcommon.service.account.AccountQueryService;
import com.hdbank.bankingcore.domain.dto.TransactionRequest;
import com.hdbank.bankingcore.domain.dto.TransactionResponse;
import com.hdbank.bankingcore.domain.dto.mapper.TransactionMapper;

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
    public synchronized TransactionResponse transferMoney(TransactionRequest request) {  // synchronized tranh race condition

        Transaction transaction = new Transaction();
        transaction.setFromAccountId(request.fromAccountId());
        transaction.setToAccountId(request.toAccountId());
        transaction.setAmount(request.amount());
        transaction.setDescription(request.description());
        transaction.setCreatedAt(LocalDateTime.now());

        try {
            // Lấy thông tin tài khoản gửi và nhận qua AccountQueryService
            Account fromAccount = accountQueryService.findAccountById(request.fromAccountId());
            Account toAccount = accountQueryService.findAccountById(request.toAccountId());

            // Kiểm tra số dư tài khoản gửi
            if (fromAccount.getBalance() < request.amount()) {
                throw new ResourceNotFoundException("Insufficient balance in the sender's account.");
            }

            // Cập nhật số dư tài khoản gửi và nhận
            long newFromAccountBalance = fromAccount.getBalance() - request.amount();
            long newToAccountBalance = toAccount.getBalance() + request.amount();

            fromAccount.setBalance(newFromAccountBalance);
            toAccount.setBalance(newToAccountBalance);

            // Lưu thay đổi vào database
            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);

            //  transaction status to SUCCESS
            transaction.setStatus(TransactionStatus.SUCCESS);


            return new TransactionResponse(
                    fromAccount.getAccountId(),
                    newFromAccountBalance,
                    toAccount.getAccountId(),
                    newToAccountBalance,
                    "SUCCESS",
                    "Transaction completed successfully."
            );
        } catch (Exception e) {
            transaction.setStatus(TransactionStatus.FAILED);
            transaction.setDescription(e.getMessage());
            throw new ResourceNotFoundException("Transaction failed: " + e.getMessage());

        } finally {
            commandService.save(transaction);
        }
    }
}
