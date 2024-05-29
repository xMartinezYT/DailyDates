package com.example.dailydates;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CitasModel extends Conexion{

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
    public boolean eliminar_cita(Citas citas){
        boolean resultado = false;

        try {
            String sql = "delete from citas where fecha = ? and hora = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(citas.getFecha()));
            ps.setTime(2,citas.getHora());
            ps.execute();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

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
    public ArrayList<Citas> listar_citas_empresario(int id_empresario){
        ArrayList<Citas> lista = new ArrayList<>();
        try {
            String sql = "Select * from citas where id_empresa in (select id_empresa from empresa where id_empresario = ?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1,id_empresario);
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


    public boolean mod_cita(Citas c, LocalDate fecha, Time hora, String pedido){
      boolean resultado = false;
        try {
            String sql = "update citas set fecha = ?, hora = ?, pedido = ? where fecha = ? and hora = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ps.setTime(2,hora);
            ps.setString(3,pedido);
            ps.setDate(4, Date.valueOf(c.getFecha()));
            ps.setTime(5,c.getHora());
            ps.execute();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }






}
