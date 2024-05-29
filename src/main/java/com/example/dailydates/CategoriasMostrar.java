package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Esta clase maneja la visualización de los detalles de una empresa dentro de una categoría específica.
 */

public class CategoriasMostrar
{
    @javafx.fxml.FXML
    private Label anyadirHorario;   // Etiqueta para mostrar el horario de la empresa
    @javafx.fxml.FXML
    private ImageView imagenEmpresa;    // Vista de imagen para mostrar la foto de la empresa
    @javafx.fxml.FXML
    private AnchorPane anchorPane;  // Panel principal de anclaje
    @javafx.fxml.FXML
    private Pane disenyoPane;   // Panel para el diseño
    @javafx.fxml.FXML
    private Label anyadirCiudad;    // Etiqueta para mostrar la ciudad de la empresa
    @javafx.fxml.FXML
    private Pane imagenPane;    // Panel para la imagen
    @javafx.fxml.FXML
    private Label anyadirNombre;    // Etiqueta para mostrar el nombre de la empresa
    @javafx.fxml.FXML
    private Label anyadirDireccion;     // Etiqueta para mostrar la dirección de la empresa
    @javafx.fxml.FXML
    private Button pedirCitaButton;     // Botón para solicitar una cita

    // Empresa que se está mostrando
    private Empresa empresa;

    /**
     * Obtiene la empresa que se está mostrando.
     *
     * @return la empresa actual
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa que se va a mostrar.
     *
     * @param empresa la nueva empresa a mostrar
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Inicializa el controlador con los detalles de la empresa.
     * Este método está marcado como obsoleto y no debería usarse en nuevas implementaciones.
     *
     * @param emp la empresa cuyos detalles se van a mostrar
     */
    @Deprecated
    public void initialize(Empresa emp) {

        // Establece la empresa
        setEmpresa(emp);

        // Muestra los detalles de la empresa en las etiquetas e imagen correspondiente
        anyadirNombre.setText(empresa.getNombre());
        anyadirCiudad.setText(empresa.getCiudad());
        anyadirDireccion.setText(empresa.getDireccion());
        anyadirHorario.setText(empresa.getHorario());
        imagenEmpresa.setImage(empresa.getFoto_empresa());

    }

    /**
     * Maneja el evento de acción cuando se hace clic en el botón "Pedir Cita".
     * Abre una nueva ventana para solicitar una cita y pasa la empresa a la nueva ventana.
     *
     * @param actionEvent el evento que se dispara al hacer clic en el botón "Pedir Cita"
     */
    @javafx.fxml.FXML
    public void pedirCitaButtonOnAction(ActionEvent actionEvent) {

        try {

            // Carga el diseño FXML para la ventana de solicitar citas y la muestra en una nueva ventana
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PedirCitas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            // Obtiene el controlador de la nueva ventana y pasa la empresa a la nueva ventana
            PedirCitas pedirCitas = fxmlLoader.getController();
            pedirCitas.initialize(empresa);

            // Configura y muestra la nueva escena
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            // Lanza una RuntimeException si ocurre una IOException
            throw new RuntimeException(e);
        }
    }
}

