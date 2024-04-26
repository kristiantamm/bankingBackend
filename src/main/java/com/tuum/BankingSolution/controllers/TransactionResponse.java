package com.tuum.BankingSolution.controllers;

import com.tuum.BankingSolution.objects.Transaction;

public class TransactionResponse {
    private final Transaction transaction;
    private final Double balanceAfterTransaction;
    private final String errorMessage;
    public TransactionResponse(Transaction transaction, Double balanceAfterTransaction, String errorMessage) {
        this.transaction = transaction;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.errorMessage = errorMessage;
    }
}