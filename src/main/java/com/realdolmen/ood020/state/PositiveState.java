package com.realdolmen.ood020.state;

import java.math.BigDecimal;

public enum PositiveState implements BankAccountState {
    INSTANCE;

    @Override
    public void debit(BankAccount bankAccount) {
    }

    @Override
    public void credit(BankAccount bankAccount) {
        if(bankAccount.getAmount().compareTo(BANKRUPTCY_TRESHOLD) < 0) {
            bankAccount.setBankAccountState(BankruptState.INSTANCE);
            bankAccount.setAmount(BANKRUPTCY_TRESHOLD);
        } else if(bankAccount.getAmount().compareTo(BANKRUPTCY_TRESHOLD) >=0) {
            if(bankAccount.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                bankAccount.setBankAccountState(InCreditState.INSTANCE);
            }
        }
    }

    @Override
    public void close(BankAccount bankAccount) {
        bankAccount.setBankAccountState(PositiveState.INSTANCE);
    }

    @Override
    public String toString() {
        return "positive";
    }
}
