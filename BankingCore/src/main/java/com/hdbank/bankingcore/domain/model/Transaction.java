package com.hdbank.bankingcore.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccountId;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccountId;

    private Long amount;

    private String description;

    private TransactionStatus status;

    private LocalDateTime createdAt;
}
