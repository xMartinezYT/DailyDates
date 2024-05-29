package com.example.dailydates;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * La clase CitasModel proporciona métodos para interactuar con la base de datos de citas.
 * Extiende de la clase Conexion para utilizar la conexión a la base de datos.
 */
public class CitasModel extends Conexion{

    /**
     * Lista todas las citas en la base de datos.
     *
     * @return una lista de objetos Citas.
     */
    public ArrayList<Citas> listar_citas(){
        ArrayList<Citas> lista = new ArrayList<>();
        try {
            String sql = "Select * from citas";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                  Citas c =  new Citas(rs.getInt(2),rs.getInt(1),rs.getDate(3).toLocalDate(),rs.getTime(5),rs.getString(4));
                  lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    /**
     * Añade una nueva cita a la base de datos.
     *
     * @param c el objeto Citas a añadir.
     * @return true si la cita se añadió correctamente, false en caso contrario.
     */
    public boolean anyadir_cita(Citas c){
        boolean resultado = false;

        try {
            String sql = "insert into citas (id_empresa,id_usuario,fecha,pedido,hora) values(?,?,?,?,?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);

            ps.setInt(1,c.getId_empresa());
            ps.setInt(2,c.getId_usuario());
            ps.setDate(3, Date.valueOf(c.getFecha()));
            ps.setString(4,c.getPedido());
            ps.setTime(5,c.getHora());
            ps.execute();

            resultado = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    /**
     * Elimina una cita de la base de datos.
     *
     * @param id el ID de la cita a eliminar.
     * @return true si la cita se eliminó correctamente, false en caso contrario.
     */
    public boolean eliminar_cita(int id){
        boolean resultado = false;

        try {
            String sql = "delete from citas where id = ?";
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
     * Busca una cita específica en la base de datos por fecha y hora.
     *
     * @param fecha la fecha de la cita.
     * @param hora la hora de la cita.
     * @return el objeto Citas encontrado, o null si no se encontró ninguna cita.
     */
    public Citas buscar_cita(LocalDate fecha, Time hora){
        Citas c = null;
        try {
            String sql = "Select * from citas where fecha = ?, hora = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setDate(1,Date.valueOf(fecha));
            ps.setTime(2,hora);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                c =  new Citas(rs.getInt(2),rs.getInt(1),rs.getDate(3).toLocalDate(),rs.getTime(5),rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    /**
     * Lista todas las citas de un usuario específico.
     *
     * @param id_usuario el ID del usuario.
     * @return una lista de objetos Citas del usuario.
     */
    public ArrayList<Citas> listar_citas_usuario(int id_usuario){
        ArrayList<Citas> lista = new ArrayList<>();
        try {
            String sql = "Select * from citas where id_usuario = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1,id_usuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Citas c =  new Citas(rs.getInt(2),rs.getInt(1),rs.getDate(3).toLocalDate(),rs.getTime(5),rs.getString(4));
                lista.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

}



