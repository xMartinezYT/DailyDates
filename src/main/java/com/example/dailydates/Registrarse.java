package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Registrarse
{
    @javafx.fxml.FXML
    private Label convierteteEnUsuarioLabel;
    @javafx.fxml.FXML
    private ImageView usuarioImage;
    @javafx.fxml.FXML
    private Label usuarioDescripcionLabel;
    @javafx.fxml.FXML
    private Button registrarseUsuarioButton;
    @javafx.fxml.FXML
    private Button registrarseEmpresarioButton;
    @javafx.fxml.FXML
    private ImageView empresariaImage;
    @javafx.fxml.FXML
    private Label empresarioDescripcionLabel;
    @javafx.fxml.FXML
    private Label convierteteEnEmpresarioLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Button atrasButton;
    @javafx.fxml.FXML
    private Pane disenyoPane;
    @javafx.fxml.FXML
    private Pane registrarseEmpresarioPane;
    @javafx.fxml.FXML
    private Pane registrarseUsuarioPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void registrarseEmpresarioButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistrarseEmpresario.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void registrarseUsuarioButtonOnAction(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistrarseUsuario.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void atrasButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}