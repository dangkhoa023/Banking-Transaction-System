package com.hdbank.bankingcore.domain.model;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long clientId;

    private String username;

    private String password;

    @OneToOne
    private Account account;
}
