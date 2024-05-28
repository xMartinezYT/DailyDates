package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class BotonesCategorias
{
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private ScrollPane scrollPane;
    @javafx.fxml.FXML
    private Label anyadirCategoriaLabel;
    @javafx.fxml.FXML
    private GridPane gridPane;
    @javafx.fxml.FXML
    private Button atrasButton;

    @javafx.fxml.FXML
    public void initialize() {
         CategoriaHolder catHol = CategoriaHolder.getInstance();
         EmpresaModel empMod = new EmpresaModel();
         int col = 1;
        try {
            for (Empresa emp : empMod.listar_empresas_categoria(catHol.getCategoria().getId())) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CategoriasMostrar.fxml"));
                AnchorPane anchor = fxmlLoader.load();
                CategoriasMostrar categoriasMostrar = fxmlLoader.getController();
                categoriasMostrar.initialize(emp);
                gridPane.add(anchor,1,col);
                col++;
                GridPane.setMargin(anchor,new Insets(2));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void atrasButtonOnAction(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCategorias.fxml"));
            this.anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}