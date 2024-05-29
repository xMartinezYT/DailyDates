package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador para la página de perfil de usuario.
 * Esta página permite a los usuarios ver y editar su perfil.
 */
public class PaginaPerfil
{
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private ImageView perfilImage;
    @javafx.fxml.FXML
    private Label perfilLabel;
    @javafx.fxml.FXML
    private Label apellidosLabel;
    @javafx.fxml.FXML
    private Label nombreLabel;
    @javafx.fxml.FXML
    private Label telefonoLabel;
    @javafx.fxml.FXML
    private TextField nombreTextField;
    @javafx.fxml.FXML
    private TextField nombreUsuarioTextField;
    @javafx.fxml.FXML
    private TextField correoTextField;
    @javafx.fxml.FXML
    private Label correoLabel;
    @javafx.fxml.FXML
    private TextField telefonoTextField;
    @javafx.fxml.FXML
    private AnchorPane perfilAnchorPane;
    @javafx.fxml.FXML
    private TextField apellidosTextField;
    @javafx.fxml.FXML
    private Button guardarCambiosButton;
    @javafx.fxml.FXML
    private Button cerrarSesionButton;

    private Usuario u = new Usuario();
    @javafx.fxml.FXML
    private Label registroDeSesion;

    /**
     * Inicializa la página de perfil.
     * Llama al método anyadirdatos() para mostrar los datos del usuario actual.
     */
    @javafx.fxml.FXML
    public void initialize() {
      anyadirdatos();
    }

    /**
     * Maneja el evento del botón para guardar los cambios en el perfil.
     * @param actionEvent Evento de acción del botón.
     */

    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {

    }

    /**
     * Maneja el evento del botón para cerrar la sesión del usuario.
     * @param actionEvent Evento de acción del botón.
     */
    @javafx.fxml.FXML
    public void cerrarSesionButtonOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent ne = loader.load();
            Stage st = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene news = new Scene(ne);
            st.setScene(news);
            st.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Carga los datos del usuario actual en los campos de la página de perfil.
     */
    public void anyadirdatos(){

        UsuarioHolder holder = UsuarioHolder.getInstance();
        u = holder.getUsuario();

        perfilImage.setImage(u.getFoto_perfil());
        nombreUsuarioTextField.setText(u.getNombre());
        nombreTextField.setText(u.getNombre());
        correoTextField.setText(u.getGmail());
        apellidosTextField.setText(u.getApellidos());
        telefonoTextField.setText(u.getTelefono());

    }

    /**
     * [DEPRECATED] Maneja el evento del botón para cargar una imagen de perfil.
     * @param actionEvent Evento de acción del botón.
     * @deprecated Este método está marcado como obsoleto y no se debe utilizar.
     */
    @Deprecated
    public void cargarImagenButtonOnAction(ActionEvent actionEvent) {
    }
}

