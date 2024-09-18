package com.hdbank.bankingcore.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record UpdateBalanceRequest(
        long accountId,  // ID của tài khoản cần cập nhật
        long amount// Số tiền
) {}

