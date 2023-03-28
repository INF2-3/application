package com.example.quintor.getdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.quintor.dataobjects.Category;
import com.example.quintor.dataobjects.DebCred;
import com.example.quintor.dataobjects.Description;
import com.example.quintor.dataobjects.Transaction;
import com.example.quintor.services.ApiService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class GetTransactions {
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

    private static Transaction makeTransactionJSON(JSONObject jsonObject) {
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

    public static String checkJsonObject(String name, JSONObject jsonObject) {
        if (!jsonObject.isNull(name)) {
            return (String) jsonObject.get(name);
        }
        return null;
    }

    public static List<Transaction> getTransactionsXML() {
        List<Transaction> allTransactions = new ArrayList<>();
        ApiService apiService = new ApiService();
        try {
            String xml = apiService.getRequest("/api/transaction/getAllTransactionsXML");
            System.out.println(xml);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(xml)));
            Element transactions = document.getDocumentElement();
//            System.out.println(transactions);

            NodeList list = transactions.getChildNodes();
//            transactions.getChildNodes()
//            transactions.getChildNodes()
            System.out.println(list.getLength());
            for (int i = 0; i < list.getLength(); i++) {
                System.out.println(list.item(i));

            }


//            System.out.println(list.getLength());
//            for (int i = 0; i < list.getLength(); i++) {
//                System.out.println(transactions.getAttribute("transaction"));
////                NodeList list1 = transactions.getNodeName();
////                System.out.println(transactions.getNodeName());
////                System.out.println(transactions.getTagName());
////                System.out.println(transactions.getPrefix());
////                System.out.println(transactions.getNodeValue());
//                System.out.println(transactions.getTextContent());
////                for (int j = 0; j < list1.getLength(); j++) {
////                    System.out.println(list1.getLength());
////
//////                    System.out.println(list1.item(j));
////                }
////                transactions.getAttribute("transaction");
////                System.out.println(list.item(i));
//
//            }


//            NodeList nodeList = document.getElementsByTagName("transaction");
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//                System.out.println(node);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element element = (Element) node;
//                    System.out.println(element);
//                    GetTransactions.makeTransactionXML(element);
////                    allTransactions.add(GetTransactions.makeTransactionXML(element));
//                }
//            }
//
//            return allTransactions;
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void makeTransactionXML(Element element) {
//        String test = element.getElementsByTagName("id");
        String valueDate = element.getAttribute("valueDate");
        int entryDate = Integer.parseInt(element.getAttribute("entryDate"));
        String debCredString = element.getAttribute("debitOrCredit");
        DebCred debCred;
        if (debCredString.equals("CREDIT")) {
            debCred = DebCred.CREDIT;
        } else if (debCredString.equals("DEBIT")) {
            debCred = DebCred.DEBIT;
        } else {
            debCred = null;
        }

        int amount = Integer.parseInt(element.getAttribute("amount"));
        String transactionCode = element.getAttribute("transactionCode");
//        String referenceOwner = element.getAttribute("reference_owner");
//        System.out.println(referenceOwner);

//        System.out.println(test);

        return;
    }


}
