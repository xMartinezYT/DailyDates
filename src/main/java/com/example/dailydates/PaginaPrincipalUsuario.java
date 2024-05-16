package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PaginaPrincipalUsuario
{
    @javafx.fxml.FXML
    private Button fruteriaButton;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Pane menuPane;
    @javafx.fxml.FXML
    private Button categoriaButton;
    @javafx.fxml.FXML
    private Button citasButton;
    @javafx.fxml.FXML
    private Label perfilMenuLabel;
    @javafx.fxml.FXML
    private Button perfilButton;
    @javafx.fxml.FXML
    private Label citasMenuLabel;
    @javafx.fxml.FXML
    private Label categoriaMenuLabel;
    @javafx.fxml.FXML
    private Button extraescolaresButton;
    @javafx.fxml.FXML
    private Button otrosButton;
    @javafx.fxml.FXML
    private ImageView otrosImage;
    @javafx.fxml.FXML
    private ImageView fruteriaImage;
    @javafx.fxml.FXML
    private Button pasteleriaButton;
    @javafx.fxml.FXML
    private ImageView saludImage;
    @javafx.fxml.FXML
    private ImageView restauranteImage;
    @javafx.fxml.FXML
    private Button saludButton;
    @javafx.fxml.FXML
    private ImageView extraescolarImage;
    @javafx.fxml.FXML
    private ImageView carniceriaImage;
    @javafx.fxml.FXML
    private Button restauranteButton;
    @javafx.fxml.FXML
    private Button carniceriaButton;
    @javafx.fxml.FXML
    private ImageView pasteleriaImage;
    @javafx.fxml.FXML
    private Button pescaderiaButton1;
    @javafx.fxml.FXML
    private ImageView pescaderiaImage;
    @javafx.fxml.FXML
    private AnchorPane categoriasAnchorPane;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void centroDeSaludButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistrarseEmpresario.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void fruteriaButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void categoriaButtonOnAction(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void citasButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void perfilButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void extraescolaresButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void otrosButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void pescaderiaButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void restauranteButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void carniceriaButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void pasteleriaButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saludButtonOnAction(ActionEvent actionEvent) {
    }
}