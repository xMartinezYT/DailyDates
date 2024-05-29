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

    /*
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            Image fondo = new Image("file:src/main/resources/com/example/dailydates/img/cfb37e7eebaf13f140d53a98ffd68214.png");

            // Crear un objeto ImageView para aplicar los ajustes de color
            ImageView imageView = new ImageView(fondo);


            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(-0.4); // Ajusta este valor según la opacidad deseada (0.0 - 1.0)

            // Aplicar el ColorAdjust al ImageView
            imageView.setEffect(colorAdjust);

            // Crear un Snapshot de ImageView con el efecto de opacidad
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT); // Fondo transparente para el snapshot
            WritableImage writableImage = imageView.snapshot(params, null);
            Image adjustedImage = new ImageView(writableImage).getImage();

            // Configurar el fondo con la imagen ajustada
            BackgroundSize backgroundSize = new BackgroundSize(800, 600, false, false, true, false);
            BackgroundImage backgroundImage = new BackgroundImage(adjustedImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    backgroundSize);

            Background background = new Background(backgroundImage);

            anchorPaneMain.setBackground(background);
            anchorPaneMain.setPadding(new Insets(20));
        }
    */

    /**
     * Maneja el evento del botón "Crear Cuenta".
     * Crea una nueva cuenta de usuario con los datos proporcionados por el usuario.
     * @param actionEvent Evento de acción del botón "Crear Cuenta".
     */
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

    /**
     * Maneja el evento del botón "Cargar Imagen".
     * Permite al usuario seleccionar una imagen de perfil.
     * @param actionEvent Evento de acción del botón "Cargar Imagen".
     */
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

    /**
     * Maneja el evento del botón "Atrás".
     * Regresa a la ventana de selección de tipo de registro.
     * @param actionEvent Evento de acción del botón "Atrás".
     */
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