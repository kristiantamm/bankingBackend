package com.tuum.BankingSolution.controllers;

import com.tuum.BankingSolution.exceptions.AccountNotFound;
import com.tuum.BankingSolution.exceptions.InvalidCurrency;
import com.tuum.BankingSolution.objects.Account;
import com.tuum.BankingSolution.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(AccountRequest accountRequest){
        try {
            Account account = accountService.createAccount(accountRequest.getCustomerId(), accountRequest.getCountry(), accountRequest.getListOfCurrencies());
            return ResponseEntity.ok(new AccountResponse(account, ""));
        }
        catch (InvalidCurrency e){
            return ResponseEntity.badRequest().body(new AccountResponse(null, e.getMessage()));
        }
    }
    @GetMapping
    public ResponseEntity<AccountResponse> getAccountById(long id){
        try {
            Account account = accountService.getAccountById(id);
            return ResponseEntity.ok(new AccountResponse(account, ""));
        }
        catch(AccountNotFound e){
            return ResponseEntity.ok(new AccountResponse(null, e.getMessage()));
        }
    }
}
