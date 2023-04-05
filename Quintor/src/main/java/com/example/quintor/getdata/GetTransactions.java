package com.example.quintor.getdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.example.quintor.dataobjects.*;
import com.example.quintor.services.ApiService;
import org.json.JSONArray;
import org.json.JSONObject;

import org.w3c.dom.*;
import org.xml.sax.InputSource;


public class GetTransactions {
    /**
     * Get the JSON with all the transactions from the api and place them in a JSONArray
     * Then loops through the JSONArray and makes a List of Transaction.
     *
     * @return List of Transactions
     * @throws IOException can throw IOException
     */
    public static List<Transaction> getTransactionsJSON() throws IOException {
        List<Transaction> allTransactions = new ArrayList<>();
        String url = System.getenv("URL_API") + "/api/transaction/getAllTransactionsJSON";
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
        System.out.println(response);
        in.close();

        JSONArray jsonArray = new JSONArray(response.toString());

        for (Object current : jsonArray) {
            JSONObject currentTransaction = (JSONObject) current;

            allTransactions.add(GetTransactions.makeTransactionJSON(currentTransaction));
        }

        return allTransactions;
    }

    /**
     * Makes a Transaction object from a JSONObject and returns this Transaction
     *
     * @param jsonObject A JsonObject with data for a transaction.
     * @return a Transaction object
     */
    private static Transaction makeTransactionJSON(JSONObject jsonObject) {
        int id = (int) jsonObject.get("id");
        String valueDate = (String) jsonObject.get("valueDate");
        String entryDate = (String) jsonObject.get("entryDate");
        String debCredString = (String) jsonObject.get("debitOrCredit");
        DebCred debCred;
        if (debCredString.equals("CREDIT")) {
            debCred = DebCred.CREDIT;
        } else if (debCredString.equals("DEBIT")) {
            debCred = DebCred.DEBIT;
        } else {
            debCred = null;
        }

        int amount = (int) jsonObject.get("amount");

        String transactionCode = (String) jsonObject.get("transactionCode");
        String referenceOwner = GetTransactions.checkJsonObject("referenceOwner", jsonObject);
        String institutionReference = GetTransactions.checkJsonObject("institutionReference", jsonObject);
        String supplementaryDetails = GetTransactions.checkJsonObject("supplementaryDetails", jsonObject);

        Description originalDescription = GetDescription.makeDescriptionJSON((JSONObject) jsonObject.get("originalDescription"));

        String description = GetTransactions.checkJsonObject("description", jsonObject);
        int fileId = (int) jsonObject.get("fileId");
        Category category = GetCategory.makeCategoryJSON((JSONObject) jsonObject.get("category"));


        return new Transaction(id, valueDate, entryDate, debCred, amount, transactionCode, referenceOwner
                , institutionReference, supplementaryDetails, originalDescription, description, fileId, category);
    }

    /**
     * Checks if a part of a JSONObject is null.
     *
     * @param name       the part of the JSONObject that needs to be checked
     * @param jsonObject The JSONObject
     * @return A string from the JSONObject or null.
     */
    public static String checkJsonObject(String name, JSONObject jsonObject) {
        if (!jsonObject.isNull(name)) {
            return (String) jsonObject.get(name);
        }
        return null;
    }

    /**
     * Gets the XML from the api with all the transactions from the database.
     * Loops through the xml file and makes a list of transactions
     *
     * @return List with Transactions
     */
    public static List<Transaction> getTransactionsXML() {
        List<Transaction> allTransactions = new ArrayList<>();
        ApiService apiService = new ApiService();
        try {
            String xml = apiService.getRequest("/api/transaction/getAllTransactionsXML");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(xml)));

            NodeList nodeList = document.getElementsByTagName("transaction");
            System.out.println(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                Transaction transaction = GetTransactions.makeTransactionXML(element);


                allTransactions.add(transaction);
            }
            return allTransactions;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    /**
     * Makes a Transaction object from an element and return this Transaction obejct.
     *
     * @param element The element with the data for the transaction
     * @return return the transaction
     */
    public static Transaction makeTransactionXML(Element element) {
        int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
        String valueDate = element.getElementsByTagName("valueDate").item(0).getTextContent();
        String entryDate = element.getElementsByTagName("entryDate").item(0).getTextContent();
        DebCred debCred = null;
        if (element.getElementsByTagName("debitOrCredit").item(0).getTextContent().equals("CREDIT")) {
            debCred = DebCred.CREDIT;
        } else if (element.getElementsByTagName("debitOrCredit").item(0).getTextContent().equals("DEBIT")) {
            debCred = DebCred.DEBIT;
        }
        double amount = Double.parseDouble(element.getElementsByTagName("amount").item(0).getTextContent());
        String transactionCode = element.getElementsByTagName("transactionCode").item(0).getTextContent();
        String referenceOwner = element.getElementsByTagName("referenceOwner").item(0).getTextContent();
        String institutionReference = element.getElementsByTagName("institutionReference").item(0).getTextContent();
        String supplementaryDetails = element.getElementsByTagName("supplementaryDetails").item(0).getTextContent();

        Element originalDescriptionElement = (Element) element.getElementsByTagName("originalDescription").item(0);
        Description originalDescription = GetDescription.makeDescriptionXML(originalDescriptionElement);

        String description = getTextContentOfNode(element.getElementsByTagName("description").item(0));
        int fileId = Integer.parseInt(element.getElementsByTagName("fileId").item(0).getTextContent());

        Element categoryElement = (Element) element.getElementsByTagName("category").item(0);
        Category category = GetCategory.makeCategoryXML(categoryElement);

        return new Transaction(id, valueDate, entryDate, debCred, amount, transactionCode,
                referenceOwner, institutionReference, supplementaryDetails, originalDescription, description,
                fileId, category);

    }
}
