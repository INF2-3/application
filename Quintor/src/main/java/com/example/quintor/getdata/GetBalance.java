package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Balance;
import com.example.quintor.dataobjects.BalanceType;
import com.example.quintor.dataobjects.DebCred;
import org.json.JSONObject;
import org.w3c.dom.Element;

public class GetBalance {
    public static Balance makeBalanceJSON(JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        double amount = jsonObject.getDouble("amount");
        DebCred debCred = DebCred.valueOf(jsonObject.getString("debitOrCredit"));
        String currency = jsonObject.getString("currency");
        BalanceType balanceType = BalanceType.valueOf(jsonObject.getString("type"));
        String date = jsonObject.getString("date");

        return new Balance(id, debCred, date, currency, amount, balanceType);
    }

    public static Balance makeBalanceXML(Element element) {
        int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
        double amount = Double.parseDouble(element.getElementsByTagName("amount").item(0).getTextContent());
        DebCred debCred = DebCred.valueOf(element.getElementsByTagName("debitOrCredit").item(0).getTextContent());
        String currency = element.getElementsByTagName("currency").item(0).getTextContent();
        BalanceType balanceType = BalanceType.valueOf(element.getElementsByTagName("type").item(0).getTextContent());
        String date = element.getElementsByTagName("date").item(0).getTextContent();

        return new Balance(id, debCred, date, currency, amount, balanceType);
    }
}
