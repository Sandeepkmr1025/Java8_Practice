package com.sandeep.groupingBy;

public class Transaction {
    private String currency;
    private double amount;

    public Transaction(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return currency + ":"+ amount;

    }
}
