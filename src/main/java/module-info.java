module com.example.dailydates {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dailydates to javafx.fxml;
    exports com.example.dailydates;
}