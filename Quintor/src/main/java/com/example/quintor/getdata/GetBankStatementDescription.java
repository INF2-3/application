package com.example.quintor.getdata;

import com.example.quintor.dataobjects.BankStatementDescription;
import org.json.JSONObject;
import org.w3c.dom.Element;

public class GetBankStatementDescription {
    /**
     * Makes a BankStatementDescription from a JSONObject.
     *
     * @param jsonObject a JSONObject with data for a BankStatementDescription
     * @return a BankStatementDescription object.
     */
    public static BankStatementDescription getBankStatementDescriptionJSON(JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        int numberOfDebitEntries = jsonObject.getInt("numberOfDebitEntries");
        int numberOfCreditEntries = jsonObject.getInt("numberOfCreditEntries");
        double amountOfDebitEntries = jsonObject.getDouble("amountOfDebitEntries");
        double amountOfCreditEntries = jsonObject.getDouble("amountOfCreditEntries");

        return new BankStatementDescription(id, numberOfDebitEntries, numberOfCreditEntries, amountOfDebitEntries, amountOfCreditEntries);
    }

    /**
     * Makes a BankStatementDescription from an Element.
     *
     * @param element an Element with data for a BankStatementDescription
     * @return a BankStatementDescription object.
     */
    public static BankStatementDescription getBankStatementDescriptionXML(Element element) {
        int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
        int numberOfDebitEntries = Integer.parseInt(element.getElementsByTagName("numberOfDebitEntries").item(0).getTextContent());
        int numberOfCreditEntries = Integer.parseInt(element.getElementsByTagName("numberOfCreditEntries").item(0).getTextContent());
        double amountOfDebitEntries = Double.parseDouble(element.getElementsByTagName("amountOfDebitEntries").item(0).getTextContent());
        double amountOfCreditEntries = Double.parseDouble(element.getElementsByTagName("amountOfCreditEntries").item(0).getTextContent());

        return new BankStatementDescription(id, numberOfDebitEntries, numberOfCreditEntries, amountOfDebitEntries, amountOfCreditEntries);

    }
}
