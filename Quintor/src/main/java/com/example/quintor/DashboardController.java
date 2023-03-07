package com.example.quintor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane dashboard;

    public void uploadFile(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("bankStatementDetailed.fxml"));
            AnchorPane myAnchorPane = loader.load();
            anchorPane.getChildren().add(myAnchorPane);

            anchorPane.getChildren().remove(dashboard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
