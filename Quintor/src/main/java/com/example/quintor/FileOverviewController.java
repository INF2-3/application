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

public class FileOverviewController implements Initializable {

    @FXML
    private Label clubName;

    @FXML
    private TableColumn<TranscriptFile, String> columnAccountNumber;

    @FXML
    private TableColumn<TranscriptFile, String> columnFileDate;

    @FXML
    private TableColumn<TranscriptFile, Integer> columnFileId;

    @FXML
    private TableColumn<TranscriptFile, User> columnFileUploader;

    @FXML
    private TableColumn<TranscriptFile, Double> columnFinalBalance;

    @FXML
    private TableView<TranscriptFile> transcriptTable;

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
        columnFileId.setCellValueFactory(new PropertyValueFactory<TranscriptFile, Integer>("id"));
        columnFileDate.setCellValueFactory(new PropertyValueFactory<TranscriptFile, String>("uploadDate"));
        columnFileUploader.setCellValueFactory(new PropertyValueFactory<TranscriptFile, User>("userName"));
        columnFinalBalance.setCellValueFactory(new PropertyValueFactory<TranscriptFile, Double>("finalBalance"));
        columnAccountNumber.setCellValueFactory(new PropertyValueFactory<TranscriptFile, String>("accountNumber"));

        TranscriptFile file = new TranscriptFile(1, "939DFKS9234", "IBAN09374229", 20,
                new FileDescription(1, 2, 1, 2, 483.4), new User("test@gmail.com", "tester", 1),
                "12-12-2023");
        ObservableList<TranscriptFile> transcriptFiles = transcriptTable.getItems();
        transcriptFiles.add(file);
        transcriptTable.setItems(transcriptFiles);
    }

    public void uploadButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File uploadedFile = fileChooser.showOpenDialog(null);

        if (uploadedFile == null) {
            System.out.println("error uploading file");
        } else {
            System.out.println("success");
        }
    }
}
