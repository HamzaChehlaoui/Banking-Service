package com.banking;


import com.banking.service.Account;
import java.time.LocalDate;

public class Main
{
    public static void main( String[] args )
    {

        Account account = new Account();

        account.deposit(1000, LocalDate.of(2025 , 12,13));
        account.deposit(2000, LocalDate.of(2025,12,15));
        account.withdraw(2000,LocalDate.of(2025,12,16));

        account.printStatement();

    }
}
