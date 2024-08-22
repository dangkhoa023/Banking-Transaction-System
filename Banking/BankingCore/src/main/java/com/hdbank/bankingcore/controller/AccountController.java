package com.hdbank.bankingcore.controller;

import com.hdbank.bankingcore.domain.dto.AccountRequest;
import com.hdbank.bankingcore.domain.dto.AccountResponse;
import com.hdbank.bankingcore.domain.dto.ClientRequest;
import com.hdbank.bankingcore.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

   private final AccountService accountService;
    @PostMapping
    public ResponseEntity<Void> createClient(@RequestBody AccountRequest newAccount) {
    accountService.createAccount(newAccount);
    return ResponseEntity.status(HttpStatus.CREATED)
            .build();
}
}
