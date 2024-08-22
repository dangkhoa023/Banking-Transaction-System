package com.hdbank.bankingeventhandler.service.transaction;

import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
