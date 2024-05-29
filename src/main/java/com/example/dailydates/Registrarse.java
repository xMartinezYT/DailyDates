package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Controlador para la ventana de registro, que permite a los usuarios elegir entre registrarse como usuario o como empresario.
 */
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

    /**
     * Inicializa la ventana de registro.
     */
    @javafx.fxml.FXML
    public void initialize() {
    }

    /**
     * Maneja el evento del botón "Registrarse como empresario".
     * Abre la ventana de registro para empresarios.
     * @param actionEvent Evento de acción del botón "Registrarse como empresario".
     */
    @javafx.fxml.FXML
    public void registrarseEmpresarioButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistrarseEmpresario.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento del botón "Registrarse como usuario".
     * Abre la ventana de registro para usuarios.
     * @param actionEvent Evento de acción del botón "Registrarse como usuario".
     */
    @javafx.fxml.FXML
    public void registrarseUsuarioButtonOnAction(ActionEvent actionEvent) {

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistrarseUsuario.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento del botón "Atrás".
     * Regresa a la ventana de inicio de sesión.
     * @param actionEvent Evento de acción del botón "Atrás".
     */
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