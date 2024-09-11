package com.hdbank.bankingcommon.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum TransactionStatus {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    PENDING,
    SUCCESS,
    FAILED
}
