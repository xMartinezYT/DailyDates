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

    /**
    * Esta clase maneja la visualización y gestión de los botones de categorías en nuestra aplicación Daily Dates.
    * Es responsable de cargar y mostrar empresas en una categoría específica.
    */

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

    /**
     * Inicializa el controlador BotonesCategorias.
     * Carga y muestra las empresas que pertenecen a la categoría seleccionada.
     */

    @javafx.fxml.FXML
    public void initialize() {

        // Obtener la instancia singleton de CategoriaHolder y EmpresaModel.

         CategoriaHolder catHol = CategoriaHolder.getInstance();
         EmpresaModel empMod = new EmpresaModel();
         int col = 1;
        try {
                  anyadirCategoriaLabel.setText(catHol.getCategoria().getNombre());
            // Iterar sobre las empresas en la categoría seleccionada y agregarlas al gridPane.

            for (Empresa emp : empMod.listar_empresas_categoria(catHol.getCategoria().getId())) {

                // Cargar el diseño FXML para cada empresa.

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("CategoriasMostrar.fxml"));
                AnchorPane anchor = fxmlLoader.load();

                // Inicializar el controlador CategoriasMostrar con la empresa actual.

                CategoriasMostrar categoriasMostrar = fxmlLoader.getController();
                categoriasMostrar.initialize(emp);

                // Agregar el diseño de la empresa al gridPane.

                gridPane.add(anchor,1,col);
                col++;
                // Establecer el margen para el diseño de la empresa.

                GridPane.setMargin(anchor,new Insets(2));
            }
        } catch (IOException e) {

            // Manejar IOException durante el proceso de carga del FXML.

            throw new RuntimeException(e);
        }
    }

    /**
     * Maneja el evento de acción cuando se hace clic en el botón "Atras".
     * Navega de vuelta a la vista PaginaCategorias.
     *
     * @param actionEvent el evento que se dispara al hacer clic en el botón "Atras".
     */

    @javafx.fxml.FXML
    public void atrasButtonOnAction(ActionEvent actionEvent) {
        try {

            // Cargar el diseño FXML de PaginaCategorias y establecerlo en el anchorPane actual.

            AnchorPane pane = FXMLLoader.load(getClass().getResource("PaginaCategorias.fxml"));
            this.anchorPane.getChildren().setAll(pane);
        } catch (IOException e) {

            // Manejar IOException durante el proceso de carga del FXML.

            throw new RuntimeException(e);
        }
    }
}