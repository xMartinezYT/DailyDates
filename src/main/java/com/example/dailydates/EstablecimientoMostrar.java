package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @javafx.fxml.FXML
    public void initialize() {

             String imprimir = null;
             for (Categoria cat : empresa.getCategorias()){
                 imprimir += ", " + cat.getNombre();
             }
             categoriaslabel.setText(imprimir);
    }

    @javafx.fxml.FXML
    public void eliminarButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void modificarButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FormularioEmpresa.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {
    }
}