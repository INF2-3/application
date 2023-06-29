package com.example.quintor;

import com.example.quintor.dataobjects.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
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
    private Label valueDate;
    @FXML
    private Label entryDate;
    @FXML
    private Label amount;
    @FXML
    private Label debitCredit;
    @FXML
    private Label transactionCode;
    @FXML
    private TextField optionalDescription;
    @FXML
    private Label referenceOwner;
    @FXML
    private Label referenceInstitution;
    @FXML
    private Label supplementaryDetails;
    @FXML
    private Text originalDescription;
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

    public void change() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL((System.getenv("URL_API") + "/api/postgres/update")).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();
        String params = "transactionId=" + transaction.getId() + "&description=" + optionalDescription.getText() + "&category=" + transactionCategory.getText() + "&mode=" + System.getProperty("MODUS");
        os.write(params.getBytes());
        os.flush();
        os.close();
        System.out.println(connection.getResponseCode());
        if (connection.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Er ging iets mis");
            alert.setContentText("De beschrijving en/of categorie kon niet aangepast worden");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Gelukt!");
            alert.setContentText("Beschrijving en categorie aangepast ");
            alert.show();
        }
    }

    public static void setTransactionId(Transaction transaction) {
        TransactionInformationController.transaction = transaction;
    }

    public static Transaction getTransactionId() {
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
        if (transaction.getCategory() == null) {
            this.transactionCategory.setText("");
        } else {
            this.transactionCategory.setText(transaction.getCategory().getName());
        }
    }

}
