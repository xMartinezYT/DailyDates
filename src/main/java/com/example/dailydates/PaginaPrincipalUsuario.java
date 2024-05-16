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
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Pane menuPane;
    @javafx.fxml.FXML
    private Button categoriaButton;
    @javafx.fxml.FXML
    private Button citasButton;
    @javafx.fxml.FXML
    private Button perfilButton;
    @javafx.fxml.FXML
    private AnchorPane contenedorAnchorPane;

    @javafx.fxml.FXML
    public void initialize() {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCategorias.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void categoriaButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCategorias.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @javafx.fxml.FXML
    public void citasButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCitas.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @javafx.fxml.FXML
    public void perfilButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void extraescolaresButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void otrosButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void pescaderiaButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void restauranteButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void carniceriaButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void pasteleriaButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void saludButtonOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void fruteriaButtonOnAction(ActionEvent actionEvent) {
    }
}