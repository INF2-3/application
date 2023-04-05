package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Balance;
import com.example.quintor.dataobjects.BankStatement;
import com.example.quintor.dataobjects.BankStatementDescription;
import com.example.quintor.dataobjects.User;
import com.example.quintor.services.ApiService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GetBankStatement {
    public static List<BankStatement> getBankStatementsJSON() {
        List<BankStatement> allBankStatements = new ArrayList<>();
        ApiService apiService = new ApiService();
        try {
            String json = apiService.getRequest("/api/bankStatement/allBankStatementsJSON");
            JSONArray jsonArray = new JSONArray(json);
            for (Object current : jsonArray) {
                JSONObject currentBankStatement = (JSONObject) current;

                allBankStatements.add(GetBankStatement.makeBankStatementJSON(currentBankStatement));
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return allBankStatements;
    }

    private static BankStatement makeBankStatementJSON(JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        String transactionReferenceNumber = jsonObject.getString("transactionReferenceNumber");
        String accountNumber = jsonObject.getString("accountNumber");
        int statementNumber = jsonObject.getInt("statementNumber");
        String uploadDate = jsonObject.getString("uploadDate");

        User lastUpdatedUser = GetUser.makeUserJSON((JSONObject) jsonObject.get("lastUpdatedUser"));
        Balance closingBalance = GetBalance.makeBalance((JSONObject) jsonObject.get("closingBalance"));


        BankStatementDescription bankStatementDescription = GetBankStatementDescription.getBankStatementDescriptionJSON((JSONObject) jsonObject.get("fileDescription"));
        return new BankStatement(id, transactionReferenceNumber, accountNumber, statementNumber, bankStatementDescription, lastUpdatedUser, uploadDate, closingBalance);
    }

}
