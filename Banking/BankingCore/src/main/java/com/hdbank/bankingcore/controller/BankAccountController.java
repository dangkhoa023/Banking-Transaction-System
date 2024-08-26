package com.hdbank.bankingcore.controller;

import com.hdbank.bankingcore.domain.dto.BankingAccountRequest;
import com.hdbank.bankingcore.domain.dto.ClientRequest;
import com.hdbank.bankingcore.service.bankaccount.BankAccountService;
import com.hdbank.bankingcore.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bankAccount")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<Void> createBankAccount(@RequestBody BankingAccountRequest newBankAccount) {
        bankAccountService.createBankAccount(newBankAccount);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}