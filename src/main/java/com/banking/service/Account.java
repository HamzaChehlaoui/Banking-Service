package com.banking.service;

import com.banking.entity.Transaction;

import java.util.ArrayList;

public class Account implements AccountService {


    private ArrayList<Transaction>transactions ;
    private int  balance ;

    public Account(){
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

}
