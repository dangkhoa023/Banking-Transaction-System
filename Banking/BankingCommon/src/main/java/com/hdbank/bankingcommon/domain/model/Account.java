package com.hdbank.bankingcommon.domain.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private Long balance;

    @OneToOne(mappedBy = "account")
    private Client client;



}
