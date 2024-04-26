package com.tuum.BankingSolution.services;

import com.tuum.BankingSolution.config.BankingSolutionConstants;
import com.tuum.BankingSolution.exceptions.*;
import com.tuum.BankingSolution.mappers.TransactionMapper;
import com.tuum.BankingSolution.objects.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private AccountService accountService;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionService(TransactionMapper transactionMapper) {
        this.transactionMapper = transactionMapper;
    }

    public Transaction createTransaction(long accountId, double amount, String currency, String direction, String description) throws InvalidAmount, InvalidCurrency, InvalidDirection, DescriptionMissing, AccountNotFound {
        verifyInputs(accountId, amount, currency, direction, description);
        transactionMapper.insertTransaction(new Transaction());

        return transaction;
    }

    private void verifyInputs(long accountId, double amount, String currency, String direction, String description) throws AccountNotFound, InvalidAmount, InvalidCurrency, InvalidDirection, DescriptionMissing {
        // Check if the account exists
        accountService.getAccountById(accountId);

        // Check if the amount is positive
        if (amount < 0) {
            throw new InvalidAmount("Amount must be a positive number: " + amount);
        }

        // Check if the currency is valid
        if (!isValidCurrency(currency)) {
            throw new InvalidCurrency("Invalid currency: " + currency);
        }

        // Check if the direction is valid
        if (!isValidDirection(direction)) {
            throw new InvalidDirection("Invalid direction: " + direction);
        }

        // Check if the description is missing
        if (description == null || description.isEmpty()) {
            throw new DescriptionMissing("Description is missing.");
        }
    }

    private boolean isValidCurrency(String currency) {
        return BankingSolutionConstants.LIST_OF_VALID_CURRENCIES.contains(currency.strip());
    }

    private boolean isValidDirection(String direction) {
        return direction != null && !direction.isEmpty() && (direction.equals("IN") || direction.equals("OUT"));
    }

    public Transaction getTransactionById(Long transactionId) {
        return transactionMapper.findTransactionById(transactionId);
    }
}
