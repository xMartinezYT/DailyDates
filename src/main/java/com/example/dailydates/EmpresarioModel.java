package com.example.dailydates;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresarioModel extends Conexion{

    public ArrayList<Empresario> Listar_Empresarios() {
        ArrayList<Empresario> lista = new ArrayList<>();

        try {
            String sql = "Select * from empresario";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Image img = new Image(rs.getBlob("foto_perfil").getBinaryStream());
                Empresario e = new Empresario(rs.getInt("id_empresario"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("gmail"),rs.getString("contrasenya"),rs.getString("telefono"),img);
                lista.add(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public boolean anyadir_empresario(Empresario em, File img){
        boolean resultado = false;
        try {
            String sql = "insert into empresario (nombre,apellidos,gmail,contrasenya,telefono,foto_perfil) values(?,?,?,?,?,?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getApellidos());
            ps.setString(3, em.getGmail());
            ps.setString(4, em.getContrasenya());
            ps.setString(5, em.getTelefono());
            if (em.getFoto_perfil() != null) {
                FileInputStream fis = new FileInputStream(img);
                File f = new File(String.valueOf(img));
                ps.setBinaryStream(6, fis, (int) f.length());
            }else {
                ps.setBinaryStream(6,null);
            }
            ps.execute();
            resultado = true;
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    public boolean eliminar_empresario(int id){

        boolean resultado = false;
        try {
            String sql = "delete from empresario where id_empresario = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            resultado = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public boolean modificar_empresario(Empresario em){
        boolean resultado = false;

        try {
            String sql = "update empresario set nombre = ?, apellidos = ?,gmail = ?,contrasenya = ?, telefono = ?, foto_perfil = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getApellidos());
            ps.setString(3, em.getGmail());
            ps.setString(4, em.getContrasenya());
            ps.setString(5, em.getTelefono());
            FileInputStream fis = new FileInputStream(String.valueOf(em.getFoto_perfil()));
            File f = new File(String.valueOf(em.getFoto_perfil()));
            ps.setBinaryStream(6, fis, (int) f.length());
            ps.execute();
            resultado = true;

        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
    public boolean validar_empresario(String gmail, String contrasenya) {

        try {
            String sql = "Select * from empresario where gmail = ?, contrasenya = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, gmail);
            ps.setString(2, contrasenya);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
