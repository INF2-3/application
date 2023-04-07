package com.example.quintor;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController extends SceneController {
    @FXML
    private Parent embeddedNav;
    private static Stage stage;
    @FXML
    private BorderPane borderPane;
    @FXML
    public VBox settingsBox;

    @FXML
    private RadioButton jsonModus, xmlModus;

    public SettingsController() {
        stage = new Stage();
    }
    
     public void initialize() {
         switch(System.getProperty("MODUS")){
             case "JSON":
                 jsonModus.setSelected(true);
                 xmlModus.setSelected(false);
                 break;
             case "XML":
                 jsonModus.setSelected(false);
                 xmlModus.setSelected(true);
                 break;
              default: 
                 jsonModus.setSelected(true);
                 xmlModus.setSelected(false);
         }
    }

    public void changePassword() {
        // changeView("changePassword");
    }

    public void userOverview() {
//        changeView("createUser");
    }

    public void addonOverview() {
        // changeView("addonOverview");
    }

    public void logout() throws IOException {
    }

    /**
     * Updates the modus to json or xml
     */
    public void changeModus(){
        if(jsonModus.isSelected()){
            System.setProperty("MODUS", "JSON");
        }else if(xmlModus.isSelected()){
            System.setProperty("MODUS", "XML");
        }
    }
}
