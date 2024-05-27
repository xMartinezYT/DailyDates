package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Establecimientos
{
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private GridPane gridPane;
    @javafx.fxml.FXML
    private Label calendarioLabel;
    @javafx.fxml.FXML
    private ScrollPane scrollPane;
    @javafx.fxml.FXML
    private Button anyadirEmpresaButton;

    @javafx.fxml.FXML
    public void initialize() {
        EmpresaModel empmo = new EmpresaModel();
        EmpresarioHolder empH = EmpresarioHolder.getInstance();
        int col = 1;
        try {
            for (Empresa emp : empmo.listar_empresas_empresario(empH.getEmpresario().getId())) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("EstablecimientoMostrar.fxml"));
                AnchorPane anchor = fxmlLoader.load();
                EstablecimientoMostrar establecimiento = fxmlLoader.getController();
                establecimiento.setEmpresa(emp);
                gridPane.add(anchor,1,col);
                col++;
                GridPane.setMargin(anchor,new Insets(2));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void anyadirEmpresaButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FormularioEmpresa.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}