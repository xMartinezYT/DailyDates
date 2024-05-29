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
 * Clase que maneja las operaciones relacionadas con la tabla 'usuario' en la base de datos.
 */
public class UsuarioModel extends Conexion{

    /**
     * Obtiene una lista de todos los usuarios almacenados en la base de datos.
     * @return ArrayList de usuarios.
     */
    public ArrayList<Usuario> ListarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();

        try {
            String sql = "Select * from usuario";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Image img = null;
                if (rs.getBlob(7) != null) {
                   img = new Image(rs.getBlob("foto_perfil").getBinaryStream());
                }
                Usuario u = new Usuario(rs.getInt("id_Usuario"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("gmail"),rs.getString("contrasenya"),rs.getString("telefono"),img);
                lista.add(u);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    /**
     * Añade un nuevo usuario a la base de datos.
     * @param u Objeto Usuario a añadir.
     * @param img Archivo de imagen del perfil del usuario.
     * @return true si se añadió correctamente, false en caso contrario.
     */
    public boolean anyadir_usuario(Usuario u, File img) {
        boolean resultado = false;
        try {
            String sql = "insert into usuario (nombre,apellidos,gmail,contrasenya,telefono,foto_perfil) values(?,?,?,?,?,?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getGmail());
            ps.setString(4, u.getContrasenya());
            ps.setString(5, u.getTelefono());
            if (u.getFoto_perfil() != null) {
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
     * Elimina un usuario de la base de datos.
     * @param u Usuario a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     */
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

    /**
     * Actualiza los datos de un usuario en la base de datos.
     *
     * @param u El objeto Usuario con los datos actualizados.
     * @return true si la actualización se realiza con éxito, false en caso contrario.
     * @throws RuntimeException si ocurre un error durante la actualización.
     */
   public boolean mod_usuario(Usuario u){
        boolean resultado = false;
       try {
           // Preparar la consulta SQL para actualizar los datos del usuario

           String sql = "update usuario set nombre = ?, apellidos = ?, gmail = ?, contrasenya = ?, telefono = ?, foto_perfil = ? where id=?";
           PreparedStatement ps = this.getConexion().prepareStatement(sql);
           // Establecer los valores de los parámetros en la consulta SQL

           ps.setString(1,u.getNombre());
           ps.setString(2,u.getApellidos());
           ps.setString(3,u.getGmail());
           ps.setString(4,u.getContrasenya());
           ps.setString(5,u.getTelefono());
           FileInputStream fis = null;

           // Convertir la imagen de perfil del usuario en un flujo de entrada de bytes
           fis = new FileInputStream(String.valueOf(u.getFoto_perfil()));
           File f = new File(String.valueOf(u.getFoto_perfil()));

           // Establecer el flujo de entrada de bytes como parámetro en la consulta SQL
           ps.setBinaryStream(6, fis, (int) f.length());

           // Establecer el ID del usuario como parámetro en la consulta SQL
           ps.setInt(7,u.getId());

           // Ejecutar la consulta SQL para actualizar los datos del usuario
           ps.execute();
           resultado = true;

       } catch (SQLException | FileNotFoundException e) {
           // Lanzar una excepción en caso de error durante la actualización del usuario
           throw new RuntimeException(e);
       }
       return resultado;
   }

    /**
     * Valida las credenciales de un usuario en la base de datos.
     *
     * @param gmail      El correo electrónico del usuario.
     * @param contrasenya La contraseña del usuario.
     * @return true si las credenciales son válidas, false en caso contrario.
     * @throws RuntimeException si ocurre un error durante la validación.
     */
   public boolean validar_usuario(String gmail, String contrasenya){
       try {

           // Preparar la consulta SQL para validar las credenciales del usuario
           String sql = "Select * from usuario where gmail = ? and contrasenya = ?";
           PreparedStatement ps = this.getConexion().prepareStatement(sql);

           // Establecer los parámetros en la consulta SQL
           ps.setString(1,gmail);
           ps.setString(2,contrasenya);

           // Ejecutar la consulta SQL para obtener el resultado de la validación
           ResultSet rs = ps.executeQuery();

           // Verificar si se encuentra al menos un resultado en el conjunto de resultados
           while(rs.next()){
               // Si se encuentra al menos un resultado, las credenciales son válidas
              return true;
           }

       } catch (SQLException e) {
           // Lanzar una excepción en caso de error durante la validación de las credenciale
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
                Image img = null;
                if (rs.getBlob(7) != null) {
                    img = new Image(rs.getBlob("foto_perfil").getBinaryStream());
                }
                Usuario u = new Usuario(rs.getInt("id_Usuario"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("gmail"),rs.getString("contrasenya"),rs.getString("telefono"),img);
                lista.add(u);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Si no se encuentra ningún resultado, las credenciales no son válidas
        return lista;
    }

    /**
     * Busca un usuario en la base de datos utilizando su correo electrónico.
     *
     * @param gmail El correo electrónico del usuario a buscar.
     * @return El usuario encontrado o un nuevo objeto Usuario si no se encuentra ningún usuario con el correo electrónico dado.
     * @throws RuntimeException si ocurre un error durante la búsqueda del usuario.
     */
    public Usuario buscar_usuario(String gmail) {
        // Crear un nuevo objeto Usuario para almacenar el resultado de la búsqueda
        Usuario u = new Usuario();
        try {
            // Preparar la consulta SQL para buscar un usuario por su correo electrónico
            String sql = "select * from usuario where gmail = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Establecer el parámetro en la consulta SQL
            ps.setString(1,gmail);
            // Ejecutar la consulta SQL para obtener el resultado de la búsqueda
            ResultSet rs = ps.executeQuery();

            // Verificar si se encontraron resultados en el conjunto de resultados
            while(rs.next()){
                // Si se encontró al menos un resultado, crear un nuevo objeto Usuario con los datos obtenidos
                Image img = null;
                if (rs.getBlob(7) != null) {
                    img = new Image(rs.getBlob("foto_perfil").getBinaryStream());
                }
                 u = new Usuario(rs.getInt("id_Usuario"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("gmail"),rs.getString("contrasenya"),rs.getString("telefono"),img);
            }

        } catch (SQLException e) {
            // Lanzar una excepción en caso de error durante la búsqueda del usuario
            throw new RuntimeException(e);
        }
        // Devolver el usuario encontrado o un nuevo objeto Usuario si no se encontró ningún usuario con el correo electrónico dado
        return u;
    }
    }

