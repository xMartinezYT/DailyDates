package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Login {

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
                AnchorPane pane = null;
                pane = FXMLLoader.load(getClass().getResource("PaginaPerfil.fxml"));
                this.anchorPanePrincipal.getChildren().setAll(pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (em.validar_empresario(email,password)){
           // enviarDatos(actionEvent);
            try {
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

    @FXML
    public void crearCuentaButtonOnAction(ActionEvent actionEvent) {

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
}