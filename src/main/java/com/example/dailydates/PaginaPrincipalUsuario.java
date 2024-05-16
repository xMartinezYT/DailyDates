package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PaginaPrincipalUsuario
{
    @javafx.fxml.FXML
    private Label centroDeSaludLabel;
    @javafx.fxml.FXML
    private Pane fruteriaPane;
    @javafx.fxml.FXML
    private Pane centroDeSaludPane;
    @javafx.fxml.FXML
    private Label categoriaLabel;
    @javafx.fxml.FXML
    private ImageView fruteriaImage;
    @javafx.fxml.FXML
    private Pane restaurantesPane;
    @javafx.fxml.FXML
    private Label restaurantesLabel;
    @javafx.fxml.FXML
    private Label fruteriasLabel;
    @javafx.fxml.FXML
    private ImageView centroDeSaludImage;
    @javafx.fxml.FXML
    private ImageView restaurantesImage;
    @javafx.fxml.FXML
    private Button fruteriaButton;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Pane menuPane;
    @javafx.fxml.FXML
    private Button categoriaButton;
    @javafx.fxml.FXML
    private Button citasButton;
    @javafx.fxml.FXML
    private Label perfilMenuLabel;
    @javafx.fxml.FXML
    private Button perfilButton;
    @javafx.fxml.FXML
    private AnchorPane anchorPaneUsuario;
    @javafx.fxml.FXML
    private Label citasMenuLabel;
    @javafx.fxml.FXML
    private Label categoriaMenuLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void centroDeSaludButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("RegistrarseEmpresario.fxml"));
            this.anchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public void fruteriaButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void categoriaButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void citasButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void perfilButtonOnAction(ActionEvent actionEvent) {
    }
}