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

    /**
     * Inicializa la vista del calendario.
     *
     * Este método realiza las siguientes acciones:
     * 1. Crea instancias de los modelos CitasModel y EmpresaModel.
     * 2. Obtiene la instancia del EmpresarioHolder.
     * 3. Crea una instancia de CalendarView.
     * 4. Crea un nuevo calendario y lo agrega a CalendarView.
     * 5. Crea un botón "Añadir Evento" y configura su acción para agregar eventos al calendario.
     * 6. Agrega CalendarView al AnchorPane y configura su posición y tamaño.
     * 7. Obtiene el Empresario actual del EmpresarioHolder.
     * 8. Itera sobre las citas del Empresario y agrega entradas al calendario con la hora, el pedido y la dirección de la empresa.
     */
    @Deprecated
    public void initialize() {

        // Obtener instancias de los modelos CitasModel y EmpresaModel
        CitasModel ca = new CitasModel();
        // Obtener instancia de EmpresarioHolder
        EmpresarioHolder em = EmpresarioHolder.getInstance();
        EmpresaModel empmod = new EmpresaModel();

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

        anchorPane.getChildren().add(calendarView);
        anchorPane.setTopAnchor(calendarView, 0.0);
        anchorPane.setRightAnchor(calendarView, 0.0);
        anchorPane.setBottomAnchor(calendarView, 50.0);
        anchorPane.setLeftAnchor(calendarView, 0.0);

        // Obtener el Empresario actual
        Empresario emp = em.getEmpresario();

        // Iterar sobre las citas del Empresario y agregarlas al calendario
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
    /**
     * Agrega un evento al calendario en una fecha y hora específicas.
     *
     * @param calendar El calendario al que se agregará el evento.
     */
    private void agregarEvento(Calendar calendar) {
        // Crear evento en una fecha y hora específica

        LocalDateTime startDateTime = LocalDateTime.of(2024, Month.MAY, 17, 10, 0);

        // Crear y configurar la entrada
        Entry<String> entry = new Entry<>("Vicent homo");
        entry.setInterval(startDateTime);
        entry.setLocation("Ubicación del evento");

        // Añadir la entrada al calendario
        calendar.addEntry(entry);
    }
}