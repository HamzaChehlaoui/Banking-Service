package com.banking.service;

import com.banking.entity.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account implements AccountService {

    private final ArrayList<Transaction>transactions;
    private int  balance;

    public Account(){
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    private void validateTransactionInput(int amount ,LocalDate date){
        if(amount <= 0 ){
            throw new IllegalArgumentException("Amount must be positive");
        }
        if(date == null){
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (!transactions.isEmpty()) {
            LocalDate lastDate = transactions.get(transactions.size() - 1).getDate();
            if (date.isBefore(lastDate)) {
                throw new IllegalArgumentException("Transaction date cannot be before last operation date");
            }
        }
    }

    public void deposit(int amount ,LocalDate date){

        validateTransactionInput(amount ,date);

        balance += amount ;

        Transaction transaction = new Transaction(date ,amount ,balance);

        transactions.add(transaction);

    }

    public void withdraw(int amount ,LocalDate date){

        validateTransactionInput(amount ,date);

        if(amount > balance){
            throw new IllegalArgumentException("Insufficient  balance");
        }

        balance -= amount ;

        Transaction transaction = new Transaction(date , -amount , balance);

        transactions.add(transaction);
    }
     @Override
     public void deposit(int amount){
        deposit(amount , LocalDate.now());
     }

     @Override
     public void withdraw(int amount){
        withdraw(amount , LocalDate.now());
     }

    @Override
    public void printStatement(){


        System.out.println("Date       | Amount  | Balance");
        System.out.println("--------------------------------");

        for(int i = transactions.size() - 1; i >= 0 ; i--){
            Transaction t = transactions.get(i);

            System.out.printf("%s | %6d | %6d%n" ,
                    t.getDate(),
                    t.getAmount(),
                    t.getBalanceAfterOperation());
        }
    }
}
