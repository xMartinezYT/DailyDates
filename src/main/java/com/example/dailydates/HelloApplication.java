package com.example.dailydates;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 860, 600);
        stage.setTitle("DailyDates");
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("estilo.css")).toExternalForm());
        stage.getIcons().add(new Image("file:src/main/resources/com/example/dailydates/img/DailyDateFoto.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}