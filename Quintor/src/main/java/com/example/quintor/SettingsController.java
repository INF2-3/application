package com.example.quintor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController extends SceneController{
    @FXML
    private AnchorPane anchorPane;
    @FXML
    public VBox settingsBox;

    public SettingsController(NavbarController navbarController) {

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

    /**
     * Change view of the settings page
     * @param view String name of fxml file
     */
    public void changeView(String view) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(view + ".fxml"));
            AnchorPane myAnchorPane = loader.load();
            anchorPane.getChildren().add(myAnchorPane);

            anchorPane.getChildren().remove(settingsBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void openLayout() {
       // buttonName.setOnAction(event -> openLayout());
    }
}
