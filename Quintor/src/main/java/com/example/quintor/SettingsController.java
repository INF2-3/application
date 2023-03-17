package com.example.quintor;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController extends SceneController {
    @FXML
    private Parent embeddedNav;
    private static Stage stage;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    public VBox settingsBox;

    public SettingsController() {
        stage = new Stage();
    }

    public void changePassword() {
//        changeView("changePassword");
    }

    public void userOverview() {
//        changeView("userOverview");
    }

    public void addonOverview() {
//        changeView("addonOverview");
    }

    public void logout() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
//        Parent root = loader.load();
//        Scene newScene = new Scene(root);
//        Stage stage = (Stage) anchorPane.getScene().getWindow();
//        Scene oldScene = stage.getScene();
//        if (oldScene != null) {
//            stage.close();
//        }
//        stage.setScene(newScene);
//        stage.show();
    }
}
