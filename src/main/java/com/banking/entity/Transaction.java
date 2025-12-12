package com.banking.entity;

import java.time.LocalDate;

public class Transaction {

    private LocalDate date ;
    private int amount ;
    private int balanceAfterOperation ;

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
