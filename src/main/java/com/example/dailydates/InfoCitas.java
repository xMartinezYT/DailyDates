package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class InfoCitas
{

    @javafx.fxml.FXML
    private Label anyadirCiudadLabel;
    @javafx.fxml.FXML
    private Label direccionLabel;
    @javafx.fxml.FXML
    private Label anyadirDireccionLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private Label ciudadLabel;
    @javafx.fxml.FXML
    private ImageView imagenPerfil;
    @javafx.fxml.FXML
    private Label anyadirNombreLabel;
    @javafx.fxml.FXML
    private Button modificarButton;
    @javafx.fxml.FXML
    private Label anyadirPedidoLabel;
    @javafx.fxml.FXML
    private Label anyadirFechaLabel;
    @javafx.fxml.FXML
    private Label anyadirHoraLabel;
    @javafx.fxml.FXML
    private Label pedidoLabel;
    @javafx.fxml.FXML
    private Button eliminarButton;

    private Citas citas;

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }

    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Deprecated
    public void initialize(Citas c) {
        EmpresaModel empmod = new EmpresaModel();

        setCitas(c);
        setEmpresa(empmod.buscar_empresa(c.getId_empresa()));


        anyadirFechaLabel.setText(citas.getFecha().toString());
        anyadirHoraLabel.setText(citas.getHora().toString());
        anyadirCiudadLabel.setText(empresa.getCiudad());
        anyadirDireccionLabel.setText(empresa.getDireccion());
        anyadirNombreLabel.setText(empresa.getNombre());
        anyadirPedidoLabel.setText(citas.getPedido());
    }

    @javafx.fxml.FXML
    public void modificarButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("ModificarCitas.fxml"));
            this.anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void eliminarButtonOnAction(ActionEvent actionEvent) {
    }
}