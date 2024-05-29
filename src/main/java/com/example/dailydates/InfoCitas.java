package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * La clase InfoCitas se utiliza para manejar la visualización y modificación de la información de citas en la aplicación.
 */
public class InfoCitas
{

    @javafx.fxml.FXML
    private Label anyadirCiudadLabel;
    @javafx.fxml.FXML
    private Label direccionLabel;
    @javafx.fxml.FXML
    private Label anyadirDireccionLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private Label ciudadLabel;
    @javafx.fxml.FXML
    private ImageView imagenPerfil;
    @javafx.fxml.FXML
    private Label anyadirNombreLabel;
    @javafx.fxml.FXML
    private Button modificarButton;
    @javafx.fxml.FXML
    private Label anyadirPedidoLabel;
    @javafx.fxml.FXML
    private Label anyadirFechaLabel;
    @javafx.fxml.FXML
    private Label anyadirHoraLabel;
    @javafx.fxml.FXML
    private Label pedidoLabel;
    @javafx.fxml.FXML
    private Button eliminarButton;

    private Citas citas;

    /**
     * Obtiene la cita actual.
     * @return la cita actual.
     */
    public Citas getCitas() {
        return citas;
    }

    /**
     * Establece la cita actual.
     * @param citas la cita a establecer.
     */
    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    private Empresa empresa;

    /**
     * Obtiene la empresa actual.
     * @return la empresa actual.
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa actual.
     * @param empresa la empresa a establecer.
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Inicializa la interfaz con la información de la cita y la empresa asociada.
     * @param c la cita a inicializar.
     */
    @javafx.fxml.FXML
    public void initialize(Citas c) {
        EmpresaModel empmod = new EmpresaModel();

        setCitas(c);
        setEmpresa(empmod.buscar_empresa(c.getId_empresa()));


        anyadirFechaLabel.setText(citas.getFecha().toString());
        anyadirHoraLabel.setText(citas.getHora().toString());
        anyadirCiudadLabel.setText(empresa.getCiudad());
        anyadirDireccionLabel.setText(empresa.getDireccion());
        anyadirNombreLabel.setText(empresa.getNombre());
        anyadirPedidoLabel.setText(citas.getPedido());
    }

    /**
     * Maneja el evento de clic del botón modificar. Carga la interfaz de modificación de citas.
     * @param actionEvent el evento de acción.
     */
    @javafx.fxml.FXML
    public void modificarButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ModificarCitas.fxml"));
            this.anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Maneja el evento de clic del botón eliminar. Elimina la cita actual.
     * @param actionEvent el evento de acción.
     */
    @javafx.fxml.FXML
    public void eliminarButtonOnAction(ActionEvent actionEvent) {
        // Implementar la lógica de eliminación de citas aquí
    }
}