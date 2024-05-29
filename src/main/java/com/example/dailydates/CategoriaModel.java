package com.example.dailydates;

import javafx.scene.image.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Esta clase maneja las operaciones relacionadas con la tabla 'categoria' en la base de datos.
 * Hereda de la clase 'Conexion' para utilizar la conexión a la base de datos.
 */

public class   CategoriaModel extends Conexion{

    /**
     * Lista todas las categorías de la base de datos.
     *
     * @return una lista de objetos 'Categoria' que representan todas las categorías en la base de datos.
     */

    public ArrayList<Categoria> listar_categorias(){
        ArrayList<Categoria> lista = new ArrayList<>();

        try {

            // Consulta SQL para seleccionar todas las categorías

            String sql = "Select * from categoria";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Itera sobre el resultado y crea objetos 'Categoria' para cada registro

            while(rs.next()){
                Categoria g = new Categoria(rs.getInt(1),rs.getString(3),rs.getString(2));
                lista.add(g);
            }

        } catch (SQLException e) {

            // Lanza una RuntimeException si ocurre una SQLException

            throw new RuntimeException(e);
        }
        return lista;
    }

    /**
     * Añade una nueva categoría a la base de datos.
     *
     * @param c la categoría a añadir.
     * @return true si la categoría fue añadida exitosamente, false en caso contrario.
     */

    public boolean anyadir_categoria(Categoria c){
            boolean resultado = false;
        try {

            // Consulta SQL para insertar una nueva categoría

            String sql = "insert into categoria (descripcion,nombre) values(?,?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1,c.getDescripcion());
            ps.setString(2,c.getNombre());
            ps.execute();

            resultado = true;

        } catch (SQLException e) {

            // Lanza una RuntimeException si ocurre una SQLException

            throw new RuntimeException(e);
        }
        return resultado;
    }

    /**
     * Elimina una categoría de la base de datos.
     *
     * @param id el ID de la categoría a eliminar.
     * @return true si la categoría fue eliminada exitosamente, false en caso contrario.
     */

    public boolean eliminar_categoria(int id){
        boolean resultado = false;

        try {

            // Consulta SQL para eliminar una categoría por su ID

            String sql = "delete from categoria where id = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            resultado = true;
        } catch (SQLException e) {

            // Lanza una RuntimeException si ocurre una SQLException

            throw new RuntimeException(e);
        }
        return resultado;
    }

    /**
     * Busca una categoría en la base de datos por su ID.
     *
     * @param id el ID de la categoría a buscar.
     * @return un objeto 'Categoria' que representa la categoría encontrada, o null si no se encontró ninguna categoría.
     */

    public Categoria buscar_categoria(int id){
        Categoria g = null;
        try {

            // Consulta SQL para seleccionar una categoría por su ID

            String sql = "Select * from categoria where id_categoria = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            // Si se encuentra una categoría, crea un objeto 'Categoria' para representarla

            while(rs.next()){
                g = new Categoria(rs.getInt(1),rs.getString(3),rs.getString(2));
            }
        } catch (SQLException e) {

            // Lanza una RuntimeException si ocurre una SQLException

            throw new RuntimeException(e);
        }
        return g;
    }


}
