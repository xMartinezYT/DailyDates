package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private TextField emailTextField;
    @FXML
    private AnchorPane anchorPanePrincipal;
    @FXML
    private Button accederButton;
    @FXML
    private Button crearCuentaButton;
    @FXML
    private ImageView logoImage;
    @FXML
    private Button bienvenidoLabel;
    @FXML
    private AnchorPane AnchorPaneDegradado;
    @FXML
    private TextField mostrarContrasenyaField;
    @FXML
    private PasswordField contrasenyaField;
    @FXML
    private CheckBox verContraseña;
    @FXML
    private ImageView pepe;


    @FXML
    public void accederButtonOnAction(ActionEvent actionEvent) {

        UsuarioModel um = new UsuarioModel();
        EmpresarioModel em = new EmpresarioModel();
        String email = emailTextField.getText();
        String password = contrasenyaField.getText();

        if (um.validar_usuario(email, password)) {
            enviarDatos(actionEvent);
            try {
                anchorPanePrincipal.setBackground(null);
                AnchorPane pane = null;
                pane = FXMLLoader.load(getClass().getResource("PaginaPerfil.fxml"));
                this.anchorPanePrincipal.getChildren().setAll(pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (em.validar_empresario(email,password)){
            enviarDatosEmp(actionEvent);
            try {
                anchorPanePrincipal.setBackground(null);
                AnchorPane pane = null;
                pane = FXMLLoader.load(getClass().getResource("PaginaPrincipalEmpresario.fxml"));
                this.anchorPanePrincipal.getChildren().setAll(pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Datos incorrectos");
            a.showAndWait();
        }
    }

    private void enviarDatosEmp(ActionEvent event) {
        EmpresarioModel em = new EmpresarioModel();
        Empresario emp = em.buscar_empresario(emailTextField.getText());
        anchorPanePrincipal.setBackground(null);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            // Paso 1
            EmpresarioHolder holder = EmpresarioHolder.getInstance();
            // Paso 2
            holder.setEmpresario(emp);
            Parent root = FXMLLoader.load(getClass().getResource("PaginaPrincipalEmpresario.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Tutorial JavaFX");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }

    }

    @FXML
    public void crearCuentaButtonOnAction(ActionEvent actionEvent) {
        anchorPanePrincipal.setBackground(null);
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("Registrarse.fxml"));
            this.anchorPanePrincipal.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void verContraseñaOnAction(ActionEvent actionEvent) {

        if (verContraseña.isSelected()) {

            mostrarContrasenyaField.setText(contrasenyaField.getText());
            mostrarContrasenyaField.setVisible(true);
            contrasenyaField.setVisible(false);

        } else {
            mostrarContrasenyaField.setText(contrasenyaField.getText());
            mostrarContrasenyaField.setVisible(false);
            contrasenyaField.setVisible(true);
        }

    }
    @FXML
    private void enviarDatos(ActionEvent event) {
        anchorPanePrincipal.setBackground(null);
        UsuarioModel um = new UsuarioModel();
        Usuario us = um.buscar_usuario(emailTextField.getText());

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            // Paso 1
            UsuarioHolder holder = UsuarioHolder.getInstance();
            // Paso 2
            holder.setUsuario(us);
           Parent root = FXMLLoader.load(getClass().getResource("PaginaPrincipalUsuario.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Tutorial JavaFX");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image fondo = new Image("file:src/main/resources/com/example/dailydates/img/pexels-mdsnmdsnmdsn-1831234.jpg");

        // Crear un objeto ImageView para aplicar los ajustes de color
        ImageView imageView = new ImageView(fondo);


        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.6); // Ajusta este valor según la opacidad deseada (0.0 - 1.0)

        // Aplicar el ColorAdjust al ImageView
        imageView.setEffect(colorAdjust);

        // Crear un Snapshot de ImageView con el efecto de opacidad
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT); // Fondo transparente para el snapshot
        WritableImage writableImage = imageView.snapshot(params, null);
        Image adjustedImage = new ImageView(writableImage).getImage();

        // Configurar el fondo con la imagen ajustada
        BackgroundSize backgroundSize = new BackgroundSize(1920, 1080, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(adjustedImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                backgroundSize);

        Background background = new Background(backgroundImage);

        AnchorPaneDegradado.setBackground(background);

    }
}