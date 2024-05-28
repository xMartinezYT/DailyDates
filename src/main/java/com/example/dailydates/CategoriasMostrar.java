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

public class CategoriasMostrar
{
    @javafx.fxml.FXML
    private Label anyadirHorario;
    @javafx.fxml.FXML
    private ImageView imagenEmpresa;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Pane disenyoPane;
    @javafx.fxml.FXML
    private Label anyadirCiudad;
    @javafx.fxml.FXML
    private Pane imagenPane;
    @javafx.fxml.FXML
    private Label anyadirNombre;
    @javafx.fxml.FXML
    private Label anyadirDireccion;
    @javafx.fxml.FXML
    private Button pedirCitaButton;

    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @javafx.fxml.FXML
    public void initialize(Empresa emp) {

        setEmpresa(emp);

        anyadirNombre.setText(empresa.getNombre());
        anyadirCiudad.setText(empresa.getCiudad());
        anyadirDireccion.setText(empresa.getDireccion());
        anyadirHorario.setText(empresa.getHorario());
        imagenEmpresa.setImage(empresa.getFoto_empresa());

    }

    @javafx.fxml.FXML
    public void pedirCitaButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PedirCitas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

