package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
 */
public class PaginaPerfil
{
    // Elementos de la interfaz de usuario definidos en el archivo FXML

    /**
     * Panel para la foto de perfil.
     */
    @javafx.fxml.FXML
    private Pane fotoPane;

    /**
     * Imagen de perfil.
     */
    @javafx.fxml.FXML
    private ImageView perfilImage;

    /**
     * Imagen de perfil.
     */
    @javafx.fxml.FXML
    private Label perfilLabel;

    /**
     * Etiqueta para los apellidos del usuario.
     */
    @javafx.fxml.FXML
    private Label apellidosLabel;

    /**
     * Etiqueta para el nombre de usuario.
     */
    @javafx.fxml.FXML
    private Label nombreLabel;

    /**
     * Etiqueta para el teléfono del usuario.
     */
    @javafx.fxml.FXML
    private Label telefonoLabel;

    /**
     * Campo de texto para el nombre del usuario.
     */
    @javafx.fxml.FXML
    private TextField nombreTextField;

    /**
     * Campo de texto para el nombre de usuario.
     */
    @javafx.fxml.FXML
    private TextField nombreUsuarioTextField;

    /**
     * Campo de texto para el correo electrónico del usuario.
     */
    @javafx.fxml.FXML
    private TextField correoTextField;

    /**
     * Etiqueta para el correo electrónico del usuario.
     */
    @javafx.fxml.FXML
    private Label correoLabel;

    /**
     * Campo de texto para el teléfono del usuario.
     */
    @javafx.fxml.FXML
    private TextField telefonoTextField;

    /**
     * Panel de anclaje para el perfil.
     */
    @javafx.fxml.FXML
    private AnchorPane perfilAnchorPane;

    /**
     * Campo de texto para los apellidos del usuario.
     */
    @javafx.fxml.FXML
    private TextField apellidosTextField;

    /**
     * Botón para guardar los cambios del perfil.
     */
    @javafx.fxml.FXML
    private Button guardarCambiosButton;

    /**
     * Botón para cerrar la sesión del usuario.
     */
    @javafx.fxml.FXML
    private Button cerrarSesionButton;
    private Usuario u = new Usuario();

    /**
     * Etiqueta para el registro de sesión del usuario.
     */
    @javafx.fxml.FXML
    private Label registroDeSesion;

    /**
     * Método de inicialización que se llama automáticamente al cargar la interfaz.
     */
    @javafx.fxml.FXML
    public void initialize() {
      anyadirdatos();
    }

    /**
     * Método que maneja el evento de clic en el botón para guardar los cambios del perfil.
     * @param actionEvent Evento de acción generado por el clic en el botón.
     */
    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {

        UsuarioModel usmod = new UsuarioModel();
        UsuarioHolder ushold = UsuarioHolder.getInstance();

        Usuario modus = new Usuario(u.getId(),nombreUsuarioTextField.getText(),apellidosTextField.getText(),correoTextField.getText(),u.getContrasenya(),telefonoTextField.getText(),perfilImage.getImage());

        if (usmod.mod_usuario(modus)){
            ushold.setUsuario(modus);
        }else{
         Alert a = new Alert(Alert.AlertType.ERROR);
         a.setContentText("Error al modificar perfil");
         a.showAndWait();
}
        perfilImage.setImage(u.getFoto_perfil());
        nombreUsuarioTextField.setText(u.getNombre());
        nombreTextField.setText(u.getNombre());
        correoTextField.setText(u.getGmail());
        apellidosTextField.setText(u.getApellidos());
        telefonoTextField.setText(u.getTelefono());
    }

    /**
     * Método que maneja el evento de clic en el botón para cerrar la sesión del usuario.
     * @param actionEvent Evento de acción generado por el clic en el botón.
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
     * Método para agregar los datos del usuario a la interfaz.
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

}