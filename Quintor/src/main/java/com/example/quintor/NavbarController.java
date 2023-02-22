package com.example.quintor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Objects;

public class NavbarController {

    @FXML
    private BorderPane borderPane;

    public void initialize(){
//        loadPage("dashboard");
    }

    public void dashboardButton(){
//        loadPage("dashboard");
    }

    public void transactionButton(){
        loadPage("transactionsOverview");
    }

    public void settingsButton(){
//        loadPage("settings");
    }

    public void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(page + ".fxml")));
        }catch (IOException ex){
            System.out.println(ex);
        }
        borderPane.setCenter(root);
    }
}
