package com.example.quintor;

import com.sun.javafx.scene.control.IntegerField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TransactionInformationController {

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
    public IntegerField amountOfTransactions;
    @FXML
    public Button split;
    @FXML
    public Button change;


}
