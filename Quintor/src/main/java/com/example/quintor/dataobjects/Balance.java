package com.example.quintor.dataobjects;

public class Balance {
    private int id;
    private DebCred debCred;
    private String date;
    private String currency;
    private double amount;
    private BalanceType balanceType;

    public Balance(int id, DebCred debCred, String date, String currency, double amount, BalanceType balanceType) {
        setId(id);
        setDebCred(debCred);
        setDate(date);
        setCurrency(currency);
        setAmount(amount);
        setBalanceType(balanceType);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DebCred getDebCred() {
        return this.debCred;
    }

    public void setDebCred(DebCred debCred) {
        this.debCred = debCred;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BalanceType getBalanceType() {
        return this.balanceType;
    }

    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }
}
