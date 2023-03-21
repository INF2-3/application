package com.example.quintor;

import com.example.quintor.controllers.GetTransactions;
import com.example.quintor.transaction.DebCred;
import com.example.quintor.transaction.Transaction;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.quintor.controllers.GetTransactions.getTransactions;

public class TransactionOverviewController extends SceneController implements Initializable {
    @FXML
    private Parent embeddedNav;
    private final Stage stage;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField search;
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

    public TransactionOverviewController() {
        this.stage = new Stage();
    }

    public void openLayout() throws IOException {
        changeView("transactionInformation", embeddedNav);
    }

    /**
     * This method gets called automatically when the contents of the fxml file are fully loaded
     * to perform post-processing on the content
     * It creates cell factory's for the table, then adds every transaction to an observable list and adds the
     * observable list to the transactions table.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            List<Transaction> allTransactions = GetTransactions.getTransactions();


            columnBedrag.setCellValueFactory(new PropertyValueFactory<Transaction, Double>("amount"));
            columnCategory.setCellValueFactory(new PropertyValueFactory<Transaction, String>("category"));
            columnCode.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("code"));
            columnDate.setCellValueFactory(new PropertyValueFactory<Transaction, String>("entryDate"));
            columnDebCred.setCellValueFactory(new PropertyValueFactory<Transaction, String>("debCred"));
            columnDescription.setCellValueFactory(new PropertyValueFactory<Transaction, String>("description"));
            columnType.setCellValueFactory(new PropertyValueFactory<Transaction, String>("type"));


            ObservableList<Transaction> transactions = transactionsTable.getItems();
            transactions.addAll(allTransactions);
            transactionsTable.setItems(transactions);
            transactionsTable.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) {
                    try {
                        openLayout();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

