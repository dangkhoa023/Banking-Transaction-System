package com.hdbank.bankingcore.controller;

import com.hdbank.bankingcommon.domain.model.Client;
import com.hdbank.bankingcore.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<String> getClients() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        clientService.save(client);
        return ResponseEntity.ok().build();
    }
}
