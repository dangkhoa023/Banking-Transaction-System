package com.hdbank.bankingcommon.domain.model;

import jakarta.persistence.*;

import lombok.*;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue
    private Long bank_account_id;

    private BigDecimal balance;

    @OneToMany(mappedBy = "bankAccount")
    private List<Account> accounts;

    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "bank_account_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private List<Transaction> transactions;

}