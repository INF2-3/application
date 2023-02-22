package com.example.quintor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
    int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

    @Override
    public void start(Stage stage) throws Exception {
        // Responsive Design
        int sceneWidth = 0;
        int sceneHeight = 0;
        if (screenWidth <= 800 && screenHeight <= 600) {
            sceneWidth = 600;
            sceneHeight = 350;
        } else if (screenWidth <= 1280 && screenHeight <= 768) {
            sceneWidth = 800;
            sceneHeight = 450;
        } else if (screenWidth <= 1920 && screenHeight <= 1080) {
            sceneWidth = 1000;
            sceneHeight = 650;
        }

        // Scene
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("transactionsOverview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), sceneWidth, sceneHeight);
        String css = this.getClass().getResource("/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setMaximized(true);
        stage.setResizable(false);
        System.out.println(screenWidth);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}