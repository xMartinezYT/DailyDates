package com.example.dailydates;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.internal.icu.impl.NormalizerImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;

public class PaginaCalendario
{
    @javafx.fxml.FXML
    private AnchorPane anchorPane;

    @Deprecated
    public void initialize() {

        CitasModel ca = new CitasModel();
        EmpresarioHolder em = EmpresarioHolder.getInstance();
        EmpresaModel empmod = new EmpresaModel();

        // Crear instancia de CalendarView
        CalendarView calendarView = new CalendarView();

        // Crear un calendario y añadirlo a CalendarView
        Calendar calendar = new Calendar("My Calendar");
        CalendarSource calendarSource = new CalendarSource("My Calendars");
        calendarSource.getCalendars().add(calendar);
        calendarView.getCalendarSources().add(calendarSource);

        anchorPane.getChildren().add(calendarView);
        anchorPane.setTopAnchor(calendarView, 0.0);
        anchorPane.setRightAnchor(calendarView, 0.0);
        anchorPane.setBottomAnchor(calendarView, 50.0);
        anchorPane.setLeftAnchor(calendarView, 0.0);

        Empresario emp = em.getEmpresario();

        for (Citas i : ca.listar_citas_empresario(emp.getId())){

         String hora = String.valueOf(i.getHora());
         String pedido =  i.getPedido();
         
         LocalDateTime startDateTime = LocalDateTime.of(i.getFecha().getYear(), i.getFecha().getMonth(), i.getFecha().getDayOfMonth(), i.getHora().getHours(), i.getHora().getMinutes());
            Entry<String> entry = new Entry<>(pedido);
            entry.setInterval(startDateTime);
            entry.setLocation(empmod.buscar_empresa(i.getId_empresa()).getDireccion());
            calendar.addEntry(entry);

        }
    }

}