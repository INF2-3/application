module com.example.quintor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quintor to javafx.fxml;
    exports com.example.quintor;
    opens com.example.quintor.controller to javafx.fxml;
    exports com.example.quintor.controller;
}