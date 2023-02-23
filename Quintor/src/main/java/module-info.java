module com.example.quintor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quintor to javafx.fxml;
    exports com.example.quintor;
}