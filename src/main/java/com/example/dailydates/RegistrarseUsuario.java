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

public class RegistrarseUsuario
{
    @javafx.fxml.FXML
    private Label registroDeSesion;
    @javafx.fxml.FXML
    private Label apellidosLabel;
    @javafx.fxml.FXML
    private Label contraseñaLabel;
    @javafx.fxml.FXML
    private Label telefonoLabel;
    @javafx.fxml.FXML
    private TextField nombreTextField;
    @javafx.fxml.FXML
    private Label nombreUsuarioLabel;
    @javafx.fxml.FXML
    private TextField contraseñaTextField;
    @javafx.fxml.FXML
    private TextField telefonoTextField;
    @javafx.fxml.FXML
    private Button crearCuentaButton;
    @javafx.fxml.FXML
    private TextField apellidosTextField;
    @javafx.fxml.FXML
    private TextField gmailTextField;
    @javafx.fxml.FXML
    private Label gmailLabel;
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Button cargarButton;
    @javafx.fxml.FXML
    private ImageView imagenPerfil;
    @javafx.fxml.FXML
    private Button atrasButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void crearCuentaButtonOnAction(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void cargarButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void atrasButtonOnAction(ActionEvent actionEvent) {
    }
}