package com.example.dailydates;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AnyadirCategoria
{
    @javafx.fxml.FXML
    private Button eliminarCategoriaButton;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Label elejirCategoriaLabel;
    @javafx.fxml.FXML
    private ChoiceBox categoriasChoicebox;
    @javafx.fxml.FXML
    private Button guardarCambiosButton;
    @javafx.fxml.FXML
    private Pane pane;

    private Empresa empresa;

    /**
     * Obtiene la empresa asociada a esta instancia.
     * @return La empresa asociada.
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece la empresa asociada a esta instancia.
     * @param empresa La empresa a establecer.
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Inicializa la elección de categorías.
     * @param empr La empresa asociada.
     */
    @javafx.fxml.FXML
    public void initialize(Empresa empr) {
        setEmpresa(empr);
        CategoriaModel categoriaModel = new CategoriaModel();
        for (Categoria categoria : categoriaModel.listar_categorias()) {
            categoriasChoicebox.getItems().add(categoria);
        }
    }

    /**
     * Maneja el evento de clic en el botón para eliminar una categoría.
     * @param actionEvent El evento de clic.
     */
    @javafx.fxml.FXML
    public void eliminarCategoriaButtonOnAction(ActionEvent actionEvent) {
        EmpresaModel empresaModel = new EmpresaModel();

        Categoria cat = (Categoria) categoriasChoicebox.getValue();

        if (empresaModel.eliminar_categoria(cat.getId(),empresa.getId_empresa())){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Eliminado correctamente");
            a.showAndWait();
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error al eliminar categoria");
            a.showAndWait();
        }

    }

    /**
     * Maneja el evento de clic en el botón para guardar los cambios en las categorías.
     * @param actionEvent El evento de clic.
     */
    @javafx.fxml.FXML
    public void guardarCambiosButtonOnAction(ActionEvent actionEvent) {

        EmpresaModel empresaModel = new EmpresaModel();

        Categoria cat = (Categoria) categoriasChoicebox.getValue();

        if (empresaModel.anyadir_categoria(cat.getId(),empresa.getId_empresa())){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Guardado correctamente");
            a.showAndWait();
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error al añadir categoria");
            a.showAndWait();
        }

    }


    }
