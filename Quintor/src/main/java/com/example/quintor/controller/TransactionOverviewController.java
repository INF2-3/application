package com.example.quintor.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class TransactionOverviewController {
    @FXML
    private AnchorPane anchorPane;

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
}

