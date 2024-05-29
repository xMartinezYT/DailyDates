package com.example.dailydates;


    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    /**
    * La clase Conexion proporciona métodos para establecer y cerrar una conexión con la base de datos.
    */
    public class Conexion {

        // Variables de instancia para la conexión y detalles de la base de datos
        private Connection conn;
        private String cadenaConexion = "jdbc:mysql://localhost:3306/dailydates";
        private String nombreUsuario = "root";
        private String password = "1234";

        /**
         * Obtiene una conexión a la base de datos.
         *
         * @return la conexión establecida.
         */
        public Connection getConexion() {

            try {
                // Registra el controlador JDBC
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

                // Establece la conexión con la base de datos
                this.conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
                return this.conn;   // Retorna la conexión establecida

            } catch (SQLException e) {
                e.printStackTrace();
                return null;    // Retorna null si ocurre un error durante la conexión
            }
        }

        /**
         * Cierra la conexión con la base de datos.
         */
        public void cerrarConexion() {
            try {
                this.conn.close();  // Cierra la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



