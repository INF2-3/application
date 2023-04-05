package com.example.quintor.dataobjects;

public class Transaction {
    private int id;
    private String valueDate;
    private String entryDate;
    private DebCred debCred;
    private double amount;
    private String code;
    private String referenceOwner;
    private String institutionReference;
    private String supplementaryDetails;
    private Description originalDescription;
    private String description;
    private int fileId;
    private String type;
    private Category category;

    public Transaction(int id, String valueDate, String entryDate, DebCred debCred, double amount, String code, String referenceOwner, String institutionReference, String supplementaryDetails, Description originalDescription, String description, int fileId) {
        setId(id);
        setValueDate(valueDate);
        setEntryDate(entryDate);
        setDebCred(debCred);
        setAmount(amount);
        setCode(code);
        setReferenceOwner(referenceOwner);
        setInstitutionReference(institutionReference);
        setSupplementaryDetails(supplementaryDetails);
        setOriginalDescription(originalDescription);
        setDescription(description);
        setFileId(fileId);
    }

    public Transaction(String entryDate, DebCred debCred, double amount, String code, String type, Category category, String description) {
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

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
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

    public Description getOriginalDescription() {
        return originalDescription;
    }

    public void setOriginalDescription(Description originalDescription) {
        this.originalDescription = originalDescription;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isEmpty()) {
            return;
        }
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) {
            return;
        }
        this.category = category;
    }
}
