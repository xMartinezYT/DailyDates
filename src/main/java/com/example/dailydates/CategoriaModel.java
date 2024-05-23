package com.example.dailydates;

import javafx.scene.image.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaModel extends Conexion{

    public ArrayList<Categoria> listar_categorias(){
        ArrayList<Categoria> lista = new ArrayList<>();

        try {
            String sql = "Select * from categoria";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Categoria g = new Categoria(rs.getInt(1),rs.getString(3),rs.getString(2));
                lista.add(g);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public boolean anyadir_categoria(Categoria c){
            boolean resultado = false;
        try {
            String sql = "insert into categoria (descripcion,nombre) values(?,?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1,c.getDescripcion());
            ps.setString(2,c.getNombre());
            ps.execute();

            resultado = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public boolean eliminar_categoria(int id){
        boolean resultado = false;

        try {
            String sql = "delete from categoria where id = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public Categoria buscar_categoria(int id){
        Categoria g = null;
        try {
            String sql = "Select * from categoria";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                g = new Categoria(rs.getInt(1),rs.getString(3),rs.getString(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return g;
    }


}
