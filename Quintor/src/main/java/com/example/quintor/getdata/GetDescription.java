package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Description;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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

    public static Description makeDescriptionXML(Element element) {
        int descriptionId = Integer.parseInt(element.getElementsByTagName("descriptionId").item(0).getTextContent());
        String returnReason = checkElementByTagName(element.getElementsByTagName("returnReason").item(0));
        String clientReference = checkElementByTagName(element.getElementsByTagName("clientReference").item(0));
        String endToEndReference = checkElementByTagName(element.getElementsByTagName("endToEndReference").item(0));
        String paymentInformationId = checkElementByTagName(element.getElementsByTagName("paymentInformationId").item(0));
        String instructionId = checkElementByTagName(element.getElementsByTagName("instructionId").item(0));
        String mandateReference = checkElementByTagName(element.getElementsByTagName("mandateReference").item(0));
        String creditorId = checkElementByTagName(element.getElementsByTagName("creditorId").item(0));
        String counterpartyId = checkElementByTagName(element.getElementsByTagName("counterpartyId").item(0));
        String remittanceInformation = checkElementByTagName(element.getElementsByTagName("remittanceInformation").item(0));
        String purposeCode = checkElementByTagName(element.getElementsByTagName("purposeCode").item(0));
        String ultimateCreditor = checkElementByTagName(element.getElementsByTagName("ultimateCreditor").item(0));
        String ultimateDebtor = checkElementByTagName(element.getElementsByTagName("ultimateDebtor").item(0));
        String exchangeRate = checkElementByTagName(element.getElementsByTagName("exchangeRate").item(0));
        String charges = checkElementByTagName(element.getElementsByTagName("charges").item(0));
        return new Description(descriptionId, returnReason, clientReference, endToEndReference, paymentInformationId,
                instructionId, mandateReference, creditorId, counterpartyId, remittanceInformation, purposeCode, ultimateCreditor,
                ultimateDebtor, exchangeRate, charges);
    }

    private static String checkElementByTagName(Node node) {
        if (node != null) {
            return node.getTextContent();
        }
        return null;
    }
}
