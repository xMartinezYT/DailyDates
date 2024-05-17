package com.example.dailydates;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public void anyadir_usuario(Usuario u) {
        try {
            String sql = "insert into usuario values(?,?,?,?,?,?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getGmail());
            ps.setString(4, u.getContrasenya());
            ps.setString(5, u.getTelefono());
            FileInputStream fis = new FileInputStream(String.valueOf(u.getFoto_perfil()));
            File f = new File(String.valueOf(u.getFoto_perfil()));
            ps.setBinaryStream(6, fis, (int) f.length());
            ps.execute();

        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}

