package com.example.dailydates;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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
    public void initialize() {

        try {
            for (int i = 1; i < 40; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CategoriasMostrar.fxml"));
                AnchorPane anchor = fxmlLoader.load();
                CategoriasMostrar categoriasMostrar = fxmlLoader.getController();
                gridPane.add(anchor,1,i);
                GridPane.setMargin(anchor,new Insets(2));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}