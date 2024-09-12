package com.hdbank.bankingcore.domain.dto.mapper;


import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcommon.domain.model.TransactionStatus;
import com.hdbank.bankingcore.domain.dto.TransactionRequest;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public Transaction toEntity(TransactionRequest request) {
        return Transaction.builder()
                .description(request.description())
                .fromAccountId(request.fromAccountId())
                .amount(request.amount())
                .toAccountId(request.fromAccountId())
                .build();
    }
}
