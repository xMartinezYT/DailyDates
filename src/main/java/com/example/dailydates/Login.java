package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
    public void accederButtonOnAction(ActionEvent actionEvent) {

        UsuarioModel um = new UsuarioModel();
        String email = emailTextField.getText();
        String password = contrasenyaField.getText();

        if (um.validar_usuario(email,password)) {
            AnchorPane pane = null;
            try {
                pane = FXMLLoader.load(getClass().getResource("PaginaPrincipalUsuario.fxml"));
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
}