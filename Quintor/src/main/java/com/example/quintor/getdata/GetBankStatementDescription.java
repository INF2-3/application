package com.example.quintor.getdata;

import com.example.quintor.dataobjects.BankStatementDescription;
import org.json.JSONObject;

public class GetBankStatementDescription {
    public static BankStatementDescription getBankStatementDescriptionJSON(JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        int numberOfDebitEntries = jsonObject.getInt("numberOfDebitEntries");
        int numberOfCreditEntries = jsonObject.getInt("numberOfCreditEntries");
        double amountOfDebitEntries = jsonObject.getDouble("amountOfDebitEntries");
        double amountOfCreditEntries = jsonObject.getDouble("amountOfCreditEntries");

        return new BankStatementDescription(id, numberOfDebitEntries, numberOfCreditEntries, amountOfDebitEntries, amountOfCreditEntries);
    }
}
