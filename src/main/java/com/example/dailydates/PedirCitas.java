package com.example.dailydates;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.sql.Time;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Controlador para la ventana de solicitud de citas.
 * Permite a los usuarios enviar solicitudes de citas a las empresas.
 */
public class PedirCitas
{
    @javafx.fxml.FXML
    private Label direccionLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Label horaLabel;
    @javafx.fxml.FXML
    private Label fechaLabel;
    @javafx.fxml.FXML
    private TextField nombreTextField;
    @javafx.fxml.FXML
    private Label nombreUsuarioLabel;
    @javafx.fxml.FXML
    private Spinner horaSpinner;
    @javafx.fxml.FXML
    private TextArea pedidoTextArea;
    @javafx.fxml.FXML
    private Pane citaPane;
    @javafx.fxml.FXML
    private DatePicker fechaDatePicker;
    @javafx.fxml.FXML
    private Label pedidoLabel;
    @javafx.fxml.FXML
    private Label pideCitaLabel;
    @javafx.fxml.FXML
    private Button guardarCambiosButton;
    private Usuario usuario;


    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa para la cual se solicitará la cita.
     * @param empresa La empresa para la cual se solicitará la cita.
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Inicializa la ventana de solicitud de citas.
     * Establece los valores iniciales y las opciones para el spinner de horas.
     * @param empresa La empresa para la cual se solicitará la cita.
     */
    @Deprecated
    public void initialize(Empresa empresa) {

        setEmpresa(empresa);
        UsuarioHolder usuarioHolder = UsuarioHolder.getInstance();
        nombreTextField.setText(usuarioHolder.getUsuario().getGmail());
        usuario = usuarioHolder.getUsuario();

        ObservableList<String> opciones = FXCollections.observableArrayList();

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 15) {
                String time = String.format("%02d:%02d:00", hour, minute);
                opciones.add(time);
            }
        }

        SpinnerValueFactory<String> hora = new SpinnerValueFactory.ListSpinnerValueFactory<String>(opciones);
        horaSpinner.setValueFactory(hora);
    }

    /**
     * Maneja el evento del botón "Guardar cambios".
     * Guarda la cita en la base de datos con la información proporcionada por el usuario.
     * @param actionEvent Evento de acción del botón "Guardar cambios".
     */
    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {

        EmpresaModel empresaModel = new EmpresaModel();

        CitasModel citmod = new CitasModel();

        Time t = Time.valueOf(horaSpinner.getValue().toString());


        Citas c = new Citas(this.usuario.getId(), this.empresa.getId_empresa(), fechaDatePicker.getValue(), t, pedidoTextArea.getText());





        boolean cambioCorrecto = empresaModel.comprobarHorario(c.getHora(), empresa.getHorario());

        if (cambioCorrecto) {
            if (citmod.anyadir_cita(c)) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Añadido correctamente");
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Error al añadir cita");
                a.showAndWait();
            }

        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Esta hora no esta disponible revisa el horario");
            a.showAndWait();
        }
        }
    }

