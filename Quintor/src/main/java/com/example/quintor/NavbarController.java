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
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("navbar.fxml"));
//        try{
//            // Set this class as the controller
//            loader.setController(this);
//
//            // Load the scene
//            stage.setScene(new Scene(loader.load()));
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//
//        // Set up the window/stage
//        stage.setTitle("Quintor");

    }

    public void initialize() {
        dashboardButton.setOnAction(event -> dashboardButton());
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

    public void dashboardButton() {
//        loadPage("dashboard");

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
