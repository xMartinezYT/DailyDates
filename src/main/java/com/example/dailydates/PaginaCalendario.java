package com.example.dailydates;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.Month;

public class PaginaCalendario
{
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Label calendarioLabel;
    @javafx.fxml.FXML
    private Button pepe;

    @Deprecated
    public void initialize(Stage primaryStage) {



    }

    private void agregarEvento(Calendar calendar) {
        // Crear evento en una fecha y hora específica
        LocalDateTime startDateTime = LocalDateTime.of(2024, Month.MAY, 17, 10, 0);
        LocalDateTime endDateTime = startDateTime.plusHours(1);

        // Crear y configurar la entrada
        Entry<String> entry = new Entry<>("Vicent homo");
        entry.setInterval(startDateTime, endDateTime);
        entry.setLocation("Ubicación del evento");


        // Añadir la entrada al calendario
        calendar.addEntry(entry);
    }

    @javafx.fxml.FXML
    public void sexo(ActionEvent actionEvent) {
        // Crear instancia de CalendarView
        CalendarView calendarView = new CalendarView();

        // Crear un calendario y añadirlo a CalendarView
        Calendar calendar = new Calendar("My Calendar");
        CalendarSource calendarSource = new CalendarSource("My Calendars");
        calendarSource.getCalendars().add(calendar);
        calendarView.getCalendarSources().add(calendarSource);

        // Botón para añadir evento
        Button addButton = new Button("Añadir Evento");
        addButton.setOnAction(e -> agregarEvento(calendar));

        VBox root = new VBox();
        root.getChildren().add(calendarView);
        root.getChildren().add(addButton);
    }
}