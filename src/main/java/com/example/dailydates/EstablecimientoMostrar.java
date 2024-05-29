package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase EstablecimientoMostrar se utiliza para manejar la vista y las acciones relacionadas con la información de un establecimiento en la aplicación.
 */
public class EstablecimientoMostrar
{
    @javafx.fxml.FXML
    private Label categoriaLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Label anyadirCifLabel;
    @javafx.fxml.FXML
    private Pane imagenPane;
    @javafx.fxml.FXML
    private Button eliminarButton;
    @javafx.fxml.FXML
    private ImageView fotoImage;
    @javafx.fxml.FXML
    private Label horarioLabel;
    @javafx.fxml.FXML
    private Pane disenyoPane;
    @javafx.fxml.FXML
    private Label anyadirNombre;
    @javafx.fxml.FXML
    private Label direccionLabel;
    @javafx.fxml.FXML
    private Label ciudadLabel;
    @javafx.fxml.FXML
    private Label cifLabel;
    @javafx.fxml.FXML
    private Button guardarCambiosButton;
    @javafx.fxml.FXML
    private TextField direccionfield;
    @javafx.fxml.FXML
    private TextField horariofield;
    @javafx.fxml.FXML
    private TextField ciudadfield;
    @javafx.fxml.FXML
    private Label categoriaslabel;

    private Empresa empresa;
    @javafx.fxml.FXML
    private Button AnyadirCategoriasButton;

    /**
     * Obtiene la empresa actual.
     *
     * @return el objeto Empresa actual
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa actual.
     *
     * @param empresa el objeto Empresa a establecer
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Inicializa la vista con la información de la empresa proporcionada.
     *
     * @param emp el objeto Empresa para inicializar la vista
     */
    @Deprecated
    public void initialize(Empresa emp) {

       setEmpresa(emp);

            String imprimir = "";
             for (Categoria cat : this.empresa.getCategorias()){
                 imprimir += " " + cat.getNombre();
             }
             anyadirNombre.setText(emp.getNombre());

             categoriaslabel.setText(imprimir);

             anyadirCifLabel.setText(emp.getCIF());

             horariofield.setText(emp.getHorario());

             ciudadfield.setText(emp.getCiudad());

             direccionfield.setText(emp.getDireccion());

             fotoImage.setImage(emp.getFoto_empresa());
    }

    /**
     * Maneja el evento de clic del botón eliminar.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void eliminarButtonOnAction(ActionEvent actionEvent) {

        EmpresaModel empmod = new EmpresaModel();

        empmod.eliminar_empresa(empresa.getId_empresa());

    }

    /**
     * Maneja el evento de clic del botón guardar cambios.
     *
     * @param actionEvent el evento de acción
     */
    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {

        EmpresaModel empmod = new EmpresaModel();

        empresa.setHorario(horariofield.getText());
        empresa.setDireccion(direccionfield.getText());
        empresa.setCiudad(ciudadfield.getText());

        if (empmod.modificar_empresa(empresa)){
            // Código para manejar la actualización exitosa
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("datos no validos");
            a.showAndWait();
        }
    }
    /**
     * Maneja el evento de clic del botón añadir categorías.
     *
     * @param actionEvent el evento de acción
     */

    @javafx.fxml.FXML
    public void AnyadirCategoriasButtonOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AnyadirCategoria.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            AnyadirCategoria anyadirCategoria = fxmlLoader.getController();
            anyadirCategoria.initialize(empresa);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}