package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PaginaCitas
{
    @javafx.fxml.FXML
    private AnchorPane citasAnchorPane;
    @javafx.fxml.FXML
    private ScrollPane scrollpane;
    @javafx.fxml.FXML
    private Button prueba;
    @javafx.fxml.FXML
    private Label perfilLabel;

    @javafx.fxml.FXML
    public void initialize() {
        Pane p = new Pane();
        for (int i = 50;i < 5000;i+=50) {
            //Pane p2 = new Pane();
            Button l = new Button();
            l.setText("gonza");
            //l.setTranslateY(i);
            //p2.getChildren().add(l);
            //p2.setTranslateY(i);
            p.getChildren().add(l);
        }

        scrollpane.setContent(p);

    }

    @javafx.fxml.FXML
    public void pruebaclick(ActionEvent actionEvent) {

        /*Button b = new Button();
        b.setText("gonzalo");
        b.setOnAction(this::pruebaclick);
        VBox v = new VBox();
        v.getChildren().add(b);
        scrollpane.setContent(v);
         */



    }
}