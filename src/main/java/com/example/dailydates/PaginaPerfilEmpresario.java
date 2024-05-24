package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PaginaPerfilEmpresario
{
    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Label perfilLabel;
    @javafx.fxml.FXML
    private Label apellidosLabel;
    @javafx.fxml.FXML
    private ImageView editarImage;
    @javafx.fxml.FXML
    private Button fotoButton;
    @javafx.fxml.FXML
    private Label nombreLabel;
    @javafx.fxml.FXML
    private Label telefonoLabel;
    @javafx.fxml.FXML
    private ImageView perfilImage;
    @javafx.fxml.FXML
    private TextField nombreTextField;
    @javafx.fxml.FXML
    private Label datosPersonalesLabel;
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private Label CifLabel;
    @javafx.fxml.FXML
    private TextField nombreUsuarioTextField;
    @javafx.fxml.FXML
    private TextField correoTextField;
    @javafx.fxml.FXML
    private Label correoLabel;
    @javafx.fxml.FXML
    private TextField telefonoTextField;
    @javafx.fxml.FXML
    private TextField apellidosTextField;
    @javafx.fxml.FXML
    private Button cerrarSesionButton;
    @javafx.fxml.FXML
    private Label cifLabel;
    @javafx.fxml.FXML
    private Button guardarCambiosButton;

    @javafx.fxml.FXML
    public void initialize() {

    }
    @javafx.fxml.FXML
    public void cerrarSesionButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {
    }
}