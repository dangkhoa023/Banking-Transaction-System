package com.hdbank.bankingcore.domain.dto.mapper;


import com.hdbank.bankingcommon.domain.model.Transaction;
import com.hdbank.bankingcore.domain.dto.TransactionRequest;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public Transaction toEntity(TransactionRequest request) {
        return Transaction.builder()
                .amount(request.amount())
                .description(request.description())
                .build();
    }
}
