package com.hdbank.bankingcommon.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue
    private Long accountId;

    private Long userId;

    private Long balance;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
