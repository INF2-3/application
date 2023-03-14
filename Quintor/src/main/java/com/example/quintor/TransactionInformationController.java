package com.example.quintor;

import com.sun.javafx.scene.control.IntegerField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionInformationController implements Initializable {

    public AnchorPane anchorPane;
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
//    @FXML
//    public IntegerField amountOfTransactions;
    @FXML
    public Button split;
    @FXML
    public Button change;

    public TransactionInformationController(){
        stage = new Stage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void split(){

    }

    public void change(){

    }
}
