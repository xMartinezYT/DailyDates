package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class InfoCitas
{

    @javafx.fxml.FXML
    private Label anyadirCiudadLabel;
    @javafx.fxml.FXML
    private Label direccionLabel;
    @javafx.fxml.FXML
    private Label anyadirDireccionLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private Label ciudadLabel;
    @javafx.fxml.FXML
    private ImageView imagenPerfil;
    @javafx.fxml.FXML
    private Label anyadirNombreLabel;
    @javafx.fxml.FXML
    private Button modificarButton;
    @javafx.fxml.FXML
    private Label anyadirPedidoLabel;
    @javafx.fxml.FXML
    private Label anyadirFechaLabel;
    @javafx.fxml.FXML
    private Label anyadirHoraLabel;
    @javafx.fxml.FXML
    private Label pedidoLabel;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void modificarButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ModificarCitas.fxml"));
            this.anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}