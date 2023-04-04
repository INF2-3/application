package com.example.quintor;

import com.example.quintor.dataobjects.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionInformationController implements Initializable {
    private static Transaction transaction;
    @FXML
    public GridPane gird;
    @FXML
    private Parent embeddedNav;
    private static Stage stage;
    @FXML
    private TextField valueDate;
    @FXML
    private TextField entryDate;
    @FXML
    private TextField amount;
    @FXML
    private TextField debitCredit;
    @FXML
    private TextField transactionCode;
    @FXML
    private TextField optionalDescription;
    @FXML
    private TextField referenceOwner;
    @FXML
    private TextField referenceInstitution;
    @FXML
    private TextField supplementaryDetails;
    @FXML
    private TextField originalDescription;
    @FXML
    private TextField amountOfTransactions;
    @FXML
    private Button split;
    @FXML
    private Button change;
    @FXML
    private TextField transactionCategory;

    public TransactionInformationController() {
        stage = new Stage();
    }

    public void split() {

    }

    public void change() {

    }

    public static void setTransactionId(Transaction transaction){
        TransactionInformationController.transaction = transaction;
    }

    public static Transaction getTransactionId(){
        return TransactionInformationController.transaction;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.valueDate.setText(transaction.getValueDate());
        this.entryDate.setText(String.valueOf(transaction.getEntryDate()));
        this.debitCredit.setText(String.valueOf(transaction.getDebCred()));
        this.amount.setText(String.valueOf(transaction.getAmount()));
        this.transactionCode.setText(transaction.getCode());
        this.referenceOwner.setText(transaction.getReferenceOwner());
        this.referenceInstitution.setText(transaction.getInstitutionReference());
        this.supplementaryDetails.setText(transaction.getSupplementaryDetails());
        this.originalDescription.setText(transaction.getOriginalDescription().toString());
        this.optionalDescription.setText(transaction.getDescription());
        this.transactionCategory.setText(transaction.getCategory().getName());


    }

}
