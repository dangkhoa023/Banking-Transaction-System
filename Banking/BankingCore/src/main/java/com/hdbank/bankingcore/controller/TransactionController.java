package com.hdbank.bankingcore.controller;

import com.hdbank.bankingcore.domain.dto.TransactionRequest;

import com.hdbank.bankingcore.domain.dto.TransactionResponse;
import com.hdbank.bankingcore.service.transaction.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

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


    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> transferMoney(@Valid @RequestBody TransactionRequest request) {
    TransactionResponse transactionResponse= transactionService.transferMoney(request);
        return ResponseEntity.status(HttpStatus.CREATED)
               .body(transactionResponse);
}

}
