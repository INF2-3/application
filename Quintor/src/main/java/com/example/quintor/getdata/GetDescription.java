package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Description;
import org.json.JSONObject;

public class GetDescription {
    public static Description makeDescriptionJSON(JSONObject jsonObject) {
        int descriptionId = (int) jsonObject.get("descriptionId");

        String returnReason = GetTransactions.checkJsonObject("returnReason", jsonObject);

        String clientReference = GetTransactions.checkJsonObject("clientReference", jsonObject);
        String endToEndReference = GetTransactions.checkJsonObject("endToEndReference", jsonObject);
        String paymentInformationId = GetTransactions.checkJsonObject("paymentInformationId", jsonObject);
        String instructionId = GetTransactions.checkJsonObject("instructionId", jsonObject);
        String mandateReference = GetTransactions.checkJsonObject("mandateReference", jsonObject);
        String creditorId = GetTransactions.checkJsonObject("creditorId", jsonObject);
        String counterpartyId = GetTransactions.checkJsonObject("counterpartyId", jsonObject);
        String remittanceInformation = GetTransactions.checkJsonObject("remittanceInformation", jsonObject);
        String purposeCode = GetTransactions.checkJsonObject("purposeCode", jsonObject);
        String ultimateCreditor = GetTransactions.checkJsonObject("ultimateCreditor", jsonObject);
        String ultimateDebitor = GetTransactions.checkJsonObject("ultimateDebitor", jsonObject);
        String exchangeRate = GetTransactions.checkJsonObject("exchangeRate", jsonObject);
        String charges = GetTransactions.checkJsonObject("charges", jsonObject);

        return new Description(descriptionId, returnReason, clientReference, endToEndReference, paymentInformationId,
                instructionId, mandateReference, creditorId, counterpartyId, remittanceInformation, purposeCode,
                ultimateCreditor, ultimateDebitor, exchangeRate, charges);
    }
}
