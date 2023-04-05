package com.example.quintor.getdata;

import com.example.quintor.dataobjects.Balance;
import com.example.quintor.dataobjects.BankStatement;
import com.example.quintor.dataobjects.BankStatementDescription;
import com.example.quintor.dataobjects.User;
import com.example.quintor.services.ApiService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class GetBankStatement {
    /**
     * Get the JSON with all the BankStatements from the api and place them in a JSONArray.
     * Then loops through the JSONArray and makes a list of BankStatements.
     *
     * @return a list of BankStatements
     */
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

    /**
     * Makes a BankStatement object from a JSONObject.
     *
     * @param jsonObject a JSONObject with data for a BankStatement
     * @return a bankStatement.
     */
    private static BankStatement makeBankStatementJSON(JSONObject jsonObject) {
        int id = jsonObject.getInt("id");
        String transactionReferenceNumber = jsonObject.getString("transactionReferenceNumber");
        String accountNumber = jsonObject.getString("accountNumber");
        int statementNumber = jsonObject.getInt("statementNumber");
        String uploadDate = jsonObject.getString("uploadDate");

        User lastUpdatedUser = GetUser.makeUserJSON((JSONObject) jsonObject.get("lastUpdatedUser"));
        Balance closingBalance = GetBalance.makeBalanceJSON((JSONObject) jsonObject.get("closingBalance"));


        BankStatementDescription bankStatementDescription = GetBankStatementDescription.getBankStatementDescriptionJSON((JSONObject) jsonObject.get("fileDescription"));
        return new BankStatement(id, transactionReferenceNumber, accountNumber, statementNumber, bankStatementDescription, lastUpdatedUser, uploadDate, closingBalance);
    }

    /**
     * Gets the XML from the api with all the Bankstatements from the database.
     * Then loops through the xml file and makes a list of BankStatements.
     *
     * @return List with BankStatementa
     */
    public static List<BankStatement> getBankStatementsXML() {
        List<BankStatement> allBankStatements = new ArrayList<>();
        ApiService apiService = new ApiService();
        try {
            String xml = apiService.getRequest("/api/bankStatement/allBankStatementsXML");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(xml)));

            NodeList nodeList = document.getElementsByTagName("bankStatement");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);

                BankStatement bankStatement = GetBankStatement.makeBankStatementXML(element);
                allBankStatements.add(bankStatement);
            }
            return allBankStatements;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Makes a BankStatement from an Element.
     *
     * @param element element with data for the BankStatement.
     * @return A BankStatement object
     */
    private static BankStatement makeBankStatementXML(Element element) {
        int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
        String transactionReferenceNumber = element.getElementsByTagName("transactionReferenceNumber").item(0).getTextContent();
        String accountNumber = element.getElementsByTagName("accountNumber").item(0).getTextContent();
        int statementNumber = Integer.parseInt(element.getElementsByTagName("statementNumber").item(0).getTextContent());
        String uploadDate = element.getElementsByTagName("uploadDate").item(0).getTextContent();

        User lastUpdatedUser = GetUser.makeUserXML(element);
        Balance closingBalance = GetBalance.makeBalanceXML(element);

        BankStatementDescription bankStatementDescription = GetBankStatementDescription.getBankStatementDescriptionXML(element);

        return new BankStatement(id, transactionReferenceNumber, accountNumber, statementNumber, bankStatementDescription, lastUpdatedUser, uploadDate, closingBalance);
    }

}
