package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Controlador para la visualización de la información de una cita.
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
     * Obtiene la cita asociada a esta vista.
     *
     * @return La cita asociada.
     */
    public Citas getCitas() {
        return citas;
    }

    /**
     * Establece la cita asociada a esta vista.
     *
     * @param citas La cita a establecer.
     */
    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    private Empresa empresa;

    /**
     * Obtiene la empresa asociada a esta vista.
     *
     * @return La empresa asociada.
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa asociada a esta vista.
     *
     * @param empresa La empresa a establecer.
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


    /**
     * Método de inicialización que se llama cuando se carga la vista.
     * Establece la información de la cita y la empresa asociada.
     *
     * @param c La cita para la que se muestra la información.
     */
    @Deprecated
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
        imagenPerfil.setImage(empresa.getFoto_empresa());
    }

    /**
     * Maneja el evento de clic en el botón de modificación.
     * Abre la vista de modificación de la cita.
     *
     * @param actionEvent El evento de clic.
     */
    @javafx.fxml.FXML
    public void modificarButtonOnAction(ActionEvent actionEvent) {

        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ModificarCitas.fxml"));
        AnchorPane anchor = fxmlLoader.load();
        ModificarCitas cita = fxmlLoader.getController();
        cita.initialize(citas);
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(anchor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Maneja el evento de clic en el botón de eliminación.
     * Elimina la cita actual y muestra un mensaje de éxito o error.
     *
     * @param actionEvent El evento de clic.
     */
    @javafx.fxml.FXML
    public void eliminarButtonOnAction(ActionEvent actionEvent) {
             CitasModel citmod = new CitasModel();
        if(citmod.eliminar_cita(citas)){
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setContentText("Eliminada con Exito");
            al.showAndWait();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error al eliminar Cita");
            a.showAndWait();
        }

    }
}