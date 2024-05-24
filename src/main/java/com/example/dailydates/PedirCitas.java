package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PedirCitas
{
    @javafx.fxml.FXML
    private Label direccionLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Label horaLabel;
    @javafx.fxml.FXML
    private Label fechaLabel;
    @javafx.fxml.FXML
    private TextField nombreTextField;
    @javafx.fxml.FXML
    private Label nombreUsuarioLabel;
    @javafx.fxml.FXML
    private Spinner horaSpinner;
    @javafx.fxml.FXML
    private TextArea pedidoTextArea;
    @javafx.fxml.FXML
    private Pane citaPane;
    @javafx.fxml.FXML
    private DatePicker fechaDatePicker;
    @javafx.fxml.FXML
    private Label pedidoLabel;
    @javafx.fxml.FXML
    private Label pideCitaLabel;
    @javafx.fxml.FXML
    private Button guardarCambiosButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {
    }
}
