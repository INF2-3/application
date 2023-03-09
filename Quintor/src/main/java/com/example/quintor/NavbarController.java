package com.example.quintor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class NavbarController extends SceneController {

    @FXML
    private BorderPane borderPane;

    public void initialize() {
//        loadPage("dashboard");
    }

    public void dashboardButton() {
//        loadPage("dashboard");
    }

    public void transactionButton() throws IOException {
//        switchScene(new ActionEvent(),"transactionOverview");
//        loadPage("transactionsOverview");
    }

    /**
     * Load settings page
     */
    public void settingsButton() {
        loadPage("settings");
    }

    @Override
    public void openLayout(){
        SettingsController settingsController = new SettingsController(this);

        // Show the new stage/window
        SettingsController.showStage();
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
        borderPane.setCenter(root);
    }
}
