package com.hdbank.bankingcore.service.transaction;


import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.service.QueryService;
import com.hdbank.bankingcore.domain.dto.TransactionRequest;
import com.hdbank.bankingcore.service.CommandService;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionService extends QueryService<Transaction> , CommandService<Transaction> {
    void createTransaction(TransactionRequest newTransaction);


    void transferMoney(TransactionRequest transferMoney);


    //void transferMoney(TransactionRequest transferMoney);
}
