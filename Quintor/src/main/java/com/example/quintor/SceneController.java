package com.example.quintor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public abstract class SceneController{

    private static Stage stage;


    public SceneController(){
        stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("navbar.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            stage.setScene(new Scene(loader.load()));

            // Set up the window/stage
            stage.setTitle("Passing Controllers Example - Layout1");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show the stage that was loaded in the constructor
     */
    public static void showStage() {
        stage.showAndWait();
    }
    /**
     * The initialize() method allows you set up your scene, adding actions, configuring nodes, etc.
     */
    @FXML
    private void initialize(Button btnOpenLayout) {

        // Add an action for the “Open Layout2” button
        btnOpenLayout.setOnAction(event -> openLayout());
    }

    /**
     * Performs the action of loading and showing Layout2
     */
    public abstract void openLayout();
}
