package com.tuum.BankingSolution.config;

import java.util.ArrayList;
import java.util.List;

public class BankingSolutionConstants {
    public static final List<String> LIST_OF_VALID_CURRENCIES = initializeListOfValidCurrencies();

    private List<String> initializeListOfValidCurrencies() {
        List<String> list = new ArrayList<>();
        list.add("EUR");
        list.add("SEK");
        list.add("GBP");
        list.add("USD");
        return list;
    }
}
