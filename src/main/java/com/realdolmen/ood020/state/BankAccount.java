package com.realdolmen.ood020.state;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BankAccount {
    private BankAccountState bankAccountState = PositiveState.INSTANCE;

    private BigDecimal amount = new BigDecimal(BigInteger.ZERO);

    BigDecimal getAmount() {
        return amount;
    }

    void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    void setBankAccountState(BankAccountState bankAccountState) {
        this.bankAccountState = bankAccountState;
    }

    public void credit(BigDecimal creditAmount) {
        amount = amount.subtract(creditAmount);
        bankAccountState.credit(this);
        System.out.println(this.toString());
    }

    public void debit(BigDecimal debitAmount) {
        amount = amount.add(debitAmount);
        bankAccountState.debit(this);
        System.out.println(this.toString());
    }

    public void close() {
        bankAccountState.close(this);
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("Amount: %s (%s)", amount.toString(), bankAccountState.toString());
    }
}
