package com.example.quintor;

import java.util.ArrayList;

public class BankStatement {
    private int id;

    private String transactionReferenceNumber;

    private String accountNumber;

    private int statementNumber;

    private BankStatementDescription bankStatementDescription;

    private User lastUpdatedUser;

    private String uploadDate;

    private double finalBalance;

    private ArrayList<Transaction> transactions;

    public BankStatement(int id, String transactionReferenceNumber, String accountNumber, int statementNumber, BankStatementDescription bankStatementDescription, User lastUpdatedUser, String uploadDate) {
        setId(id);
        setTransactionReferenceNumber(transactionReferenceNumber);
        setAccountNumber(accountNumber);
        setStatementNumber(statementNumber);
        setBankStatementDescription(bankStatementDescription);
        setLastUpdatedUser(lastUpdatedUser);
        setUploadDate(uploadDate);
        setFinalBalance(calculateFinalBalance());
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

    public BankStatementDescription getBankStatementDescription() {
        return bankStatementDescription;
    }

    public void setBankStatementDescription(BankStatementDescription bankStatementDescription) {
        this.bankStatementDescription = bankStatementDescription;
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
