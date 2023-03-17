package com.example.quintor.transaction;

public class Description {
    private int id;
    private String returnReason;
    private String clientReference;
    private String endToEndReference;
    private String paymentInformationId;
    private String instructionId;
    private String mandateReference;
    private String creditorId;
    private String remittanceInformation;
    private String purposeCode;
    private String ultimateCreditor;
    private String ultimateDebitor;
    private String exchangeRate;
    private String charges;

    public Description(int id) {
        if (!setId(id)) {
            throw new IllegalArgumentException("invalid_id");
        }
    }

    public int getId() {
        return this.id;
    }

    public boolean setId(int id) {
        if (id < 0) {
            return false;
        }
        this.id = id;
        return true;
    }

    public String getReturnReason() {
        return this.returnReason;
    }

    public void setReturnReason(String returnReason) {
        if (returnReason == null || returnReason.isEmpty()) {
            return;
        }
        this.returnReason = returnReason;
    }

    public String getClientReference() {
        return this.clientReference;
    }

    public void setClientReference(String clientReference) {
        if (clientReference == null || clientReference.isEmpty()) {
            return;
        }
        this.clientReference = clientReference;
    }

    public String getEndToEndReference() {
        return this.endToEndReference;
    }

    public void setEndToEndReference(String endToEndReference) {
        if (endToEndReference == null || endToEndReference.isEmpty()) {
            return;
        }
        this.endToEndReference = endToEndReference;
    }

    public String getPaymentInformationId() {
        return this.paymentInformationId;
    }

    public void setPaymentInformationId(String paymentInformationId) {
        if (paymentInformationId == null || paymentInformationId.isEmpty()) {
            return;
        }
        this.paymentInformationId = paymentInformationId;
    }

    public String getInstructionId() {
        return this.instructionId;
    }

    public void setInstructionId(String instructionId) {
        if (instructionId == null || instructionId.isEmpty()) {
            return;
        }
        this.instructionId = instructionId;
    }

    public String getMandateReference() {
        return this.mandateReference;
    }

    public void setMandateReference(String mandateReference) {
        if (mandateReference == null || mandateReference.isEmpty()) {
            return;
        }
        this.mandateReference = mandateReference;
    }

    public String getCreditorId() {
        return this.creditorId;
    }

    public void setCreditorId(String creditorId) {
        if (creditorId == null || creditorId.isEmpty()) {
            return;
        }
        this.creditorId = creditorId;
    }

    public String getRemittanceInformation() {
        return this.remittanceInformation;
    }

    public void setRemittanceInformation(String remittanceInformation) {
        if (remittanceInformation == null || remittanceInformation.isEmpty()) {
            return;
        }
        this.remittanceInformation = remittanceInformation;
    }

    public String getPurposeCode() {
        return this.purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        if (purposeCode == null || purposeCode.isEmpty()) {
            return;
        }
        this.purposeCode = purposeCode;
    }

    public String getUltimateCreditor() {
        return this.ultimateCreditor;
    }

    public void setUltimateCreditor(String ultimateCreditor) {
        if (ultimateCreditor == null || ultimateCreditor.isEmpty()) {
            return;
        }
        this.ultimateCreditor = ultimateCreditor;
    }

    public String getUltimateDebitor() {
        return this.ultimateDebitor;
    }

    public void setUltimateDebitor(String ultimateDebitor) {
        if (ultimateDebitor == null || ultimateDebitor.isEmpty()) {
            return;
        }
        this.ultimateDebitor = ultimateDebitor;
    }

    public String getExchangeRate() {
        return this.exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        if (exchangeRate == null || exchangeRate.isEmpty()) {
            return;
        }
        this.exchangeRate = exchangeRate;
    }

    public String getCharges() {
        return this.charges;
    }

    public void setCharges(String charges) {
        if (charges == null || charges.isEmpty()) {
            return;
        }
        this.charges = charges;
    }
}
