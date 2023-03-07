package com.example.quintor;

import java.util.ArrayList;

public class TranscriptFile {
    private int id;

    private String transactionReferenceNumber;

    private String accountNumber;

    private int statementNumber;

    private FileDescription fileDescription;

    private User lastUpdatedUser;

    private String uploadDate;

    private double finalBalance;

    private ArrayList<Transaction> transactions;

    public TranscriptFile(int id, String transactionReferenceNumber, String accountNumber, int statementNumber, FileDescription fileDescription, User lastUpdatedUser, String uploadDate) {
        this.id = id;
        this.transactionReferenceNumber = transactionReferenceNumber;
        this.accountNumber = accountNumber;
        this.statementNumber = statementNumber;
        this.fileDescription = fileDescription;
        this.lastUpdatedUser = lastUpdatedUser;
        this.uploadDate = uploadDate;
        this.finalBalance = calculateFinalBalance();
        this.transactions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionReferenceNumber() {
        return transactionReferenceNumber;
    }

    public void setTransactionReferenceNumber(String transactionReferenceNumber) {
        this.transactionReferenceNumber = transactionReferenceNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getStatementNumber() {
        return statementNumber;
    }

    public void setStatementNumber(int statementNumber) {
        this.statementNumber = statementNumber;
    }

    public FileDescription getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(FileDescription fileDescription) {
        this.fileDescription = fileDescription;
    }

    public User getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    public void setLastUpdatedUser(User lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    public String getUserName() {
        return this.lastUpdatedUser.getUsername();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public double calculateFinalBalance() {
        return 0.0;
    }
}
