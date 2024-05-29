package com.example.dailydates;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.Time;

public class ModificarCitas
{
    @javafx.fxml.FXML
    private Label anyadirFechaLabel;
    @javafx.fxml.FXML
    private Label anyadirHoraLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private TextArea pedidoTextArea;
    @javafx.fxml.FXML
    private Spinner horaSpinner;
    @javafx.fxml.FXML
    private DatePicker fechaDatePicker;
    @javafx.fxml.FXML
    private Label pedidoLabel;
    @javafx.fxml.FXML
    private Button guardarButton;
    private Citas citas;

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    @javafx.fxml.FXML
    public void initialize(Citas c) {

        ObservableList<String> opciones = FXCollections.observableArrayList();

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 15) {
                String time = String.format("%02d:%02d:00", hour, minute);
                opciones.add(time);
            }
        }
        SpinnerValueFactory<String> hora = new SpinnerValueFactory.ListSpinnerValueFactory<String>(opciones);
        horaSpinner.setValueFactory(hora);


        setCitas(c);

        fechaDatePicker.setValue(citas.getFecha());
        horaSpinner.getValueFactory().setValue(citas.getHora());
        pedidoTextArea.setText(citas.getPedido());

    }

    @javafx.fxml.FXML
    public void guardarButtonOnAction(ActionEvent actionEvent) {

        CitasModel citmod = new CitasModel();

        if (citmod.mod_cita(citas,fechaDatePicker.getValue(), (Time) horaSpinner.getValue(),pedidoTextArea.getText())){

        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error al modificar cita");
            a.showAndWait();
        }


    }
}