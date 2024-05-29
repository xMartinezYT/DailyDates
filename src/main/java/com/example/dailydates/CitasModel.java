package com.example.dailydates;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * CitasModel class provides methods to interact with the citas table in the database.
 * It extends the Conexion class to utilize the database connection.
 */
public class CitasModel extends Conexion{

    /**
     * Retrieves a list of all appointments from the database.
     *
     * @return ArrayList of Citas objects representing all appointments.
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
     * Adds a new appointment to the database.
     *
     * @param c Citas object representing the appointment to be added.
     * @return boolean indicating the success of the operation.
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
     * Deletes an appointment from the database based on its ID.
     *
     * @param id The ID of the appointment to be deleted.
     * @return boolean indicating the success of the operation.
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
     * Searches for an appointment in the database based on its date and time.
     *
     * @param fecha The date of the appointment.
     * @param hora The time of the appointment.
     * @return Citas object representing the found appointment, or null if not found.
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
     * Retrieves a list of appointments for a specific user from the database.
     *
     * @param id_usuario The ID of the user.
     * @return ArrayList of Citas objects representing the user's appointments.
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

    /**
     * Retrieves a list of appointments for a specific company from the database.
     *
     * @param id_empresa The ID of the company.
     * @return ArrayList of Citas objects representing the company's appointments.
     */
    public ArrayList<Citas> listar_citas_empresa(int id_empresa){
        ArrayList<Citas> lista = new ArrayList<>();
        try {
            String sql = "Select * from citas where id_empresa = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1,id_empresa);
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
