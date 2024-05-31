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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/**
 * Controlador para la página de perfil de un empresario.
 * Esta página permite a los empresarios ver y editar su perfil.
 */
public class PaginaPerfilEmpresario
{
    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Label perfilLabel;
    @javafx.fxml.FXML
    private Label apellidosLabel;
    @javafx.fxml.FXML
    private Label nombreLabel;
    @javafx.fxml.FXML
    private Label telefonoLabel;
    @javafx.fxml.FXML
    private ImageView perfilImage;
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private TextField nombreUsuarioTextField;
    @javafx.fxml.FXML
    private TextField correoTextField;
    @javafx.fxml.FXML
    private Label correoLabel;
    @javafx.fxml.FXML
    private TextField telefonoTextField;
    @javafx.fxml.FXML
    private TextField apellidosTextField;
    @javafx.fxml.FXML
    private Button cerrarSesionButton;
    @javafx.fxml.FXML
    private Button guardarCambiosButton;
    private Empresario emp = new Empresario();
    private File imagenSeleccionada;
    @javafx.fxml.FXML
    private Label registroDeSesion;
    @javafx.fxml.FXML
    private AnchorPane perfilAnchorPane;
    @javafx.fxml.FXML
    private TextField nombreTextField;

    /**
     * Inicializa la página de perfil del empresario.
     * Llama al método anyadirdatos() para mostrar los datos del empresario actual.
     */
    @javafx.fxml.FXML
    public void initialize() {

     anyadirdatos();

    }
    /**
     * Maneja el evento del botón para cerrar la sesión del empresario.
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
     * Maneja el evento del botón para guardar los cambios en el perfil del empresario.
     * Obtiene los datos ingresados por el usuario y actualiza el perfil del empresario en la base de datos.
     * Además, actualiza el objeto Empresario en el holder.
     * @param actionEvent Evento de acción del botón.
     */
    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {

        EmpresarioModel empmod = new EmpresarioModel();


        int id;
        String nombre = nombreTextField.getText();
        String apellidos = apellidosTextField.getText();
        String gmail = correoTextField.getText();
        String contrasenya = emp.getContrasenya();
        String telefono = telefonoTextField.getText();
        Image foto_perfil = perfilImage.getImage();

        Empresario e = new Empresario(emp.getId(),nombre,apellidos,gmail,contrasenya,telefono,foto_perfil);



        if (empmod.modificar_empresario(e)){
            EmpresarioHolder holder = EmpresarioHolder.getInstance();
            holder.setEmpresario(e);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Modificado correctamente");
            a.showAndWait();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error al modificar perfil");
            a.showAndWait();
        }

    }

    /**
     * Carga los datos del empresario actual en los campos de la página de perfil.
     */
    public void anyadirdatos(){

        EmpresarioHolder holder = EmpresarioHolder.getInstance();
        emp = holder.getEmpresario();

        perfilImage.setImage(emp.getFoto_perfil());
        nombreUsuarioTextField.setText(emp.getNombre());
        nombreTextField.setText(emp.getNombre());
        correoTextField.setText(emp.getGmail());
        apellidosTextField.setText(emp.getApellidos());
        telefonoTextField.setText(emp.getTelefono());

    }

}