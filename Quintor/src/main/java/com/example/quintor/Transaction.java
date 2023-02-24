package com.example.quintor;

import java.time.LocalDate;

public class Transaction {
    private int id;

    private LocalDate valueDate;

    private String entryDate;

    private String debCred;

    private double amount;

    private String code;

    private String referenceOwner;

    private String institutionReference;

    private String supplementaryDetails;

    private int originalDescriptionId;

    private String description;

    private int fileId;

    private int categoryId;

    private String type;

    private String category;

    public Transaction(int id, LocalDate valueDate, String entryDate, String debCred, double amount, String code, String referenceOwner, String institutionReference, String supplementaryDetails, int originalDescriptionId, String description, int fileId, int categoryId) {
        this.id = id;
        this.valueDate = valueDate;
        this.entryDate = entryDate;
        this.debCred = debCred;
        this.amount = amount;
        this.code = code;
        this.referenceOwner = referenceOwner;
        this.institutionReference = institutionReference;
        this.supplementaryDetails = supplementaryDetails;
        this.originalDescriptionId = originalDescriptionId;
        this.description = description;
        this.fileId = fileId;
        this.categoryId = categoryId;
    }

    public Transaction(String entryDate, String debCred, double amount, String code, String type, String category, String description) {
        this.entryDate = entryDate;
        this.debCred = debCred;
        this.amount = amount;
        this.code = code;
        this.type = type;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReferenceOwner() {
        return referenceOwner;
    }

    public void setReferenceOwner(String referenceOwner) {
        this.referenceOwner = referenceOwner;
    }

    public String getInstitutionReference() {
        return institutionReference;
    }

    public void setInstitutionReference(String institutionReference) {
        this.institutionReference = institutionReference;
    }

    public String getSupplementaryDetails() {
        return supplementaryDetails;
    }

    public void setSupplementaryDetails(String supplementaryDetails) {
        this.supplementaryDetails = supplementaryDetails;
    }

    public int getOriginalDescriptionId() {
        return originalDescriptionId;
    }

    public void setOriginalDescriptionId(int originalDescriptionId) {
        this.originalDescriptionId = originalDescriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
}
