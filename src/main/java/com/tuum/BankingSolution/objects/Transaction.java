package com.tuum.BankingSolution.objects;

import org.antlr.v4.runtime.misc.NotNull;

public class Transaction {
    @NotNull
    private Long id;
    private Long accountId;
    private Double amount;
    private String currency;
    private String direction;
    private String description;

    // Getters and setters
}
