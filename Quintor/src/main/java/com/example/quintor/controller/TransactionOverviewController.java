package com.example.quintor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TransactionOverviewController {

    @FXML
    private TableColumn<?, ?> columnBedrag;

    @FXML
    private TableColumn<?, ?> columnCategory;

    @FXML
    private TableColumn<?, ?> columnCode;

    @FXML
    private TableColumn<?, ?> columnDate;

    @FXML
    private TableColumn<?, ?> columnDebCred;

    @FXML
    private TableColumn<?, ?> columnDescription;

    @FXML
    private TableColumn<?, ?> columnType;

    @FXML
    private TableView<?> transactionsTable;

    public void test() {

    }
}

