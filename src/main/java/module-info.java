module com.example.phase2_main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.phase2_main to javafx.fxml;
    exports com.example.phase2_main;

}