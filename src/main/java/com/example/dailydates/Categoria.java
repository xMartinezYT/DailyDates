package com.example.dailydates;

/**
 * Esta clase representa una categoría con un identificador, un nombre y una descripción.
 */

public class Categoria {

    // Identificador único de la categoría
    private int id;

    // Nombre de la categoría
    private String nombre;

    // Descripción de la categoría
    private String descripcion;

    /**
     * Constructor de la clase Categoria.
     *
     * @param id el identificador de la categoría
     * @param nombre el nombre de la categoría
     * @param descripcion la descripción de la categoría
     */

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


    /**
     * Obtiene el identificador de la categoría.
     *
     * @return el identificador de la categoría
     */

    public int getId() {
        return id;
    }

    /**
     * Establece el identificador de la categoría.
     *
     * @param id el nuevo identificador de la categoría
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return el nombre de la categoría
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombre el nuevo nombre de la categoría
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción de la categoría.
     *
     * @return la descripción de la categoría
     */

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la categoría.
     *
     * @param descripcion la nueva descripción de la categoría
     */

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto.
     * En este caso, se devuelve el nombre de la categoría.
     *
     * @return el nombre de la categoría
     */

    @Override
    public String toString() {
        return nombre;
    }
}
