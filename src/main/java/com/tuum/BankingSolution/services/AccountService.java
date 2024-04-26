package com.tuum.BankingSolution.services;

import com.tuum.BankingSolution.config.BankingSolutionConstants;
import com.tuum.BankingSolution.controllers.AccountRequest;
import com.tuum.BankingSolution.exceptions.AccountNotFound;
import com.tuum.BankingSolution.exceptions.InvalidCurrency;
import com.tuum.BankingSolution.mappers.AccountMapper;
import com.tuum.BankingSolution.objects.Account;
import com.tuum.BankingSolution.objects.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }
    public Account createAccount(Long customerId,String country, List<String> listOfCurrencies) throws InvalidCurrency {
        List<Balance> list = new ArrayList<>();
        for (String currency : listOfCurrencies){
            if(BankingSolutionConstants.LIST_OF_VALID_CURRENCIES.contains(currency.strip())) {
                list.add(new Balance(0.00, currency));
            }
            else{
                throw new InvalidCurrency(currency + " is an invalid currency!");
            }
        }
        Account account = new Account();
        accountMapper.insertAccount(account);
        return account;
    }
    public Account getAccountById(Long accountId) throws AccountNotFound {
        Account account = accountMapper.findAccountById(accountId);
        if(account != null){
            return accountMapper.findAccountById(accountId);
        }
        else{
            throw new AccountNotFound("Account " + accountId + " not found!");
        }
    }
}
