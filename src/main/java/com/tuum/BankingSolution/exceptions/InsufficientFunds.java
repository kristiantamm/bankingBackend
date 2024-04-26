package com.tuum.BankingSolution.exceptions;

public class InsufficientFunds extends Throwable{
    private String message;

    public InsufficientFunds(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
