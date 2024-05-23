package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PaginaPerfil
{
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private Button fotoButton;
    @javafx.fxml.FXML
    private ImageView perfilImage;
    @javafx.fxml.FXML
    private Label perfilLabel;
    @javafx.fxml.FXML
    private Label apellidosLabel;
    @javafx.fxml.FXML
    private Label nombreLabel;
    @javafx.fxml.FXML
    private Label telefonoLabel;
    @javafx.fxml.FXML
    private TextField nombreTextField;
    @javafx.fxml.FXML
    private Label datosPersonalesLabel;
    @javafx.fxml.FXML
    private TextField nombreUsuarioTextField;
    @javafx.fxml.FXML
    private TextField correoTextField;
    @javafx.fxml.FXML
    private Label correoLabel;
    @javafx.fxml.FXML
    private TextField telefonoTextField;
    @javafx.fxml.FXML
    private AnchorPane perfilAnchorPane;
    @javafx.fxml.FXML
    private TextField apellidosTextField;
    @javafx.fxml.FXML
    private Label negocio3Label;
    @javafx.fxml.FXML
    private Label negocio1Label;
    @javafx.fxml.FXML
    private Label negociosRecientesLabel;
    @javafx.fxml.FXML
    private Label negocio2Label;
    @javafx.fxml.FXML
    private ImageView negocio1Image;
    @javafx.fxml.FXML
    private ImageView negocio3Image;
    @javafx.fxml.FXML
    private Pane fotoPane1;
    @javafx.fxml.FXML
    private ImageView editarImage;
    @javafx.fxml.FXML
    private Pane fotoPane12;
    @javafx.fxml.FXML
    private Pane fotoPane11;
    @javafx.fxml.FXML
    private ImageView negocio2Image;
    @javafx.fxml.FXML
    private Label correoLabel1;
    @javafx.fxml.FXML
    private TextField correoTextField1;

    @javafx.fxml.FXML
    public void initialize() {

        nombreTextField.setText("Pepe");
    }

    @Deprecated
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {
    }
}