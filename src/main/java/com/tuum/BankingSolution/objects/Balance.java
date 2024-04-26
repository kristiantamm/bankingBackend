package com.tuum.BankingSolution.objects;

import org.antlr.v4.runtime.misc.NotNull;

public class Balance {
    @NotNull
    private Long id;
    private Double availableAmount;
    private String  currency;

    public Balance(Double availableAmount, String currency) {
        this.availableAmount = availableAmount;
        this.currency = currency;
    }
    // Getters and setters
}