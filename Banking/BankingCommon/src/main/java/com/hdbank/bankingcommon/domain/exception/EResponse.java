package com.hdbank.bankingcommon.domain.exception;


public class EResponse {
    private String message;

    // Constructor
    public EResponse(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() {
        return message;
    }

    // Setter
    public void setMessage(String message) {
        this.message = message;
    }
}
