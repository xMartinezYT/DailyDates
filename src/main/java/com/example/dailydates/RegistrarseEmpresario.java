package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class RegistrarseEmpresario {
    @javafx.fxml.FXML
    private Label introducirDatosLabel;
    @javafx.fxml.FXML
    private TextField nombreTextField;
    @javafx.fxml.FXML
    private TextField contraseñaTextField;
    @javafx.fxml.FXML
    private ImageView fotoImage;
    @javafx.fxml.FXML
    private Button atrasButton;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Button pruebaButton;
    @javafx.fxml.FXML
    private Pane imagenPane;
    @javafx.fxml.FXML
    private TextField telefonoTextField;
    @javafx.fxml.FXML
    private TextField apellidosTextField;
    @javafx.fxml.FXML
    private TextField gmailTextField;
    @javafx.fxml.FXML
    private Button crearButton;
    @javafx.fxml.FXML
    private Button cargarImagenButton;
    private File imagenSeleccionada;

    @javafx.fxml.FXML
    public void cargarImagenButtonOnAction(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen de perfil");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.png", "*.gif")
        );

        imagenSeleccionada = fileChooser.showOpenDialog(null);

        Image fotoperfil = new Image(imagenSeleccionada.toURI().toString());

        fotoImage.setImage(fotoperfil);

    }

    @javafx.fxml.FXML
    public void crearButtonOnAction(ActionEvent actionEvent) {
        EmpresarioModel em = new EmpresarioModel();

        int id;
        String nombre = nombreTextField.getText();
        String apellidos = apellidosTextField.getText();
        String gmail = gmailTextField.getText();
        String contrasenya = contraseñaTextField.getText();
        String telefono = telefonoTextField.getText();
        Image foto_perfil = fotoImage.getImage();


        Empresario e = new Empresario(1,nombre,apellidos,gmail,contrasenya,telefono,foto_perfil);

        if ((em.anyadir_empresario(e,imagenSeleccionada))){
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
                this.anchorPaneMain.getChildren().setAll(pane);
            } catch (IOException emp) {
                throw new RuntimeException(emp);
            }
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Datos no válidos");
            a.showAndWait();
        }

    }

    @javafx.fxml.FXML
    public void atrasButtonOnAction(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Registrarse.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void pruebaButtonOnAction(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaPrincipalEmpresario.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
