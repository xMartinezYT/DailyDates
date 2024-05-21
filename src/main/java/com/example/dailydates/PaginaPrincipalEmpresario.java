package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PaginaPrincipalEmpresario
{

    @javafx.fxml.FXML
    private Button perfilButton;
    @javafx.fxml.FXML
    private AnchorPane contenedorAnchorPane;
    @javafx.fxml.FXML
    private Pane menuPane;
    @javafx.fxml.FXML
    private Button establecimientosButton;
    @javafx.fxml.FXML
    private Button calendarioButton;
    @javafx.fxml.FXML
    private AnchorPane anchorpaneMainEmpresario;

    @javafx.fxml.FXML
    public void initialize() {

        try {
            establecimientosButton.setUnderline(false);
            calendarioButton.setUnderline(true);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCalendario.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void calendarioButtonOnAction(ActionEvent actionEvent) {

        try {
            establecimientosButton.setUnderline(false);
            calendarioButton.setUnderline(true);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCalendario.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void perfilButtonOnAction(ActionEvent actionEvent) {

        try {
            establecimientosButton.setUnderline(false);
            calendarioButton.setUnderline(false);
            perfilButton.setUnderline(true);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaPerfilEmpresario.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void establecimientosButtonOnAction(ActionEvent actionEvent) {
        try {
            establecimientosButton.setUnderline(true);
            calendarioButton.setUnderline(false);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("Establecimientos.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
    }
}}