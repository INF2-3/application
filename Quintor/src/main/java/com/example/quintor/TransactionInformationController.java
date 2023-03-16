package com.example.quintor;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TransactionInformationController {
    @FXML
    public GridPane gird;
    @FXML
    private Parent embeddedNav;
    private static Stage stage;
    @FXML
    public TextField valueDate;
    @FXML
    public TextField entryDate;
    @FXML
    public TextField amount;
    @FXML
    public TextField debitCredit;
    @FXML
    public TextField transactionCode;
    @FXML
    public TextField optionalDescription;
    @FXML
    public TextField referenceOwner;
    @FXML
    public TextField referenceInstitution;
    @FXML
    public TextField supplementaryDetails;
    @FXML
    public TextField originalDescription;
    @FXML
    public TextField amountOfTransactions;
    @FXML
    public Button split;
    @FXML
    public Button change;

    public TransactionInformationController() {
        stage = new Stage();
    }

    public void split() {

    }

    public void change() {

    }
}
