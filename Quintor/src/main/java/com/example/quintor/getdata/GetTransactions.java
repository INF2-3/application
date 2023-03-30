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
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.example.quintor.dataobjects.*;
import com.example.quintor.services.ApiService;
import javafx.scene.control.TableColumn;
import org.json.JSONArray;
import org.json.JSONObject;

import org.w3c.dom.*;
import org.xml.sax.InputSource;


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
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(xml)));
//            Element list = (Element) document.getElementsByTagName("list");
            NodeList nodeList = document.getElementsByTagName("transaction");
            ArrayList<Transaction> allTrans = new ArrayList<>();
            System.out.println(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
//                NodeList nodeMap = element.getChildNodes();
//                element.getAttribute("id");
                System.out.println(element.getElementsByTagName("entryDate").item(0).getTextContent());
                int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
                LocalDate valueDate = LocalDate.parse(element.getElementsByTagName("valueDate").item(0).getTextContent());
                int entryDate = Integer.parseInt(element.getElementsByTagName("valueDate").item(0).getTextContent());
                DebCred debCred;
                if (element.getElementsByTagName("debitOrCredit").item(0).getTextContent().equals("CREDIT")) {
                    debCred = DebCred.CREDIT;
                } else if (element.getElementsByTagName("debitOrCredit").item(0).getTextContent().equals("DEBIT")) {
                    debCred = DebCred.DEBIT;
                }
                int amount = Integer.parseInt(element.getElementsByTagName("amount").item(0).getTextContent());
                String transactionCode = String.valueOf(Integer.parseInt(element.getElementsByTagName("transactionCode").item(0).getTextContent()));
                String referenceOwner = String.valueOf(Integer.parseInt(element.getElementsByTagName("referenceOwner").item(0).getTextContent()));
                String institutionReference = String.valueOf(Integer.parseInt(element.getElementsByTagName("institutionReference").item(0).getTextContent()));
                String supplementaryDetails = String.valueOf(Integer.parseInt(element.getElementsByTagName("supplementaryDetails").item(0).getTextContent()));

                NodeList originalDescription = element.getElementsByTagName("originalDescription");


//                allTrans.add(new Transaction(element.getElementsByTagName("id").item(0).getTextContent()))
//
//
//
//                for (int j = 0; j < nodeMap.getLength(); j++) {
//                    Element element1 = (Element) nodeMap.item(j);
//                    System.out.println(element1.getAttribute("id"));
////                    element1.getAttribute("id");
//
//                }

//                for (int j = 0; j < nodeMap.getLength(); j++) {
//                    Node node1 = nodeMap.item(j);
//                    if (node1.getNodeType() == Node.ELEMENT_NODE) {
//                        System.out.println(j + " " + node1.getNodeName() + " value: " + node1.getTextContent());
//                        int id = (int) GetTransactions.makeString(node1.getNodeName(), node1.getTextContent(), "id");
//                        switch (node1.getNodeName()) {
//                            case "id":
//                                int id = Integer.parseInt(node1.getTextContent());
//                                break;
//                            case "valueDate":
//                                LocalDate valueDate = LocalDate.parse(node1.getTextContent());
//                                break;
//                            case "entryDate":
//                                int entryDate = Integer.parseInt(node1.getTextContent());
//                                break;
//                            case "debitOrCredit":
//                                DebCred debCred;
//                                if (node1.getTextContent().equals("CREDIT")) {
//                                    debCred = DebCred.CREDIT;
//                                    break;
//                                } else if (node1.getTextContent().equals("DEBIT")) {
//                                    debCred = DebCred.DEBIT;
//                                }
//                                break;
//                            case "amount":
//                                int amount = Integer.parseInt(node1.getTextContent());
//                                break;
//                            case "transactionCode":
//                                String transactionCode = node1.getTextContent();
//                                break;
//                            case "referenceOwner":
//                                String referenceOwner = node1.getTextContent();
//                                break;
//                            case "supplementaryDetails":
//                                String supplementaryDetails = node1.getTextContent();
//                                break;
//                        }
//                    }
//                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object makeString(String nodeName, String nodeValue, String nameField) {
        if (nodeName.equals(nameField)) {
            return nodeValue;
        }
        return null;
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
