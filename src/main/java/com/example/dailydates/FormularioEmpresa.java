package com.example.dailydates;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FormularioEmpresa
{
    @javafx.fxml.FXML
    private Label horarioLabel;
    @javafx.fxml.FXML
    private Label nombreLabel;
    @javafx.fxml.FXML
    private ChoiceBox categoriaChoiceBox;
    @javafx.fxml.FXML
    private Label direccionLabel;
    @javafx.fxml.FXML
    private Label categoriaLabel;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Pane fotoPane;
    @javafx.fxml.FXML
    private Label ciudadLabel;
    @javafx.fxml.FXML
    private Label cifLabel;
    @javafx.fxml.FXML
    private ImageView imagenPerfil;
    @javafx.fxml.FXML
    private TextField anyadirCiudad;
    @javafx.fxml.FXML
    private TextField anyadirNombre;
    @javafx.fxml.FXML
    private TextField anyadirDireccion;
    @javafx.fxml.FXML
    private TextField anyadirCif;
    @javafx.fxml.FXML
    private TextField anyadirHorario;
    @javafx.fxml.FXML
    private Button guardarButton;
    @javafx.fxml.FXML
    private Button cargar_imagen;
    private File imagenSeleccionada;

    @javafx.fxml.FXML
    public void initialize() {
        CategoriaModel catmod = new CategoriaModel();
        for(Categoria cat : catmod.listar_categorias()) {
            categoriaChoiceBox.getItems().add(cat);
        }
    }


    @javafx.fxml.FXML
    public void guardarButtonOnAction(ActionEvent actionEvent) {

        EmpresaModel empmod = new EmpresaModel();
        EmpresarioHolder emphol = EmpresarioHolder.getInstance();

        ArrayList<Categoria> cats = new ArrayList<>();
        cats.add((Categoria) categoriaChoiceBox.getValue());

        String nombre = anyadirNombre.getText();
        String CIF = anyadirCif.getText();
        String horario = anyadirHorario.getText();
        String ciudad = anyadirCiudad.getText();
        String direccion = anyadirDireccion.getText();
        Image foto_empresa = imagenPerfil.getImage();

        Empresa e = new Empresa(1,emphol.getEmpresario().getId(),cats,nombre,CIF,horario,ciudad,direccion,foto_empresa);

        if (empmod.anyadir_empresa(emphol.getEmpresario().getId(),e,(Categoria) categoriaChoiceBox.getValue(), imagenSeleccionada)){

        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("datos incorrectos");
            a.showAndWait();
        }

    }

    @javafx.fxml.FXML
    public void cargar_imagenOnClick(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen de perfil");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.png", "*.gif")
        );

        imagenSeleccionada = fileChooser.showOpenDialog(null);

        Image fotoperfil = new Image(imagenSeleccionada.toURI().toString());

        imagenPerfil.setImage(fotoperfil);
    }
}