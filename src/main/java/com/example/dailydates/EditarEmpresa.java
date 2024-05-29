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
    private TextField CifEmpresaNueva;
    @javafx.fxml.FXML
    private TextField CiudadEmpresaNueva;
    @javafx.fxml.FXML
    private TextField DireccionEmpresaNueva;
    @javafx.fxml.FXML
    private TextField NombreEmpresaNueva;
    @javafx.fxml.FXML
    private ChoiceBox CierreEmpresa;
    @javafx.fxml.FXML
    private ImageView AñadeFoto;
    @javafx.fxml.FXML
    private ChoiceBox AperturaEmpresa;

    /**
     * Inicializa la interfaz de edición de empresa.
     */

    @javafx.fxml.FXML
    public void initialize() {
        // Puede añadirse código aquí para realizar inicializaciones adicionales de la interfaz si es necesario
    }}