package com.tuum.BankingSolution.objects;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public class Account {
    @NotNull
    private Long id;
    private Long customerId;
    private List<Balance> balances;

}
