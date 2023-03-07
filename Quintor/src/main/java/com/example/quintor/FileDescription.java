package com.example.quintor;

public class FileDescription {
    private int id;

    private int numberOfDebitEntries;

    private int numberOfCreditEntries;

    private double amountOfDebitEntries;

    private double amountOfCreditEntries;

    public FileDescription(int id, int numberOfDebitEntries, int numberOfCreditEntries, double amountOfDebitEntries, double amountOfCreditEntries) {
        this.id = id;
        this.numberOfDebitEntries = numberOfDebitEntries;
        this.numberOfCreditEntries = numberOfCreditEntries;
        this.amountOfDebitEntries = amountOfDebitEntries;
        this.amountOfCreditEntries = amountOfCreditEntries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfDebitEntries() {
        return numberOfDebitEntries;
    }

    public void setNumberOfDebitEntries(int numberOfDebitEntries) {
        this.numberOfDebitEntries = numberOfDebitEntries;
    }

    public int getNumberOfCreditEntries() {
        return numberOfCreditEntries;
    }

    public void setNumberOfCreditEntries(int numberOfCreditEntries) {
        this.numberOfCreditEntries = numberOfCreditEntries;
    }

    public double getAmountOfDebitEntries() {
        return amountOfDebitEntries;
    }

    public void setAmountOfDebitEntries(double amountOfDebitEntries) {
        this.amountOfDebitEntries = amountOfDebitEntries;
    }

    public double getAmountOfCreditEntries() {
        return amountOfCreditEntries;
    }

    public void setAmountOfCreditEntries(double amountOfCreditEntries) {
        this.amountOfCreditEntries = amountOfCreditEntries;
    }
}
