package com.tuum.BankingSolution.exceptions;

public class DescriptionMissing extends Throwable{
    private String message;

    public DescriptionMissing(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
