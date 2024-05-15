package com.example.dailydates;


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class Conexion {


        private Connection conn;
        private String cadenaConexion = "jdbc:mysql://localhost:3306/dispositivos";
        private String nombreUsuario = "root";
        private String password = "1234";

        public Connection getConexion() {

            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                this.conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
                return this.conn;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void cerrarConexion() {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



