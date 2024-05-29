package com.example.dailydates;

import com.mysql.cj.protocol.Resultset;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaModel extends Conexion{

    public ArrayList<Empresa> listar_empresas() {
        ArrayList<Empresa> lista = new ArrayList<>();


        try {
            String sql = "select * from empresa";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ArrayList<Categoria> categorias = new ArrayList<>();
                String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                ps2.setInt(1,rs.getInt(1));
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()){
                    Categoria g = new Categoria(rs2.getInt(1),rs2.getString(3),rs2.getString(2));
                    categorias.add(g);
                }
                Image img = new Image(rs.getBlob(7).getBinaryStream());
                Empresa e = new Empresa(rs.getInt(1),rs.getInt(2),categorias,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),img);
                lista.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

        public boolean anyadir_empresa(int id_empresario, Empresa em, Categoria c, File imagenseleccionada){
        boolean resultado = false;

            try {
                String sql = "insert into empresa (id_empresario, nombre, cif,horario,ciudad,foto_empresa,direccion) values(?,?,?,?,?,?,?)";
                PreparedStatement ps = this.getConexion().prepareStatement(sql);
                ps.setInt(1,id_empresario);
                ps.setString(2,em.getNombre());
                ps.setString(3,em.getCIF());
                ps.setString(4,em.getHorario());
                ps.setString(5,em.getCiudad());
                FileInputStream fis = new FileInputStream(String.valueOf(imagenseleccionada));
                File f = new File(String.valueOf(imagenseleccionada));
                ps.setBinaryStream(6, fis, (int) f.length());
                ps.setString(7,em.getDireccion());
                ps.execute();


                String sql3 = "SELECT max(id_Empresa) FROM dailydates.empresa";
                PreparedStatement ps3 = this.getConexion().prepareStatement(sql3);
                ResultSet rs3 = ps3.executeQuery();
                while(rs3.next()) {
                    String sql2 = "insert into pertenece (id_categoria,id_empresa) values (?,?)" ;
                    PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                    ps2.setInt(1, c.getId());
                    ps2.setInt(2, rs3.getInt(1));
                    ps2.execute();
                }
                resultado = true;
            } catch (SQLException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }
          return resultado;
        }
        public boolean eliminar_empresa(int id){

            boolean resultado = false;
            try {
                String sql = "delete from empresa where id_empresa = ?";
                PreparedStatement ps = this.getConexion().prepareStatement(sql);
                ps.setInt(1,id);
                ps.execute();
               resultado = true;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return resultado;
        }

        public ArrayList<Empresa> listar_empresas_empresario(int id_empresario){
            ArrayList<Empresa> lista = new ArrayList<>();

            try {
                String sql = "select * from empresa where id_empresario = ?";
                PreparedStatement ps = this.getConexion().prepareStatement(sql);
                ps.setInt(1,id_empresario);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){

                    ArrayList<Categoria> categorias = new ArrayList<>();
                    String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                    PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                    ps2.setInt(1,rs.getInt(1));
                    ResultSet rs2 = ps2.executeQuery();
                    while(rs2.next()){

                        Categoria g = new Categoria(rs2.getInt(1),rs2.getString(3),rs2.getString(2));
                        categorias.add(g);
                    }
                    Image img = new Image(rs.getBlob(7).getBinaryStream());
                    Empresa e = new Empresa(rs.getInt(1),rs.getInt(2),categorias,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),img);
                    lista.add(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return lista;
        }

        public ArrayList<Empresa> listar_empresas_categoria(int id_categoria){
            ArrayList<Empresa> lista = new ArrayList<>();

            try {
               String sql = "select * from empresa where id_empresa in(select id_empresa from pertenece where id_categoria = ?)";
               PreparedStatement ps = this.getConexion().prepareStatement(sql);
               ps.setInt(1,id_categoria);
               ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ArrayList<Categoria> categorias = new ArrayList<>();
                    String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                    PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                    ps2.setInt(1,rs.getInt(1));
                    ResultSet rs2 = ps2.executeQuery();
                    while(rs2.next()){
                        Categoria g = new Categoria(rs2.getInt(1),rs2.getString(3),rs2.getString(2));
                        categorias.add(g);
                    }
                    Image img = new Image(rs.getBlob(7).getBinaryStream());
                    Empresa e = new Empresa(rs.getInt(1),rs.getInt(2),categorias,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),img);
                    lista.add(e);
                }

                } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            return lista;
        }

          public boolean modificar_empresa(Empresa em){
              boolean resultado = false;
              try {
                  String sql = "update empresa set nombre = ?, Horario = ?, ciudad = ?, direccion = ? where id_empresa = ?";
                  PreparedStatement ps = this.getConexion().prepareStatement(sql);
                  ps.setString(1,em.getNombre());
                  ps.setString(2,em.getHorario());
                  ps.setString(3,em.getCiudad());
                  ps.setString(4,em.getDireccion());
                  ps.setInt(5,em.getId_empresa());
                  ps.execute();
                  resultado = true;

              } catch (SQLException e) {
                  throw new RuntimeException(e);
              }
              return resultado;
          }

           public  ArrayList<Empresa> listar_empresas_ciudad(String ciudad){

               ArrayList<Empresa> lista = new ArrayList<>();


               try {
                   String sql = "select * from empresa where ciudad = ?";
                   PreparedStatement ps = this.getConexion().prepareStatement(sql);
                   ps.setString(1,ciudad);
                   ResultSet rs = ps.executeQuery();

                   while(rs.next()){
                       ArrayList<Categoria> categorias = new ArrayList<>();
                       String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                       PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                       ps2.setInt(1,rs.getInt(1));
                       ResultSet rs2 = ps2.executeQuery();
                       while(rs2.next()){
                           Categoria g = new Categoria(rs2.getInt(1),rs2.getString(3),rs2.getString(2));
                           categorias.add(g);
                       }
                       Image img = new Image(rs.getBlob(7).getBinaryStream());
                       Empresa e = new Empresa(rs.getInt(1),rs.getInt(2),categorias,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),img);
                       lista.add(e);
                   }
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
               return lista;
           }

           public Empresa buscar_empresa(int id){
                   Empresa e = null;
               try {
                   String sql = "select * from empresa where id_empresa = ?";
                   PreparedStatement ps = this.getConexion().prepareStatement(sql);
                   ps.setInt(1,id);
                   ResultSet rs = ps.executeQuery();
                   while(rs.next()){

                       ArrayList<Categoria> categorias = new ArrayList<>();
                       String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                       PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                       ps2.setInt(1,rs.getInt(1));
                       ResultSet rs2 = ps2.executeQuery();
                       while(rs2.next()){

                           Categoria g = new Categoria(rs2.getInt(1),rs2.getString(3),rs2.getString(2));
                           categorias.add(g);
                       }
                       Image img = new Image(rs.getBlob(7).getBinaryStream());
                        e = new Empresa(rs.getInt(1),rs.getInt(2),categorias,rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8),img);
                   }
               } catch (SQLException em) {
                   throw new RuntimeException(em);
               }
               return e;
           }

           public boolean anyadir_categoria(int id_categoria, int id_empresa){
                  boolean resultado = false;
               try {
                   String sql = "insert into pertenece values(?,?)";
                   PreparedStatement ps = this.getConexion().prepareStatement(sql);
                   ps.setInt(1,id_categoria);
                   ps.setInt(2,id_empresa);
                   ps.execute();
                   resultado = true;
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
                  return resultado;
           }
           public boolean eliminar_categoria(int id_categoria, int id_empresa){
                boolean resultado = false;
                    try {
                        String sql = "delete from pertenece where id_categoria = ? and id_empresa = ?";
                        PreparedStatement ps = this.getConexion().prepareStatement(sql);
                        ps.setInt(1,id_categoria);
                        ps.setInt(2,id_empresa);
                        ps.execute();
                        resultado = true;
                    } catch (SQLException e) {
                         throw new RuntimeException(e);
                    }
                    return resultado;
                }
        }



