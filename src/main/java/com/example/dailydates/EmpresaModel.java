package com.example.dailydates;

import com.mysql.cj.protocol.Resultset;
import javafx.scene.image.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaModel extends Conexion{

    public ArrayList<Empresa> listar_empresas() {
        ArrayList<Empresa> lista = new ArrayList<>();
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            String sql = "select * from empresa";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                categorias.clear();
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

        public boolean anyadir_empresa(){
        boolean resultado = false;

            try {
                String sql = "insert into empresa values(?,?,?,?,?,?,?,?)";
                PreparedStatement ps = this.getConexion().prepareStatement(sql);



                ps.execute();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

          return resultado;
        }



}
