package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase Citasmostrar se utiliza para manejar la interfaz gráfica de las citas en la aplicación.
 * Proporciona métodos para inicializar la interfaz y manejar eventos de acción.
 */
public class Citasmostrar
{
    @javafx.fxml.FXML
    private AnchorPane mainAnchorPane;
    @javafx.fxml.FXML
    private Label labelHora;
    @javafx.fxml.FXML
    private Label nombreNegocio;
    @javafx.fxml.FXML
    private Label labelFecha;
    @javafx.fxml.FXML
    private Button buttonInfo;

    private Citas citas;

    /**
     * Obtiene el objeto Citas actual.
     *
     * @return el objeto Citas.
     */
    public Citas getCitas() {
        return citas;
    }

    /**
     * Establece el objeto Citas.
     *
     * @param citas el objeto Citas a establecer.
     */
    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    /**
     * Inicializa la interfaz con la información de la cita.
     *
     * @param c el objeto Citas a utilizar para inicializar la interfaz.
     */
    @Deprecated
    public void initialize(Citas c) {
        setCitas(c);
        labelFecha.setText(citas.getFecha().toString());

        // Aquí se puede añadir más código para inicializar otros componentes si es necesario
    }

    /**
     * Maneja el evento de clic en el botón de información.
     * Carga y muestra una nueva ventana con detalles adicionales de la cita.
     *
     * @param actionEvent el evento de acción generado por el clic en el botón.
     */
    @javafx.fxml.FXML
    public void infoclick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InfoCitas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}