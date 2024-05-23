package com.example.dailydates;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class PaginaPrincipalEmpresario
{

    @javafx.fxml.FXML
    private Button perfilButton;
    @javafx.fxml.FXML
    private AnchorPane contenedorAnchorPane;
    @javafx.fxml.FXML
    private Pane menuPane;
    @javafx.fxml.FXML
    private Button establecimientosButton;
    @javafx.fxml.FXML
    private Button calendarioButton;
    @javafx.fxml.FXML
    private AnchorPane anchorpaneMainEmpresario;

    @javafx.fxml.FXML
    public void initialize() {

        // Animación de degradado del color del texto
        Timeline calendarioTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(calendarioButton.textFillProperty(), Color.WHITE)),
                new KeyFrame(Duration.seconds(1), new KeyValue(calendarioButton.textFillProperty(), Color.DEEPPINK))
        );
        calendarioTimeline.setAutoReverse(true); // Repetir la animación en reversa
        calendarioTimeline.setCycleCount(Animation.INDEFINITE); // Repetir la animación infinitamente
        // Evento al pasar el cursor sobre el botón
        calendarioButton.setOnMouseEntered(event -> {
            calendarioTimeline.play(); // Iniciar la animación
        });

        // Evento al sacar el cursor del botón
        calendarioButton.setOnMouseExited(event -> {
            calendarioTimeline.stop(); // Detener la animación
        });


        // Animación de degradado del color del texto
        Timeline establecimientosTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(establecimientosButton.textFillProperty(), Color.WHITE)),
                new KeyFrame(Duration.seconds(1), new KeyValue(establecimientosButton.textFillProperty(), Color.DEEPPINK))
        );
        establecimientosTimeline.setAutoReverse(true); // Repetir la animación en reversa
        establecimientosTimeline.setCycleCount(Animation.INDEFINITE); // Repetir la animación infinitamente
        // Evento al pasar el cursor sobre el botón
        establecimientosButton.setOnMouseEntered(event -> {
            establecimientosTimeline.play(); // Iniciar la animación
        });

        // Evento al sacar el cursor del botón
        establecimientosButton.setOnMouseExited(event -> {
            establecimientosTimeline.stop(); // Detener la animación
        });



        // Animación de degradado del color del texto
        Timeline perfilTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(perfilButton.textFillProperty(), Color.PINK)),
                new KeyFrame(Duration.seconds(1), new KeyValue(perfilButton.textFillProperty(), Color.WHITE))
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
            establecimientosButton.setUnderline(false);
            calendarioButton.setUnderline(true);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCalendario.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void calendarioButtonOnAction(ActionEvent actionEvent) {

        try {
            establecimientosButton.setUnderline(false);
            calendarioButton.setUnderline(true);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCalendario.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @javafx.fxml.FXML
    public void perfilButtonOnAction(ActionEvent actionEvent) {

        try {
            establecimientosButton.setUnderline(false);
            calendarioButton.setUnderline(false);
            perfilButton.setUnderline(true);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaPerfilEmpresario.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void establecimientosButtonOnAction(ActionEvent actionEvent) {
        try {
            establecimientosButton.setUnderline(true);
            calendarioButton.setUnderline(false);
            perfilButton.setUnderline(false);

            AnchorPane pane = FXMLLoader.load(getClass().getResource("Establecimientos.fxml"));
            this.contenedorAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
    }
}}