package com.tuum.BankingSolution.exceptions;

public class InvalidAmount extends Throwable{
    private final String message;

    public InvalidAmount(String message) {
        this.message = message;
    }
}
