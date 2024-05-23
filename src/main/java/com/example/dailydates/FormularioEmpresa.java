package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class FormularioEmpresa
{
    @javafx.fxml.FXML
    private Label horarioLabel;
    @javafx.fxml.FXML
    private Label nombreLabel;
    @javafx.fxml.FXML
    private ChoiceBox categoriaChoiceBox;
    @javafx.fxml.FXML
    private Label direccionLabel;
    @javafx.fxml.FXML
    private Label categoriaLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private Label ciudadLabel;
    @javafx.fxml.FXML
    private Label cifLabel;
    @javafx.fxml.FXML
    private ImageView imagenPerfil;
    @javafx.fxml.FXML
    private TextField anyadirCiudad;
    @javafx.fxml.FXML
    private TextField anyadirNombre;
    @javafx.fxml.FXML
    private TextField anyadirDireccion;
    @javafx.fxml.FXML
    private TextField anyadirCif;
    @javafx.fxml.FXML
    private TextField anyadirHorario;
    @javafx.fxml.FXML
    private Button guardarButton;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void guardarButtonOnAction(ActionEvent actionEvent) {
    }
}