package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class PaginaCitas
{
    @javafx.fxml.FXML
    private AnchorPane citasAnchorPane;
    @javafx.fxml.FXML
    private Label perfilLabel;
    @javafx.fxml.FXML
    private ScrollPane scrollPane;
    @javafx.fxml.FXML
    private GridPane gridPane;

    @javafx.fxml.FXML
    public void initialize() {


        try {


            for (int i = 0; i < 40; i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("citasmostrar.fxml"));
                AnchorPane anchor = fxmlLoader.load();
                Citasmostrar cita = fxmlLoader.getController();
                gridPane.add(anchor,1,i);
                GridPane.setMargin(anchor,new Insets(2));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}