package com.example.quintor.transaction;

import java.time.LocalDate;

public class Transaction {
    private int id;
    private LocalDate valueDate;
    private int entryDate;
    private DebCred debCred;
    private double amount;
    private String code;
    private String referenceOwner;
    private String institutionReference;
    private String supplementaryDetails;
    private Description originalDescriptionId;
    private String description;
    private int fileId;
    private int categoryId;
    private String type;
    private String category;

    public Transaction(int id, LocalDate valueDate, int entryDate, DebCred debCred, double amount, String code, String referenceOwner, String institutionReference, String supplementaryDetails, Description originalDescriptionId, String description, int fileId, int categoryId) {
        setId(id);
        setValueDate(valueDate);
        setEntryDate(entryDate);
        setDebCred(debCred);
        setAmount(amount);
        setCode(code);
        setReferenceOwner(referenceOwner);
        setInstitutionReference(institutionReference);
        setSupplementaryDetails(supplementaryDetails);
        setOriginalDescriptionId(originalDescriptionId);
        setDescription(description);
        setFileId(fileId);
        setCategoryId(categoryId);
    }

    public Transaction(int entryDate, DebCred debCred, double amount, String code, String type, String category, String description) {
        setEntryDate(entryDate);
        setDebCred(debCred);
        setAmount(amount);
        setCode(code);
        setType(type);
        setCategory(category);
        setDescription(description);
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

    public int getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(int entryDate) {
        if (entryDate < 0) {
            return;
        }
        this.entryDate = entryDate;
    }

    public DebCred getDebCred() {
        return debCred;
    }

    public void setDebCred(DebCred debCred) {
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
        if (code == null || code.isEmpty()) {
            return;
        }
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

    public Description getOriginalDescriptionId() {
        return originalDescriptionId;
    }

    public void setOriginalDescriptionId(Description originalDescriptionId) {
        if (originalDescriptionId == null) {
            return;
        }
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
        if (type == null || type.isEmpty()) {
            return;
        }
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.isEmpty()) {
            return;
        }
        this.category = category;
    }
}
