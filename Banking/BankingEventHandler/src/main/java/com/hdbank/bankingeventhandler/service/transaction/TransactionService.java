package com.hdbank.bankingeventhandler.service.transaction;

import com.hdbank.bankingcommon.domain.model.Transaction;

public interface TransactionService {
    void createTransaction(Transaction transaction);
}
