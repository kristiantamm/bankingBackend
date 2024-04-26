package com.tuum.BankingSolution.exceptions;

public class InvalidCurrency extends Throwable{
    private final String message;

    public InvalidCurrency(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
