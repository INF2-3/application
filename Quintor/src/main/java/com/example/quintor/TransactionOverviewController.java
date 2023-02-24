package com.example.quintor;

import com.example.quintor.Transaction;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TransactionOverviewController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Transaction> transactionsTable;

    @FXML
    private TableColumn<Transaction, Double> columnBedrag;

    @FXML
    private TableColumn<Transaction, String> columnCategory;

    @FXML
    private TableColumn<Transaction, Integer> columnCode;

    @FXML
    private TableColumn<Transaction, String> columnDate;

    @FXML
    private TableColumn<Transaction, String> columnDebCred;

    @FXML
    private TableColumn<Transaction, String> columnDescription;

    @FXML
    private TableColumn<Transaction, String> columnType;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnBedrag.setCellValueFactory(new PropertyValueFactory<Transaction, Double>("amount"));
        columnCategory.setCellValueFactory(new PropertyValueFactory<Transaction, String>("category"));
        columnCode.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("code"));
        columnDate.setCellValueFactory(new PropertyValueFactory<Transaction, String>("entryDate"));
        columnDebCred.setCellValueFactory(new PropertyValueFactory<Transaction, String>("debCred"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<Transaction, String>("description"));
        columnType.setCellValueFactory(new PropertyValueFactory<Transaction, String>("type"));

        Transaction transaction = new Transaction("10-12-2023", "Debit", 20.2, "1", "T", "main", "first transaction");
        Transaction transaction1 = new Transaction("1-02-2024", "Credit", 0, "3904", "None", "Eten", "Second transaction");
        ObservableList<Transaction> transactions = transactionsTable.getItems();
        transactions.add(transaction);
        transactions.add(transaction1);
        transactionsTable.setItems(transactions);
    }
}

