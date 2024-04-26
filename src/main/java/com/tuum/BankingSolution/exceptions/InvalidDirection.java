package com.tuum.BankingSolution.exceptions;

public class InvalidDirection extends Throwable{
    private final String message;

    public InvalidDirection(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
