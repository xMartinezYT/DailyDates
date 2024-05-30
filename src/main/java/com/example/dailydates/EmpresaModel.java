package com.example.dailydates;

import com.mysql.cj.protocol.Resultset;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 * La clase EmpresaModel proporciona métodos para interactuar con la base de datos relacionados con las empresas.
 */
public class EmpresaModel extends Conexion {

    /**
     * Obtiene una lista de todas las empresas en la base de datos.
     *
     * @return Una lista de empresas.
     */
    public ArrayList<Empresa> listar_empresas() {
        ArrayList<Empresa> lista = new ArrayList<>();


        try {
            String sql = "select * from empresa";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ArrayList<Categoria> categorias = new ArrayList<>();
                String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                ps2.setInt(1, rs.getInt(1));
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    // Obtiene las categorías asociadas a la empresa
                    Categoria g = new Categoria(rs2.getInt(1), rs2.getString(3), rs2.getString(2));
                    categorias.add(g);
                }
                // Obtiene la imagen de la empresa y la convierte en un objeto Image
                Image img = new Image(rs.getBlob(7).getBinaryStream());
                // Crea un objeto Empresa y lo añade a la lista
                Empresa e = new Empresa(rs.getInt(1), rs.getInt(2), categorias, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8), img);
                lista.add(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    /**
     * Añade una nueva empresa a la base de datos.
     *
     * @param id_empresario      El ID del empresario dueño de la empresa.
     * @param em                 La empresa a añadir.
     * @param c                  La categoría asociada a la empresa.
     * @param imagenseleccionada La imagen de la empresa.
     * @return true si la operación se realizó con éxito, false en caso contrario.
     */
    public boolean anyadir_empresa(int id_empresario, Empresa em, Categoria c, File imagenseleccionada) {
        boolean resultado = false;

        try {
            String sql = "insert into empresa (id_empresario, nombre, cif,horario,ciudad,foto_empresa,direccion) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, id_empresario);
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getCIF());
            ps.setString(4, em.getHorario());
            ps.setString(5, em.getCiudad());
            FileInputStream fis = new FileInputStream(String.valueOf(imagenseleccionada));
            File f = new File(String.valueOf(imagenseleccionada));
            ps.setBinaryStream(6, fis, (int) f.length());
            ps.setString(7, em.getDireccion());
            ps.execute();

            // Obtiene el ID de la última empresa añadida
            String sql3 = "SELECT max(id_Empresa) FROM dailydates.empresa";
            PreparedStatement ps3 = this.getConexion().prepareStatement(sql3);
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                // Asocia la empresa con la categoría correspondiente
                String sql2 = "insert into pertenece (id_categoria,id_empresa) values (?,?)";
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

    /**
     * Elimina una empresa de la base de datos dado su ID.
     *
     * @param id El ID de la empresa a eliminar.
     * @return true si la empresa se eliminó correctamente, false en caso contrario.
     * @throws RuntimeException Si ocurre un error al ejecutar la consulta SQL.
     */
    public boolean eliminar_empresa(int id) {

        boolean resultado = false;
        try {
            // Consulta SQL para eliminar la empresa por su ID
            String sql = "delete from empresa where id_empresa = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            // Si la consulta se ejecuta correctamente, establecer el resultado como true
            resultado = true;
        } catch (SQLException e) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(e);
        }
        return resultado;
    }

    /**
     * Obtiene una lista de empresas pertenecientes a un empresario específico.
     *
     * @param id_empresario El ID del empresario del que se quieren listar las empresas.
     * @return Una lista de empresas pertenecientes al empresario.
     * @throws RuntimeException Si ocurre un error al ejecutar la consulta SQL.
     */
    public ArrayList<Empresa> listar_empresas_empresario(int id_empresario) {
        ArrayList<Empresa> lista = new ArrayList<>();

        try {
            // Consulta SQL para obtener las empresas del empresario por su ID
            String sql = "select * from empresa where id_empresario = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, id_empresario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Para cada empresa obtenida, se obtienen sus categorías
                ArrayList<Categoria> categorias = new ArrayList<>();
                String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                ps2.setInt(1, rs.getInt(1));
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {

                    Categoria g = new Categoria(rs2.getInt(1), rs2.getString(3), rs2.getString(2));
                    categorias.add(g);
                }
                // Se crea la instancia de la empresa con sus categorías y otros detalles
                // Aquí deberías tener una clase llamada Empresa, si no está definida,
                // deberías reemplazarla con la clase correspondiente.
                // Además, asumo que la clase Image proviene de algún paquete como javafx.scene.image
                // Si ese no es el caso, ajusta la importación según sea necesario.
                // Lo mismo ocurre con la clase Categoria.
                // También asumo que la columna de imagen es la séptima (índice 7 en base 1) en la tabla empresa.
                // Ajusta estos números si difieren en tu base de datos.
                // Si la imagen se almacena como un blob en la base de datos y se utiliza el constructor de Image adecuado,
                // entonces el código está bien.
                // Si la imagen se almacena como una cadena de texto en la base de datos y necesitas cargar la imagen de manera diferente,
                // entonces deberás ajustar esta parte del código en consecuencia.
                Image img = new Image(rs.getBlob(7).getBinaryStream());
                Empresa e = new Empresa(rs.getInt(1), rs.getInt(2), categorias, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8), img);
                lista.add(e);
            }
        } catch (SQLException e) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(e);
        }
        return lista;
    }

    /**
     * Obtiene una lista de empresas asociadas a una categoría específica.
     *
     * @param id_categoria El ID de la categoría de la que se quieren listar las empresas.
     * @return Una lista de empresas asociadas a la categoría.
     * @throws RuntimeException Si ocurre un error al ejecutar la consulta SQL.
     */
    public ArrayList<Empresa> listar_empresas_categoria(int id_categoria) {
        ArrayList<Empresa> lista = new ArrayList<>();

        try {
            // Consulta SQL para obtener las empresas asociadas a una categoría por su ID
            String sql = "select * from empresa where id_empresa in(select id_empresa from pertenece where id_categoria = ?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, id_categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ArrayList<Categoria> categorias = new ArrayList<>();
                String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                ps2.setInt(1, rs.getInt(1));
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    // Para cada empresa obtenida, se obtienen sus categorías
                    Categoria g = new Categoria(rs2.getInt(1), rs2.getString(3), rs2.getString(2));
                    categorias.add(g);
                }
                // Se crea la instancia de la empresa con sus categorías y otros detalles
                // Aquí deberías tener una clase llamada Empresa, si no está definida,
                // deberías reemplazarla con la clase correspondiente.
                // Además, asumo que la clase Image proviene de algún paquete como javafx.scene.image
                // Si ese no es el caso, ajusta la importación según sea necesario.
                // Lo mismo ocurre con la clase Categoria.
                // También asumo que la columna de imagen es la séptima (índice 7 en base 1) en la tabla empresa.
                // Ajusta estos números si difieren en tu base de datos.
                // Si la imagen se almacena como un blob en la base de datos y se utiliza el constructor de Image adecuado,
                // entonces el código está bien.
                // Si la imagen se almacena como una cadena de texto en la base de datos y necesitas cargar la imagen de manera diferente,
                // entonces deberás ajustar esta parte del código en consecuencia.
                Image img = new Image(rs.getBlob(7).getBinaryStream());
                Empresa e = new Empresa(rs.getInt(1), rs.getInt(2), categorias, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8), img);
                lista.add(e);
            }

        } catch (SQLException ex) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(ex);
        }

        return lista;
    }

    /**
     * Modifica los detalles de una empresa en la base de datos.
     *
     * @param em La empresa con los detalles modificados.
     * @return true si la modificación fue exitosa, false si ocurrió algún error.
     * @throws RuntimeException Si ocurre un error al ejecutar la consulta SQL.
     */
    public boolean modificar_empresa(Empresa em) {
        boolean resultado = false;
        try {
            // Consulta SQL para actualizar los detalles de una empresa por su ID
            String sql = "update empresa set nombre = ?, Horario = ?, ciudad = ?, direccion = ? where id_empresa = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Establecer los parámetros de la consulta con los valores de la empresa proporcionada
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getHorario());
            ps.setString(3, em.getCiudad());
            ps.setString(4, em.getDireccion());
            ps.setInt(5, em.getId_empresa());
            // Ejecutar la consulta SQL
            ps.execute();
            // Establecer el resultado como verdadero si la ejecución fue exitosa
            resultado = true;

        } catch (SQLException e) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(e);
        }
        return resultado;
    }

    /**
     * Obtiene una lista de empresas ubicadas en una ciudad específica.
     *
     * @param ciudad La ciudad de la que se desea obtener las empresas.
     * @return Una lista de empresas ubicadas en la ciudad especificada.
     * @throws RuntimeException Si ocurre un error al ejecutar la consulta SQL.
     */
    public ArrayList<Empresa> listar_empresas_ciudad(String ciudad) {

        ArrayList<Empresa> lista = new ArrayList<>();


        try {
            // Consulta SQL para seleccionar empresas por ciudad
            String sql = "select * from empresa where ciudad = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Establecer el parámetro de ciudad en la consulta SQL
            ps.setString(1, ciudad);
            ResultSet rs = ps.executeQuery();
            // Recorrer el resultado de la consulta y agregar empresas a la lista

            while (rs.next()) {
                ArrayList<Categoria> categorias = new ArrayList<>();
                // Consulta SQL para obtener las categorías de la empresa actual
                String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                ps2.setInt(1, rs.getInt(1));
                ResultSet rs2 = ps2.executeQuery();
                // Recorrer el resultado de la consulta de categorías y agregarlas a la lista
                while (rs2.next()) {
                    Categoria g = new Categoria(rs2.getInt(1), rs2.getString(3), rs2.getString(2));
                    categorias.add(g);
                }
                // Crear una instancia de Empresa con los datos de la consulta y agregarla a la lista
                Image img = new Image(rs.getBlob(7).getBinaryStream());
                Empresa e = new Empresa(rs.getInt(1), rs.getInt(2), categorias, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8), img);
                lista.add(e);
            }
        } catch (SQLException e) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(e);
        }
        return lista;
    }

    /**
     * Busca una empresa por su identificador único en la base de datos.
     *
     * @param id El identificador único de la empresa que se desea buscar.
     * @return La empresa encontrada, o null si no se encontró ninguna empresa con el ID especificado.
     * @throws RuntimeException Si ocurre un error al ejecutar la consulta SQL.
     */
    public Empresa buscar_empresa(int id) {
        Empresa e = null;
        try {
            // Consulta SQL para seleccionar una empresa por su ID
            String sql = "select * from empresa where id_empresa = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Establecer el parámetro del ID en la consulta SQL
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            // Recorrer el resultado de la consulta y crear una instancia de Empresa
            while (rs.next()) {

                ArrayList<Categoria> categorias = new ArrayList<>();
                // Consulta SQL para obtener las categorías de la empresa actual
                String sql2 = "select * from categoria where id_categoria in (select id_categoria from pertenece where id_empresa = ?)";
                PreparedStatement ps2 = this.getConexion().prepareStatement(sql2);
                ps2.setInt(1, rs.getInt(1));
                ResultSet rs2 = ps2.executeQuery();
                // Recorrer el resultado de la consulta de categorías y agregarlas a la lista
                while (rs2.next()) {

                    Categoria g = new Categoria(rs2.getInt(1), rs2.getString(3), rs2.getString(2));
                    categorias.add(g);
                }
                // Crear una instancia de Empresa con los datos de la consulta
                Image img = new Image(rs.getBlob(7).getBinaryStream());
                e = new Empresa(rs.getInt(1), rs.getInt(2), categorias, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8), img);
            }
        } catch (SQLException em) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(em);
        }
        return e;
    }

    /**
     * Añade una categoría a una empresa en la base de datos.
     *
     * @param id_categoria El identificador único de la categoría que se desea añadir.
     * @param id_empresa   El identificador único de la empresa a la que se desea añadir la categoría.
     * @return true si la categoría se añadió correctamente, false en caso contrario.
     * @throws RuntimeException Si ocurre un error al ejecutar la consulta SQL.
     */
    public boolean anyadir_categoria(int id_categoria, int id_empresa) {
        boolean resultado = false;
        try {
            // Consulta SQL para insertar una relación entre una categoría y una empresa
            String sql = "insert into pertenece values(?,?)";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Establecer los parámetros de la consulta SQL
            ps.setInt(1, id_categoria);
            ps.setInt(2, id_empresa);
            ps.execute();
            resultado = true;
        } catch (SQLException e) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(e);
        }
        return resultado;
    }

    /**
     * Elimina una categoría de una empresa en la base de datos.
     *
     * @param id_categoria El identificador único de la categoría que se desea eliminar.
     * @param id_empresa   El identificador único de la empresa de la que se desea eliminar la categoría.
     * @return true si la categoría se eliminó correctamente, false en caso contrario.
     * @throws RuntimeException Si ocurre un error al ejecutar la consulta SQL.
     */
    public boolean eliminar_categoria(int id_categoria, int id_empresa) {
        boolean resultado = false;
        try {
            // Consulta SQL para eliminar la relación entre una categoría y una empresa
            String sql = "delete from pertenece where id_categoria = ? and id_empresa = ?";
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            // Establecer los parámetros de la consulta SQL
            ps.setInt(1, id_categoria);
            ps.setInt(2, id_empresa);
            ps.execute();
            resultado = true;
        } catch (SQLException e) {
            // En caso de error, lanzar una excepción
            throw new RuntimeException(e);
        }
        return resultado;
    }





    public boolean comprobarHorario(Time horaCita, String Horahorario) {

        // Dividir el string en las dos partes separadas por '-'
        String[] partes = Horahorario.split("-");
// Obtener la parte de la hora antes de los dos puntos y convertirla a entero
        int horaInicio = Integer.parseInt(partes[0].split(":")[0]);
        int horaFin = Integer.parseInt(partes[1].split(":")[0]);

        Time t = new Time(horaInicio,00,00);
        Time t2 = new Time(horaFin,00,00);

        boolean resultado = false;


        if (horaCita.before(t2) && horaCita.after(t)) {
            resultado = true;
        }

        return resultado;
    }



}