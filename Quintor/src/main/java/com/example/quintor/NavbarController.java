package com.example.quintor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NavbarController extends SceneController {

    public AnchorPane anchorPane;
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

    /**
     * These methodes change the page.
     */
    public void dashboardButton() throws IOException {
        changeView("dashboard", dashboardButton);

    }

    public void transactionButton() throws IOException {
        changeView("transactionsOverview", transactionButton);
    }

    public void settingsButton() throws IOException {
        changeView("settings", settingsButton);
    }
}
