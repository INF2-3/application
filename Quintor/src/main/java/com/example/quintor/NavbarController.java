package com.example.quintor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NavbarController{

    private NavbarController navbarController;
    private final Stage stage;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button transactionButton;
    @FXML
    private Button settingsButton;
    public NavbarController() {
        this.stage = new Stage();
    }

    public void initialize() {
        dashboardButton.setOnAction(event -> {
            try {
                dashboardButton();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        transactionButton.setOnAction(event -> {
            try {
                transactionButton();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        settingsButton.setOnAction(event -> {
            try {
                settingsButton();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void dashboardButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
        Stage window = (Stage)dashboardButton.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    public void transactionButton() throws IOException {
        TransactionOverviewController transactionOverviewController = new TransactionOverviewController();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("transactionsOverview.fxml")));
        Stage window = (Stage)transactionButton.getScene().getWindow();
        window.setScene(new Scene(root));

    }

    /**
     * Load settings page
     */
    public void settingsButton() throws IOException {
        SettingsController settingsController = new SettingsController();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("settings.fxml")));
        Stage window = (Stage)settingsButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void showStage() {
        stage.showAndWait();

    }





















    /**
     * load page
     *
     * @param page String name of the fxml file
     */
    public void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        } catch (IOException ex) {
            System.out.println(ex);
        }
//        borderPane.setCenter(root);
    }
}
