package com.hdbank.bankingcommon.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

//    @ManyToOne
//    @JoinColumn(name = "from_account_id")
    private Long fromAccountId;

//    @ManyToOne
//    @JoinColumn(name = "to_account_id")
    private Long toAccountId;

    private Long amount;

    private String description;


    //@Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private LocalDateTime createdAt;
}
