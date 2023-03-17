module com.example.quintor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.quintor to javafx.fxml;
    exports com.example.quintor;
    exports com.example.quintor.transaction;
    opens com.example.quintor.transaction to javafx.fxml;
}