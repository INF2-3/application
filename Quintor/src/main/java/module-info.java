module com.example.quintor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quintor to javafx.fxml;
    exports com.example.quintor;
    exports com.example.quintor.controller;
    opens com.example.quintor.controller to javafx.fxml;
}