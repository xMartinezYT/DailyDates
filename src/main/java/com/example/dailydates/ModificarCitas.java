package com.example.dailydates;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.Time;

/**
 * Controlador para la ventana de modificación de citas.
 */
public class ModificarCitas
{
    // Elementos de la interfaz definidos en el archivo FXML

    /**
     * Etiqueta para la fecha de la cita.
     */
    @javafx.fxml.FXML
    private Label anyadirFechaLabel;

    /**
     * Etiqueta para la hora de la cita.
     */
    @javafx.fxml.FXML
    private Label anyadirHoraLabel;

    /**
     * Panel de anclaje principal.
     */
    @javafx.fxml.FXML
    private AnchorPane anchorPane;

    /**
     * Área de texto para ingresar el pedido de la cita.
     */
    @javafx.fxml.FXML
    private TextArea pedidoTextArea;

    /**
     * Selector de hora para la cita.
     */
    @javafx.fxml.FXML
    private Spinner horaSpinner;

    /**
     * Selector de fecha para la cita.
     */
    @javafx.fxml.FXML
    private DatePicker fechaDatePicker;

    /**
     * Etiqueta para mostrar el pedido.
     */
    @javafx.fxml.FXML
    private Label pedidoLabel;

    /**
     * Botón para guardar los cambios de la cita.
     */
    @javafx.fxml.FXML
    private Button guardarButton;

    // Otros atributos

    /**
     * Objeto de tipo Citas que representa la cita a modificar.
     */
    private Citas citas;

    // Métodos

    /**
     * Método para obtener la cita.
     *
     * @return La cita.
     */

    public Citas getCitas() {
        return citas;
    }

    /**
     * Método para establecer la cita.
     *
     * @param citas La cita a establecer.
     */
    public void setCitas(Citas citas) {
        this.citas = citas;
    }


    /**
     * Inicializa la ventana de modificación de citas.
     *
     * @param c La cita a modificar.
     */
    @javafx.fxml.FXML
    public void initialize(Citas c) {

        // Configuración del Spinner para seleccionar la hora
        ObservableList<String> opciones = FXCollections.observableArrayList();

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 15) {
                String time = String.format("%02d:%02d:00", hour, minute);
                opciones.add(time);
            }
        }
        SpinnerValueFactory<String> hora = new SpinnerValueFactory.ListSpinnerValueFactory<String>(opciones);
        horaSpinner.setValueFactory(hora);
        // Configuración de los campos con los datos de la cita existente

        setCitas(c);

        fechaDatePicker.setValue(citas.getFecha());
        horaSpinner.getValueFactory().setValue(citas.getHora());
        pedidoTextArea.setText(citas.getPedido());

    }

    /**
     * Maneja el evento cuando se hace clic en el botón de guardar.
     *
     * @param actionEvent El evento de acción.
     */
    @javafx.fxml.FXML
    public void guardarButtonOnAction(ActionEvent actionEvent) {
        // Se intenta guardar la cita modificada
        CitasModel citmod = new CitasModel();
        EmpresaModel em = new EmpresaModel();

        String horario = em.buscar_empresa(citas.getId_empresa()).getHorario();
        Time hora = Time.valueOf(horaSpinner.getValue().toString());
        boolean cambioCorrecto = em.comprobarHorario(hora, horario);

        if (cambioCorrecto) {
        if (citmod.mod_cita(citas,fechaDatePicker.getValue(), Time.valueOf(horaSpinner.getValue().toString()),pedidoTextArea.getText())){
            // La modificación fue exitosa
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Guardado correctamente");
            a.showAndWait();
        }else{
            // Se muestra una alerta en caso de error
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error al modificar cita");
            a.showAndWait();
        } } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Hora no disponible");
            a.showAndWait();
        }




    }
}

