package com.example.quintor;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public abstract class SceneController {
    public void changeView(String page, Node button) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
