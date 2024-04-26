package com.tuum.BankingSolution.controllers;

import com.tuum.BankingSolution.objects.Account;

public class AccountResponse {
    private Account account;
    private String errorMessage;

    public AccountResponse(Account account, String errorMessage) {
        this.account = account;
        this.errorMessage = errorMessage;
    }
}
