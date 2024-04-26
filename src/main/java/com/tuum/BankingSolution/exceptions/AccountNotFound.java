package com.tuum.BankingSolution.exceptions;

public class AccountNotFound extends Throwable{
    private final String message;
    public AccountNotFound(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
