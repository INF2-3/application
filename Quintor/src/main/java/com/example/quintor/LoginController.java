package com.example.quintor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController {
    public Button loginButton;
    @FXML
    private AnchorPane anchorPane;
    private String email;
    private String hashedPassword;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label errorLabel;
    
    /**
     * Sets the xml or json modus to json
     */

    public void initialize() {
        System.setProperty("MODUS", "JSON");
    }

    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public boolean setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
        return true;
    }

    /**
     * Checks if the email and password fields are empty, gives error if they are empty.
     * Sets the email and password, if they can't set gives error.
     */
    public void pressLoginButton() throws IOException {
        if (this.emailField.getText().isEmpty() || this.passwordField.getText().isEmpty()) {
            this.errorLabel.setText("Er is geen e-mailadres of wachtwoord ingevuld");
            return;
        }
        if (!this.setEmail(this.emailField.getText()) || !this.setHashedPassword(this.passwordField.getText())) {
            this.errorLabel.setText("De inloggegevens kloppen niet.");
            return;
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
        Stage window = (Stage) loginButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
