package com.example.quintor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    @FXML
    private Parent embeddedNav;
    private static Stage stage;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    public VBox settingsBox;

    public SettingsController(){
        stage = new Stage();
    }
    public Scene getScene(){
        return stage.getScene();
    }


    public static void showStage() {
        stage.showAndWait();
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
