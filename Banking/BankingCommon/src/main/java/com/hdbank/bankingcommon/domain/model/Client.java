package com.hdbank.bankingcommon.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long clientId;

    private String username;

    private String password;

    private String name;

    @OneToOne
    private Account account;
}
