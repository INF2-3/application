package com.example.quintor;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateUserController {
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ComboBox roleField;
    @FXML
    private Label errorLabel;
    @FXML
    private Label succesLabel;

    @FXML
    public void initialize() {
        roleField.getItems().clear();
        roleField.getItems().addAll("Gebruiker", "Penningmeester");
    }

    public void makeUser() {
        System.out.println(this.roleField.getValue());
        if (this.emailField.getText().isEmpty() || this.passwordField.getText().isEmpty() || this.roleField.getValue() == null) {
            this.errorLabel.setText("Er is geen e-mailadres, wachtwoord of rol ingevuld");
            return;
        }
        this.errorLabel.setText(" ");
        this.succesLabel.setText(" ");

        //password hashen moet nog gebeuren.
        //role moet nog meegegeven kunnen worden als int.
        try {
            User user = new User(1, this.emailField.getText(), this.passwordField.getText());
            this.succesLabel.setText("De gebruiker is aangemaakt.");
        } catch (Exception e) {
            this.errorLabel.setText("De gegevens zijn niet correct.");
        }

    }

}
