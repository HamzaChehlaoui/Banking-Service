package com.banking.service;

import com.banking.entity.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account implements AccountService {


    private ArrayList<Transaction>transactions ;
    private int  balance ;

    public Account(){
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    @Override
    public void deposit(int amount , LocalDate date){
        if(amount <=0 ){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if(date == null){
            throw new IllegalArgumentException("Date cannot be null");
        }

        balance += amount ;

        Transaction transaction = new Transaction(date , amount , balance);

        transactions.add(transaction);

    }

    @Override
    public void withdraw(int amount , LocalDate date){
        if(amount <= 0 ){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if(date == null){
            throw new IllegalArgumentException("Date cannot be null");
        }
        if(amount > balance){
            throw new IllegalArgumentException("Insufficient  balance");
        }

        balance -= amount ;

        Transaction transaction = new Transaction(date , -amount , balance);

        transactions.add(transaction);
    }
}
