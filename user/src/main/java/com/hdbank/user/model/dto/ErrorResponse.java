package com.hdbank.user.model.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Map;


public record ErrorResponse(
    String message,
    HttpStatus status,
    ZonedDateTime timestamp
) {}

