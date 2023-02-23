package com.example.quintor;

public class Transaction {
    private String date;
    private String debCred;
    private double amount;
    private int code;
    private String type;
    private String category;
    private String description;

    public Transaction(String date, String debCred, double amount, int code, String type, String category, String description) {
        this.date = date;
        this.debCred = debCred;
        this.amount = amount;
        this.code = code;
        this.type = type;
        this.category = category;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDebCred() {
        return debCred;
    }

    public void setDebCred(String debCred) {
        this.debCred = debCred;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
