package com.hdbank.bankingcore.controller;

import com.hdbank.bankingcore.domain.dto.TransactionRequest;
import com.hdbank.bankingcore.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionRequest newTransaction){
        transactionService.createTransaction(newTransaction);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
