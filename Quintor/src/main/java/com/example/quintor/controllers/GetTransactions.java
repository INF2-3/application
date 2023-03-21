package com.example.quintor.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.example.quintor.transaction.DebCred;
import com.example.quintor.transaction.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetTransactions {
    public static List<Transaction> getTransactions() throws IOException {
        List<Transaction> allTransactions = new ArrayList<>();
        String url = System.getenv("URL_API") + "/api/transaction/getAllTransactions";
        URL api = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) api.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONArray jsonArray = new JSONArray(response.toString());

        for (Object current : jsonArray) {
            JSONObject currentTransaction = (JSONObject) current;

            allTransactions.add(GetTransactions.makeTransaction(currentTransaction));
        }

        return allTransactions;


    }

    private static Transaction makeTransaction(JSONObject jsonObject) {
        int id = (int) jsonObject.get("id");

        String valueDate = (String) jsonObject.get("valueDate");

        int entryDate = (int) jsonObject.get("entryDate");

        String debCredString = (String) jsonObject.get("debitOrCredit");

        DebCred debCred;
        if (debCredString.equals("CREDIT")) {
            debCred = DebCred.CREDIT;
        } else if (debCredString.equals("DEBIT")) {
            debCred = DebCred.DEBIT;
        } else {
            debCred = null;
        }

        BigDecimal amount1 = (BigDecimal) jsonObject.get("amount");
        double amount = amount1.doubleValue();

        String transactionCode = (String) jsonObject.get("transactionCode");

        String referenceOwner;
        if (!jsonObject.isNull("referenceOwner")) {
            referenceOwner = (String) jsonObject.get("referenceOwner");
        } else {
            referenceOwner = null;
        }

        String institutionReference;
        if (!jsonObject.isNull("institutionReference")) {
            institutionReference = (String) jsonObject.get("institutionReference");
        } else {
            institutionReference = null;
        }

        String supplementaryDetails;
        if (!jsonObject.isNull("supplementaryDetails")) {
            supplementaryDetails = (String) jsonObject.get("supplementaryDetails");
        } else {
            supplementaryDetails = null;
        }

        int originalDescriptionId = (int) jsonObject.get("originalDescriptionId");

        String description;
        if (!jsonObject.isNull("description")) {
            description = (String) jsonObject.get("description");
        } else {
            description = null;
        }

        int fileId = (int) jsonObject.get("fileId");

        int categoryId = (int) jsonObject.get("categoryId");

        return new Transaction(id, valueDate, entryDate, debCred, amount, transactionCode, referenceOwner
                , institutionReference, supplementaryDetails, originalDescriptionId, description, fileId, categoryId);

    }

}