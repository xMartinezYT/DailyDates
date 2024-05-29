package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarseUsuario
{
    @javafx.fxml.FXML
    private Label registroDeSesion;
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
    private Pane fotoPane;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Button cargarButton;
    @javafx.fxml.FXML
    private ImageView imagenPerfil;
    @javafx.fxml.FXML
    private Button atrasButton;

    private File imagenSeleccionada;
    @javafx.fxml.FXML
    private Label nombreUsuarioLabel21;
    @javafx.fxml.FXML
    private Label nombreUsuarioLabel2;
    @javafx.fxml.FXML
    private Label nombreUsuarioLabel211;
    @javafx.fxml.FXML
    private Label nombreUsuarioLabel1;
    @javafx.fxml.FXML
    private Label nombreUsuarioLabel2111;

    @javafx.fxml.FXML
    public void crearCuentaButtonOnAction(ActionEvent actionEvent) {


        UsuarioModel um = new UsuarioModel();

         int id;
         String nombre = nombreTextField.getText();
         String apellidos = apellidosTextField.getText();
         String gmail = gmailTextField.getText();
         String contrasenya = contraseñaTextField.getText();
         String telefono = telefonoTextField.getText();
         Image foto_perfil = imagenPerfil.getImage();


        Usuario u = new Usuario(1,nombre,apellidos,gmail,contrasenya,telefono,foto_perfil);

        if (um.anyadir_usuario(u,imagenSeleccionada)){
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
                this.anchorPaneMain.getChildren().setAll(pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Datos no válidos");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void cargarButtonOnAction(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen de perfil");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.png", "*.gif")
        );

        imagenSeleccionada = fileChooser.showOpenDialog(null);

        Image fotoperfil = new Image(imagenSeleccionada.toURI().toString());

        imagenPerfil.setImage(fotoperfil);

    }

    @javafx.fxml.FXML
    public void atrasButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Registrarse.fxml"));
            anchorPaneMain.setBackground(null);
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}