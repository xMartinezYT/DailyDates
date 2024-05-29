package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase Login maneja la funcionalidad del inicio de sesión en la aplicación.
 */
public class Login implements Initializable {

    @FXML
    private TextField emailTextField;
    @FXML
    private AnchorPane anchorPanePrincipal;
    @FXML
    private Button accederButton;
    @FXML
    private Button crearCuentaButton;
    @FXML
    private ImageView logoImage;
    @FXML
    private Button bienvenidoLabel;
    @FXML
    private AnchorPane AnchorPaneDegradado;
    @FXML
    private TextField mostrarContrasenyaField;
    @FXML
    private PasswordField contrasenyaField;
    @FXML
    private CheckBox verContraseña;
    @FXML
    private ImageView pepe;

    /**
     * Maneja el evento de clic del botón "Acceder". Realiza la validación de las credenciales de usuario o empresario y
     * muestra la página correspondiente.
     *
     * @param actionEvent el evento de acción generado por el clic del botón.
     */
    @FXML
    public void accederButtonOnAction(ActionEvent actionEvent) {

        UsuarioModel um = new UsuarioModel();
        EmpresarioModel em = new EmpresarioModel();
        String email = emailTextField.getText();
        String password = contrasenyaField.getText();

        // Validación de usuario
        if (um.validar_usuario(email, password)) {
            enviarDatos(actionEvent);
            try {
                anchorPanePrincipal.setBackground(null);
                AnchorPane pane = null;
                pane = FXMLLoader.load(getClass().getResource("PaginaPerfil.fxml"));
                this.anchorPanePrincipal.getChildren().setAll(pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // Validación de empresario
        } else if (em.validar_empresario(email,password)){
            enviarDatosEmp(actionEvent);
            try {
                anchorPanePrincipal.setBackground(null);
                AnchorPane pane = null;
                pane = FXMLLoader.load(getClass().getResource("PaginaPrincipalEmpresario.fxml"));
                this.anchorPanePrincipal.getChildren().setAll(pane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // Credenciales incorrectas
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Datos incorrectos");
            a.showAndWait();
        }
    }

    /**
     * Envía los datos del empresario a la página principal del empresario y configura la escena correspondiente.
     *
     * @param event el evento de acción que desencadenó el método.
     */
    private void enviarDatosEmp(ActionEvent event) {
        EmpresarioModel em = new EmpresarioModel();
        Empresario emp = em.buscar_empresario(emailTextField.getText());
        anchorPanePrincipal.setBackground(null);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            // Paso 1: Obtener la instancia del titular del empresario
            EmpresarioHolder holder = EmpresarioHolder.getInstance();
            // Paso 2: Establecer el empresario en el titular
            holder.setEmpresario(emp);
            // Crear la raíz de la interfaz gráfica
            Parent root = FXMLLoader.load(getClass().getResource("PaginaPrincipalEmpresario.fxml"));
            // Configurar la escena
            Scene scene = new Scene(root);
            // Configurar el título de la ventana
            stage.setTitle("Tutorial JavaFX");
            // Establecer la escena en la ventana
            stage.setScene(scene);
            // Mostrar la ventana
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }

    }

    /**
     * Maneja el evento de clic del botón "Crear Cuenta". Navega a la página de registro.
     * @param actionEvent el evento de acción.
     */
    @FXML
    public void crearCuentaButtonOnAction(ActionEvent actionEvent) {
        anchorPanePrincipal.setBackground(null);
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("Registrarse.fxml"));
            this.anchorPanePrincipal.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja la acción de mostrar u ocultar la contraseña según el estado del CheckBox "verContraseña".
     *
     * @param actionEvent el evento de acción que desencadenó el método.
     */
    @FXML
    public void verContraseñaOnAction(ActionEvent actionEvent) {

        if (verContraseña.isSelected()) {
            // Si el CheckBox está seleccionado, muestra el campo de texto de contraseña visible y oculta el campo de contraseña.
            mostrarContrasenyaField.setText(contrasenyaField.getText());
            mostrarContrasenyaField.setVisible(true);
            contrasenyaField.setVisible(false);

        } else {
            // Si el CheckBox no está seleccionado, muestra el campo de contraseña visible y oculta el campo de texto de contraseña.
            mostrarContrasenyaField.setText(contrasenyaField.getText());
            mostrarContrasenyaField.setVisible(false);
            contrasenyaField.setVisible(true);
        }
    }

    /**
     * Envía los datos del usuario a la siguiente página de la interfaz después de validar y cerrar la ventana actual.
     *
     * @param event el evento que desencadenó la acción.
     */
    @Deprecated
    private void enviarDatos(ActionEvent event) {

        // Configuración visual
        anchorPanePrincipal.setBackground(null);
        // Obtención del modelo de usuario y búsqueda del usuario
        UsuarioModel um = new UsuarioModel();
        Usuario us = um.buscar_usuario(emailTextField.getText());

        // Cierre de la ventana actual
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        try {
            // Paso 1: Creación e inicialización del contenedor de datos de usuario
            UsuarioHolder holder = UsuarioHolder.getInstance();
            // Paso 2: Configuración del usuario en el contenedor
            holder.setUsuario(us);
            // Carga de la página principal del usuario
           Parent root = FXMLLoader.load(getClass().getResource("PaginaPrincipalUsuario.fxml"));
            Scene scene = new Scene(root);

            // Configuración de la nueva escena y su visualización
            stage.setTitle("Tutorial JavaFX");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // Manejo de excepciones en caso de error al cargar la nueva ventana
            System.err.println(String.format("Error creando ventana: %s", e.getMessage()));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image fondo = new Image("file:src/main/resources/com/example/dailydates/img/pexels-mdsnmdsnmdsn-1831234.jpg");

        // Crear un objeto ImageView para aplicar los ajustes de color
        ImageView imageView = new ImageView(fondo);


        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.6); // Ajusta este valor según la opacidad deseada (0.0 - 1.0)

        // Aplicar el ColorAdjust al ImageView
        imageView.setEffect(colorAdjust);

        // Crear un Snapshot de ImageView con el efecto de opacidad
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT); // Fondo transparente para el snapshot
        WritableImage writableImage = imageView.snapshot(params, null);
        Image adjustedImage = new ImageView(writableImage).getImage();

        // Configurar el fondo con la imagen ajustada
        BackgroundSize backgroundSize = new BackgroundSize(1920, 1080, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(adjustedImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                backgroundSize);

        Background background = new Background(backgroundImage);

        AnchorPaneDegradado.setBackground(background);

    }
}