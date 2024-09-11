package com.hdbank.bankingcore.controller;

import com.hdbank.bankingcore.domain.dto.AccountRequest;
import com.hdbank.bankingcore.domain.dto.AccountResponse;

import com.hdbank.bankingcore.domain.dto.ClientRequest;
import com.hdbank.bankingcore.domain.dto.UpdateBalanceRequest;
import com.hdbank.bankingcore.service.account.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

   private final AccountService accountService;


//    @PostMapping
//    public ResponseEntity<Void> createClient(@Valid @RequestBody AccountRequest newAccount) {
//        accountService.createAccount(newAccount);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .build();
//    }

    @PostMapping("/update-balance")
    public ResponseEntity<Void> updateBalance(@Valid @RequestBody UpdateBalanceRequest request) {
        accountService.updateBalance(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                     .build();
    }
}
