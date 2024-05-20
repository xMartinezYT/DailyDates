package com.example.dailydates;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaginaMain implements Initializable
{


    @javafx.fxml.FXML
    private AnchorPane AnchorPaneMain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource("Login.fxml"));
            this.AnchorPaneMain.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}