package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PaginaCategorias
{
    @javafx.fxml.FXML
    private Button extraescolaresButton;
    @javafx.fxml.FXML
    private Button otrosButton;
    @javafx.fxml.FXML
    private ImageView otrosImage;
    @javafx.fxml.FXML
    private ImageView fruteriaImage;
    @javafx.fxml.FXML
    private ImageView saludImage;
    @javafx.fxml.FXML
    private ImageView restauranteImage;
    @javafx.fxml.FXML
    private Button saludButton;
    @javafx.fxml.FXML
    private ImageView extraescolarImage;
    @javafx.fxml.FXML
    private ImageView carniceriaImage;
    @javafx.fxml.FXML
    private Button restauranteButton;
    @javafx.fxml.FXML
    private Button carniceriaButton;
    @javafx.fxml.FXML
    private ImageView pasteleriaImage;
    @javafx.fxml.FXML
    private Button fruteriaButton;
    @javafx.fxml.FXML
    private AnchorPane categoriasAnchorPane;
    @javafx.fxml.FXML
    private Button pescaderiaButton1;
    @javafx.fxml.FXML
    private ImageView pescaderiaImage;
    @javafx.fxml.FXML
    private Button tallerButton;
    @javafx.fxml.FXML
    private ImageView tallerImage;
    @javafx.fxml.FXML
    private ImageView verduleriaImage;
    @javafx.fxml.FXML
    private Button peluqueriaButton;
    @javafx.fxml.FXML
    private Button verduleriaButton;
    @javafx.fxml.FXML
    private ImageView peluqueriaImage;
    @javafx.fxml.FXML
    private Button pasteleriasButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void extraescolaresButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(4));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void otrosButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(11));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void pescaderiaButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(3));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void restauranteButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(7));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void carniceriaButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(6));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void pasteleriaButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(1));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void saludButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(5));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void fruteriaButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(2));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void verduleriaButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(8));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void peluqueriaButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(10));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void tallerButtonOnAction(ActionEvent actionEvent) {
        try {
            CategoriaHolder catHol = CategoriaHolder.getInstance();
            CategoriaModel catMod = new CategoriaModel();
            catHol.setCategoria(catMod.buscar_categoria(9));
            AnchorPane pane = FXMLLoader.load(getClass().getResource("BotonesCategorias.fxml"));
            this.categoriasAnchorPane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}