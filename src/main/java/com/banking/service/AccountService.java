package com.banking.service;

import java.time.LocalDate;

public interface AccountService {

    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();

}
