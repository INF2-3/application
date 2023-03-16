package com.example.quintor;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Label clubName;
    @FXML
    private TableColumn<BankStatement, String> columnAccountNumber;
    @FXML
    private TableColumn<BankStatement, String> columnFileDate;
    @FXML
    private TableColumn<BankStatement, Integer> columnFileId;
    @FXML
    private TableColumn<BankStatement, User> columnFileUploader;
    @FXML
    private TableColumn<BankStatement, Double> columnFinalBalance;
    @FXML
    private TableView<BankStatement> transcriptTable;
    @FXML
    private Button uploadButton;

    /**
     * This method gets called automatically when the contents of the fxml file are fully loaded
     * to perform post-processing on the content
     * It creates cell factory's for the table, then adds every transcript to an observable list and adds the
     * observable list to the transactions table.
     *
     * @param url            The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnFileId.setCellValueFactory(new PropertyValueFactory<BankStatement, Integer>("id"));
        columnFileDate.setCellValueFactory(new PropertyValueFactory<BankStatement, String>("uploadDate"));
        columnFileUploader.setCellValueFactory(new PropertyValueFactory<BankStatement, User>("userName"));
        columnFinalBalance.setCellValueFactory(new PropertyValueFactory<BankStatement, Double>("finalBalance"));
        columnAccountNumber.setCellValueFactory(new PropertyValueFactory<BankStatement, String>("accountNumber"));

        BankStatement file = new BankStatement(1, "939DFKS9234", "IBAN09374229", 20,
                new BankStatementDescription(1, 2, 1, 2, 483.4), new User("test@gmail.com", "tester", 1),
                "12-12-2023");
        ObservableList<BankStatement> bankStatements = transcriptTable.getItems();
        bankStatements.add(file);
        transcriptTable.setItems(bankStatements);
    }

    public void uploadButtonAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("MT940 files", "*.940"));
        File f = fc.showOpenDialog(null);
        if (f != null) {

        }
    }
}
