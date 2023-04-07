package com.example.quintor;

import com.example.quintor.dataobjects.BankStatement;
import com.example.quintor.dataobjects.XmlOrJson;
import com.example.quintor.getdata.GetTransactions;
import com.example.quintor.dataobjects.Transaction;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

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
    private TableColumn<Transaction, LocalDate> columnDate;
    @FXML
    private TableColumn<Transaction, String> columnDebCred;
    @FXML
    private TableColumn<Transaction, String> columnDescription;
    private XmlOrJson xmlOrJson = XmlOrJson.JSON;

    private static int fileId = -1;

    public TransactionOverviewController() {
        this.stage = new Stage();
    }

    public void openLayout() throws IOException {
        changeView("transactionInformation", embeddedNav);
    }

    public static void setFileId(int id) {
        TransactionOverviewController.fileId = id;
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
            List<Transaction> allTransactions;
            if (fileId == -1) {
                allTransactions = getAllTransactions();
            } else {
                allTransactions = getBankStatementTransactions(fileId);
                fileId = -1;
            }

            search.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    List<Transaction> matchingTransactions = new ArrayList<>();
                    String filterInput = search.getText();
                    for (Transaction transaction : allTransactions) {
                        if (Stream.of(
                                transaction.getValueDate(),
                                String.valueOf(transaction.getAmount()),
                                transaction.getCategoryName(),
                                transaction.getOriginalDescription().toString(),
                                transaction.getReferenceOwner(),
                                transaction.getInstitutionReference(),
                                transaction.getCode()
                        ).anyMatch(value -> value.toLowerCase().contains(filterInput.toLowerCase()))) {
                            matchingTransactions.add(transaction);
                        }

                    }
                    setTransactionsTable(matchingTransactions);
                }
            });

            setTransactionsTable(allTransactions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTransactionsTable(List<Transaction> transactionsList) {
        transactionsTable.getItems().clear();
        columnBedrag.setCellValueFactory(new PropertyValueFactory<Transaction, Double>("amount"));
        columnCategory.setCellValueFactory(new PropertyValueFactory<Transaction, String>("categoryName"));
        columnCode.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("code"));
        columnDate.setCellValueFactory(new PropertyValueFactory<Transaction, LocalDate>("valueDate"));
        columnDebCred.setCellValueFactory(new PropertyValueFactory<Transaction, String>("debCred"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<Transaction, String>("description"));

        ObservableList<Transaction> transactions = transactionsTable.getItems();
        transactions.addAll(transactionsList);
        transactionsTable.setRowFactory(tv -> {
            TableRow<Transaction> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Transaction transaction = row.getItem();
                    TransactionInformationController.setTransactionId(transaction);
                    try {
                        openLayout();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            return row;
        });
    }

    public List<Transaction> getAllTransactions() throws IOException {
        List<Transaction> allTransactions = GetTransactions.getTransactionsXML();
        GetTransactions.getTransactionsJSON();
        return allTransactions;
    }

    public List<Transaction> getBankStatementTransactions(int id) throws IOException {
        List<Transaction> bankStatementTransactions = new ArrayList<>();
        for(Transaction transaction : getAllTransactions()) {
            if (transaction.getFileId() == id) {
                bankStatementTransactions.add(transaction);
            }
        }
        return bankStatementTransactions;
    }
}

