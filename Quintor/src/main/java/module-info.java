module com.example.quintor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.json;
    requires java.xml;


    opens com.example.quintor to javafx.fxml;
    exports com.example.quintor;
    exports com.example.quintor.services;
    opens com.example.quintor.services to javafx.fxml;
    exports com.example.quintor.dataobjects;
    opens com.example.quintor.dataobjects to javafx.fxml;
}