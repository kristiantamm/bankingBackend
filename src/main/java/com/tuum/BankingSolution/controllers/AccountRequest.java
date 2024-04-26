package com.tuum.BankingSolution.controllers;

import java.util.List;

public class AccountRequest {
    private final long customerId;
    private final String country;
    private final List<String> listOfCurrencies;

    public AccountRequest(long customerId, String country, List<String> listOfCurrencies) {
        this.customerId = customerId;
        this.country = country;
        this.listOfCurrencies = listOfCurrencies;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getListOfCurrencies() {
        return listOfCurrencies;
    }
}
