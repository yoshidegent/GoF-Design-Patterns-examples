package com.realdolmen.ood020.state;

public enum  ClosedState implements BankAccountState {
    INSTANCE;

    @Override
    public void debit(BankAccount bankAccount) {
        throw new IllegalStateException("Debit not allowed on closed account");
    }

    @Override
    public void credit(BankAccount bankAccount) {
        throw new IllegalStateException("Credit not allowed on closed account");
    }

    @Override
    public void close(BankAccount bankAccount) {
    }

    @Override
    public String toString() {
        return "closed";
    }
}
