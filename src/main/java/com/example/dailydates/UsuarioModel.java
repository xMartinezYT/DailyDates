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

    public boolean anyadir_usuario(Usuario u) {
        boolean resultado = false;
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
            resultado = true;

        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public boolean eliminar_usuario(Usuario u){
        boolean resultado = false;
        try {
            String sql = "delete from usuario where id_Usuario = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1,u.getId());
            ps.execute();
            resultado = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

   public boolean mod_usuario(Usuario u){
        boolean resultado = false;
       try {
           String sql = "update usuario set nombre = ?, apellidos = ?, gmail = ?, contrasenya = ?, telefono = ?, foto_perfil = ? where id=?";
           PreparedStatement ps = this.getConexion().prepareStatement(sql);
           ps.setString(1,u.getNombre());
           ps.setString(2,u.getApellidos());
           ps.setString(3,u.getGmail());
           ps.setString(4,u.getContrasenya());
           ps.setString(5,u.getTelefono());
           FileInputStream fis = null;
           fis = new FileInputStream(String.valueOf(u.getFoto_perfil()));
           File f = new File(String.valueOf(u.getFoto_perfil()));
           ps.setBinaryStream(6, fis, (int) f.length());
           ps.setInt(7,u.getId());
           ps.execute();
           resultado = true;

       } catch (SQLException | FileNotFoundException e) {
           throw new RuntimeException(e);
       }
       return resultado;
   }

   public boolean validar_usuario(String gmail, String contrasenya){

       try {
           String sql = "Select * from usuario where gmail = ?, contrasenya = ?";
           PreparedStatement ps = this.getConexion().prepareStatement(sql);
           ps.setString(1,gmail);
           ps.setString(2,contrasenya);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
              return true;
           }

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
         return false;
   }

    public ArrayList<Usuario> filtrar_usuarios(String filtro, String dato) {
        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            String sql = "select * from usuario where ? = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1,filtro);
            ps.setString(2,dato);
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

