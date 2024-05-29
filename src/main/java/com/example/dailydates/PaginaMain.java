package com.example.dailydates;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Controlador para la página principal.
 * Esta página inicializa el formulario de inicio de sesión (Login.fxml).
 */
public class PaginaMain implements Initializable
{


    @javafx.fxml.FXML
    private AnchorPane AnchorPaneMain;

    /**
     * Inicializa la página principal cargando el formulario de inicio de sesión (Login.fxml).
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
            this.AnchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}