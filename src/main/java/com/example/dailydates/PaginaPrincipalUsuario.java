package com.example.dailydates;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.IOException;

public class PaginaPrincipalUsuario {

    @javafx.fxml.FXML
    private AnchorPane anchorPaneMain;
    @javafx.fxml.FXML
    private Pane menuPane;
    @javafx.fxml.FXML
    private Button categoriaButton;
    @javafx.fxml.FXML
    private Button citasButton;
    @javafx.fxml.FXML
    private Button perfilButton;
    @javafx.fxml.FXML
    private AnchorPane contenedorAnchorPane;

    @javafx.fxml.FXML
    public void initialize() {


        // Animación de degradado del color del texto
        Timeline categoriaTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(categoriaButton.textFillProperty(), Color.WHITE)),
                new KeyFrame(Duration.seconds(1), new KeyValue(categoriaButton.textFillProperty(), Color.DEEPPINK))
        );
        categoriaTimeline.setAutoReverse(true); // Repetir la animación en reversa
        categoriaTimeline.setCycleCount(Animation.INDEFINITE); // Repetir la animación infinitamente
        // Evento al pasar el cursor sobre el botón
        categoriaButton.setOnMouseEntered(event -> {
            categoriaTimeline.play(); // Iniciar la animación
        });

        // Evento al sacar el cursor del botón
        categoriaButton.setOnMouseExited(event -> {
            categoriaTimeline.stop(); // Detener la animación
        });


        // Animación de degradado del color del texto
        Timeline citasTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(citasButton.textFillProperty(), Color.WHITE)),
                new KeyFrame(Duration.seconds(1), new KeyValue(citasButton.textFillProperty(), Color.DEEPPINK))
        );
        citasTimeline.setAutoReverse(true); // Repetir la animación en reversa
        citasTimeline.setCycleCount(Animation.INDEFINITE); // Repetir la animación infinitamente
        // Evento al pasar el cursor sobre el botón
        citasButton.setOnMouseEntered(event -> {
            citasTimeline.play(); // Iniciar la animación
        });

        // Evento al sacar el cursor del botón
        citasButton.setOnMouseExited(event -> {
            citasTimeline.stop(); // Detener la animación
        });



        // Animación de degradado del color del texto
        Timeline perfilTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(perfilButton.textFillProperty(), Color.PINK)),
                new KeyFrame(Duration.seconds(1), new KeyValue(perfilButton.textFillProperty(), Color. HOTPINK))
        );
        perfilTimeline.setAutoReverse(true); // Repetir la animación en reversa
        perfilTimeline.setCycleCount(Animation.INDEFINITE); // Repetir la animación infinitamente
        // Evento al pasar el cursor sobre el botón
        perfilButton.setOnMouseEntered(event -> {
            perfilTimeline.play(); // Iniciar la animación
        });

        // Evento al sacar el cursor del botón
        perfilButton.setOnMouseExited(event -> {
            perfilTimeline.stop(); // Detener la animación
        });





               try {
            categoriaButton.setUnderline(true);
            citasButton.setUnderline(false);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCategorias.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void categoriaButtonOnAction(ActionEvent actionEvent) {


        try {
            categoriaButton.setUnderline(true);
            citasButton.setUnderline(false);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCategorias.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @javafx.fxml.FXML
    public void citasButtonOnAction(ActionEvent actionEvent) {

        try {
            citasButton.setUnderline(true);
            categoriaButton.setUnderline(false);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCitas.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @javafx.fxml.FXML
    public void perfilButtonOnAction(ActionEvent actionEvent) {
        try {
            citasButton.setUnderline(false);
            categoriaButton.setUnderline(false);
            perfilButton.setUnderline(true);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaPerfil.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}