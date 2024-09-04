package com.hdbank.bankingcore.controller;

import com.hdbank.bankingcore.domain.dto.ClientRequest;
import com.hdbank.bankingcore.service.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Void> createClient(@Valid @RequestBody ClientRequest newClient) {
        clientService.createClient(newClient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }
}
