package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Balance;
import com.example.quintor.dataobjects.BalanceType;
import com.example.quintor.dataobjects.DebCred;
import org.json.JSONObject;

public class GetBalance {
    public static Balance makeBalance(JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        double amount = jsonObject.getDouble("amount");
        DebCred debCred = DebCred.valueOf(jsonObject.getString("debitOrCredit"));
        String currency = jsonObject.getString("currency");
        BalanceType balanceType = BalanceType.valueOf(jsonObject.getString("type"));
        String date = jsonObject.getString("date");

        return new Balance(id, debCred, date, currency, amount, balanceType);
    }
}
