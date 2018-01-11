package com.realdolmen.ood020.state;

import java.math.BigDecimal;

public interface BankAccountState {

    BigDecimal BANKRUPTCY_TRESHOLD = new BigDecimal(-1000);

    void debit(BankAccount bankAccount);
    void credit(BankAccount bankAccount);
    void close(BankAccount bankAccount);
}
