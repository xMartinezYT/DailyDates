package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Citasmostrar
{
    @javafx.fxml.FXML
    private AnchorPane mainAnchorPane;
    @javafx.fxml.FXML
    private Label labelHora;
    @javafx.fxml.FXML
    private Label nombreNegocio;
    @javafx.fxml.FXML
    private Label labelFecha;
    @javafx.fxml.FXML
    private Button buttonInfo;

    private Citas citas;


    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    @javafx.fxml.FXML
    public void initialize(Citas c) {
        setCitas(c);

        labelFecha.setText(citas.getFecha().toString());
    }

    @javafx.fxml.FXML
    public void infoclick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InfoCitas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}