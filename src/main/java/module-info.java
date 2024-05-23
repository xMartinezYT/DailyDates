module com.example.dailydates {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires com.calendarfx.view;
    requires java.desktop;


    opens com.example.dailydates to javafx.fxml;
    exports com.example.dailydates;
}