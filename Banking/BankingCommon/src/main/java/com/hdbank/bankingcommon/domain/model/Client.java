package com.hdbank.bankingcommon.domain.model;

import jakarta.persistence.*;

import java.util.List;

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
