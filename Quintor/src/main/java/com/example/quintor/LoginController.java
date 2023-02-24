package com.example.quintor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    private String email;
    private String hashedPassword;

    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLabel = null;



    public void pressLoginButton() {
        if(this.emailField.getText().isEmpty() || this.passwordField.getText().isEmpty()) {
            this.errorLabel.setText("Er is geen e-mailadres of wachtwoord ingevuld");
            return;
        }

        this.email = this.emailField.getText();
        this.hashedPassword = this.passwordField.getText();
    }

}
