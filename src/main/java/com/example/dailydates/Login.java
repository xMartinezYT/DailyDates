package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Login {

    @FXML
    private TextField emailTextField;
    @FXML
    private AnchorPane anchorPanePrincipal;
    @FXML
    private TextField contraseñaTextField;
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
    public void accederButtonOnAction(ActionEvent actionEvent) {

        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("PaginaPrincipalUsuario.fxml"));
            this.anchorPanePrincipal.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
}