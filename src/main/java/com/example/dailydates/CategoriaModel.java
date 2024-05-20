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



}
