package com.realdolmen.ood020.state;

import java.math.BigDecimal;

public enum  InCreditState implements BankAccountState {
    INSTANCE;

    @Override
    public void debit(BankAccount bankAccount) {
        if(bankAccount.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            bankAccount.setBankAccountState(PositiveState.INSTANCE);
        }
    }

    @Override
    public void credit(BankAccount bankAccount) {
        if(bankAccount.getAmount().compareTo(BANKRUPTCY_TRESHOLD) < 0) {
            bankAccount.setBankAccountState(BankruptState.INSTANCE);
            bankAccount.setAmount(BANKRUPTCY_TRESHOLD);
        }
    }

    @Override
    public void close(BankAccount bankAccount) {
        bankAccount.setBankAccountState(ClosedState.INSTANCE);
    }

    @Override
    public String toString() {
        return "in credit";
    }
}
