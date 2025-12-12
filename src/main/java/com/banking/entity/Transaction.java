package com.banking.entity;

import java.time.LocalDate;

public class Transaction {

    private final LocalDate date ;
    private final int amount ;
    private final int balanceAfterOperation ;

    public Transaction(LocalDate date , int amount , int balanceAfterOperation){
        this.date = date;
        this.amount = amount;
        this.balanceAfterOperation = balanceAfterOperation;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalanceAfterOperation() {
        return balanceAfterOperation;
    }
}
