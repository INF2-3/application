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
    private Label errorLabel;

    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public boolean setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
        return true;
    }

    public void pressLoginButton() {
        if(this.emailField.getText().isEmpty() || this.passwordField.getText().isEmpty()) {
            this.errorLabel.setText("Er is geen e-mailadres of wachtwoord ingevuld");
            return;
        }
        if(!this.setEmail(this.emailField.getText()) && !this.setHashedPassword(this.passwordField.getText())) {
            this.errorLabel.setText("De inloggegevens kloppen niet.");
        }
        this.errorLabel.setText(" ");
    }

}
