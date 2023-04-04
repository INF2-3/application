package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Description;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetDescription {
    /**
     * This method makes a Description object from a JSONObject.
     * If a part of the jsonObject is null then that field will be null in the description.
     *
     * @param jsonObject a JSONObject with a descriptionId
     * @return a Description object.
     */
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
        String ultimateDebtor = GetTransactions.checkJsonObject("ultimateDebitor", jsonObject);
        String exchangeRate = GetTransactions.checkJsonObject("exchangeRate", jsonObject);
        String charges = GetTransactions.checkJsonObject("charges", jsonObject);

        return new Description(descriptionId, returnReason, clientReference, endToEndReference, paymentInformationId,
                instructionId, mandateReference, creditorId, counterpartyId, remittanceInformation, purposeCode,
                ultimateCreditor, ultimateDebtor, exchangeRate, charges);
    }

    /**
     * This method makes a Description object from an Element.
     * If a part of the element is null then that field will be null in the description.
     *
     * @param element an Element with a descriptionId.
     * @return a Description object
     */
    public static Description makeDescriptionXML(Element element) {
        int descriptionId = Integer.parseInt(element.getElementsByTagName("descriptionId").item(0).getTextContent());
        String returnReason = getTextContentOfNode(element.getElementsByTagName("returnReason").item(0));
        String clientReference = getTextContentOfNode(element.getElementsByTagName("clientReference").item(0));
        String endToEndReference = getTextContentOfNode(element.getElementsByTagName("endToEndReference").item(0));
        String paymentInformationId = getTextContentOfNode(element.getElementsByTagName("paymentInformationId").item(0));
        String instructionId = getTextContentOfNode(element.getElementsByTagName("instructionId").item(0));
        String mandateReference = getTextContentOfNode(element.getElementsByTagName("mandateReference").item(0));
        String creditorId = getTextContentOfNode(element.getElementsByTagName("creditorId").item(0));
        String counterpartyId = getTextContentOfNode(element.getElementsByTagName("counterpartyId").item(0));
        String remittanceInformation = getTextContentOfNode(element.getElementsByTagName("remittanceInformation").item(0));
        String purposeCode = getTextContentOfNode(element.getElementsByTagName("purposeCode").item(0));
        String ultimateCreditor = getTextContentOfNode(element.getElementsByTagName("ultimateCreditor").item(0));
        String ultimateDebtor = getTextContentOfNode(element.getElementsByTagName("ultimateDebtor").item(0));
        String exchangeRate = getTextContentOfNode(element.getElementsByTagName("exchangeRate").item(0));
        String charges = getTextContentOfNode(element.getElementsByTagName("charges").item(0));
        return new Description(descriptionId, returnReason, clientReference, endToEndReference, paymentInformationId,
                instructionId, mandateReference, creditorId, counterpartyId, remittanceInformation, purposeCode, ultimateCreditor,
                ultimateDebtor, exchangeRate, charges);
    }

    /**
     * Gets the TextContext of a node when the node isn't null.
     * If the node is null then the method returns null.
     *
     * @param node the node which gets checked.
     * @return a String with the textContent of the node.
     */
    private static String getTextContentOfNode(Node node) {
        if (node != null) {
            return node.getTextContent();
        }
        return null;
    }
}
