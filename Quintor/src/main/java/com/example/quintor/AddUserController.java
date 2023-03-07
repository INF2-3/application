package com.example.quintor;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddUserController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox roleField;
    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        roleField.getItems().clear();
        roleField.getItems().addAll("Gebruiker", "Penningmeester");
    }

    public void makeUser() {
        if (this.emailField.getText().isEmpty() || this.passwordField.getText().isEmpty()) {
            this.errorLabel.setText("Er is geen e-mailadres of wachtwoord ingevuld");
            return;
        }
        //password hashen moet nog gebeuren.
        //role moet nog meegegeven kunnen worden als int.
        try {
            User user = new User(1, this.emailField.getText(), this.passwordField.getText());
            this.errorLabel.setText("De gebruiker is aangemaakt.");
        } catch (Exception e) {
            this.errorLabel.setText("De gegevens zijn niet correct.");
        }
        this.errorLabel.setText(" ");

    }

}
