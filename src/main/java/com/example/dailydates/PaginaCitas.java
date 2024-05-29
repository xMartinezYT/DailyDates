package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controlador para la página de citas.
 */
public class PaginaCitas
{
    @javafx.fxml.FXML
    private AnchorPane citasAnchorPane;
    @javafx.fxml.FXML
    private Label perfilLabel;
    @javafx.fxml.FXML
    private ScrollPane scrollPane;
    @javafx.fxml.FXML
    private GridPane gridPane;

    /**
     * Inicializa la página de citas.
     * Carga las citas del usuario actual y las muestra en el gridPane.
     */
    @javafx.fxml.FXML
    public void initialize() {
            CitasModel citmod = new CitasModel();
            UsuarioHolder usuarioHolder = UsuarioHolder.getInstance();
            int col = 1;
        try {
            for (Citas c : citmod.listar_citas_usuario(usuarioHolder.getUsuario().getId())) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("citasmostrar.fxml"));
                AnchorPane anchor = fxmlLoader.load();
                Citasmostrar cita = fxmlLoader.getController();
                cita.initialize(c);
                gridPane.add(anchor,1,col);
                col++;
                GridPane.setMargin(anchor,new Insets(2));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

