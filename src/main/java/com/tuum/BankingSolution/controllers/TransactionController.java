package com.tuum.BankingSolution.controllers;

import com.tuum.BankingSolution.exceptions.*;
import com.tuum.BankingSolution.objects.Balance;
import com.tuum.BankingSolution.objects.Transaction;
import com.tuum.BankingSolution.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/post")
    public ResponseEntity<TransactionResponse> createTransaction(
         @RequestParam("accountId") Long accountId,
         @RequestParam("amount") Double amount,
         @RequestParam("currency") String currency,
         @RequestParam("direction") String direction,
         @RequestParam("description") String description){
        try{
            transactionService.createTransaction(accountId, amount, currency, direction, description);
            //See on vale siin!
            return ResponseEntity.ok(new TransactionResponse());
        }
        catch(AccountNotFound | InvalidAmount | InvalidCurrency | InvalidDirection | DescriptionMissing e){
            TransactionResponse response = new TransactionResponse(null, null, e.getMessage());
            return ResponseEntity.badRequest(response);
        }
    }
}
