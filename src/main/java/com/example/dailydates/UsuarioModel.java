package com.example.dailydates;

import javafx.scene.image.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioModel extends Conexion{


    public ArrayList<Usuario> ListarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            String sql = "Select * from usuario";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Image img = new Image(rs.getBlob("foto_perfil").getBinaryStream());
                Usuario u = new Usuario(rs.getInt("id_Usuario"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("gmail"),rs.getString("contrasenya"),rs.getString("telefono"),img);
                lista.add(u);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }


}
