package com.realdolmen.ood020.state.client;

import com.realdolmen.ood020.state.BankAccount;

import java.math.BigDecimal;

public class Client {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.debit(new BigDecimal(1000));
        bankAccount.credit(new BigDecimal(1500));
        bankAccount.credit(new BigDecimal(1000));
        bankAccount.close();
        try {
            bankAccount.credit(new BigDecimal(1000));
        } catch (IllegalStateException ise) {
            System.out.println(ise.getMessage());
        }
    }
}
