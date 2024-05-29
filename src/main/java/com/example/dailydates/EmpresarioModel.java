package com.example.dailydates;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La clase EmpresarioModel maneja las operaciones CRUD (crear, leer, actualizar, eliminar) para los empresarios en la base de datos.
 */
public class EmpresarioModel extends Conexion{

    /**
     * Lista todos los empresarios en la base de datos.
     *
     * @return una lista de objetos Empresario
     */
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

    /**
     * Añade un nuevo empresario a la base de datos.
     *
     * @param em el objeto Empresario a añadir
     * @param img el archivo de imagen del perfil del empresario
     * @return true si el empresario se añadió con éxito, false en caso contrario
     */
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

    /**
     * Elimina un empresario de la base de datos por su ID.
     *
     * @param id el ID del empresario a eliminar
     * @return true si el empresario se eliminó con éxito, false en caso contrario
     */
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

    /**
     * Modifica los detalles de un empresario existente en la base de datos.
     *
     * @param em el objeto Empresario con los nuevos detalles
     * @return true si el empresario se modificó con éxito, false en caso contrario
     */
    public boolean modificar_empresario(Empresario em){
        boolean resultado = false;

        try {
            String sql = "update empresario set nombre = ?, apellidos = ?,gmail = ?,contrasenya = ?, telefono = ? where id_empresario = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getApellidos());
            ps.setString(3, em.getGmail());
            ps.setString(4, em.getContrasenya());
            ps.setString(5, em.getTelefono());
            ps.setInt(6,em.getId());
            ps.execute();
            resultado = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    /**
     * Valida las credenciales de un empresario.
     *
     * @param gmail el correo electrónico del empresario
     * @param contrasenya la contraseña del empresario
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean validar_empresario(String gmail, String contrasenya) {

        try {
            String sql = "Select * from empresario where gmail = ? and contrasenya = ?";
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

    /**
     * Busca un empresario en la base de datos por su correo electrónico.
     *
     * @param gmail el correo electrónico del empresario a buscar
     * @return el objeto Empresario encontrado, o un nuevo objeto Empresario si no se encuentra
     */
    public Empresario buscar_empresario(String gmail) {
        Empresario em = new Empresario();

        try {
            String sql = "select * from empresario where gmail = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1,gmail);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Image img = null;
                if (rs.getBlob(7) != null) {
                    img = new Image(rs.getBlob("foto_perfil").getBinaryStream());
                }
                em = new Empresario(rs.getInt("id_empresario"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("gmail"),rs.getString("contrasenya"),rs.getString("telefono"),img);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return em;
    }

}
