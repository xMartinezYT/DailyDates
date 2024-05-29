package com.example.dailydates;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * La clase EditarEmpresa se utiliza para manejar la edición de información de una empresa en la aplicación.
 */
public class EditarEmpresa
{

    // Componentes de la interfaz gráfica
    @javafx.fxml.FXML
    private TextField CifEmpresaNueva;  /**
 * Campo de texto para el CIF de la nueva empresa.
 */
    @javafx.fxml.FXML
    private TextField CiudadEmpresaNueva;   /**
 * Campo de texto para la ciudad de la nueva empresa.
 */
    @javafx.fxml.FXML
    private TextField DireccionEmpresaNueva;    /**
 * Campo de texto para la dirección de la nueva empresa.
 */
    @javafx.fxml.FXML
    private TextField NombreEmpresaNueva;   /**
 * Campo de texto para el nombre de la nueva empresa.
 */
    @javafx.fxml.FXML
    private ChoiceBox CierreEmpresa;    /**
 * ChoiceBox para seleccionar la hora de cierre de la empresa.
 */
    @javafx.fxml.FXML
    private ImageView AñadeFoto;    /**
 * ImageView para añadir una foto de la empresa.
 */
    @javafx.fxml.FXML
    private ChoiceBox AperturaEmpresa;  /**
 * ChoiceBox para seleccionar la hora de apertura de la empresa.
 */

    /**
     * Inicializa la interfaz de edición de empresa.
     * Este método se llama automáticamente después de que se haya cargado el archivo FXML correspondiente.
     */
    @javafx.fxml.FXML
    public void initialize() {
        // Puede añadirse código aquí para realizar inicializaciones adicionales de la interfaz si es necesario
    }}