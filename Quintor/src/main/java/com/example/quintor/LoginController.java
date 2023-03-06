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

    /**
     * Checks if the email and password fields are empty, gives error if they are empty.
     * Sets the email and password, if they can't set gives error.
     */
    public void pressLoginButton() {
        if (this.emailField.getText().isEmpty() || this.passwordField.getText().isEmpty()) {
            this.errorLabel.setText("Er is geen e-mailadres of wachtwoord ingevuld");
            return;
        }
        if (!this.setEmail(this.emailField.getText()) || !this.setHashedPassword(this.passwordField.getText())) {
            this.errorLabel.setText("De inloggegevens kloppen niet.");
            return;
        }
        this.errorLabel.setText(" ");
    }

}
