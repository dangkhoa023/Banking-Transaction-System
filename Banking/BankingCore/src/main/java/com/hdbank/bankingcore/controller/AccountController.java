package com.hdbank.bankingcore.controller;




import com.hdbank.bankingcore.domain.dto.UpdateBalanceRequest;
import com.hdbank.bankingcore.domain.dto.UpdateBalanceResponse;
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

    @PostMapping("/update-balance")
    public ResponseEntity<UpdateBalanceResponse> updateBalance(@Valid @RequestBody UpdateBalanceRequest request) {
        UpdateBalanceResponse updateBalanceResponse = accountService.updateBalance(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                     .body(updateBalanceResponse);
    }
}
