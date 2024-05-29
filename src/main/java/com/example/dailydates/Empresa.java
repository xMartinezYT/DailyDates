package com.example.dailydates;

import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * La clase Empresa representa una empresa en la aplicación.
 */
public class Empresa {

    // Atributos de la empresa
    private int id_empresa;     // Identificador único de la empresa
    private int id_empresario;      // Identificador único del empresario dueño de la empresa
    private ArrayList<Categoria> categorias;    // Lista de categorías a las que pertenece la empresa
    private String nombre;      // Nombre de la empresa
    private String CIF;     // Código de Identificación Fiscal de la empresa
    private String horario;     // Horario de la empresa
    private String ciudad;      // Ciudad donde se encuentra la empresa
    private String direccion;       // Dirección de la empresa
    private Image foto_empresa;     // Foto de la empresa


    /**
     * Constructor de la clase Empresa.
     *
     * @param id_empresa     El ID de la empresa.
     * @param id_empresario  El ID del empresario dueño de la empresa.
     * @param categorias     La lista de categorías a las que pertenece la empresa.
     * @param nombre         El nombre de la empresa.
     * @param CIF            El CIF de la empresa.
     * @param horario        El horario de la empresa.
     * @param ciudad         La ciudad donde se encuentra la empresa.
     * @param direccion      La dirección de la empresa.
     * @param foto_empresa   La foto de la empresa.
     */
    public Empresa(int id_empresa, int id_empresario, ArrayList<Categoria> categorias, String nombre, String CIF, String horario, String ciudad, String direccion, Image foto_empresa) {
        this.id_empresa = id_empresa;
        this.id_empresario = id_empresario;
        this.categorias = categorias;
        this.nombre = nombre;
        this.CIF = CIF;
        this.horario = horario;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.foto_empresa = foto_empresa;
    }


    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_empresario() {
        return id_empresario;
    }

    public void setId_empresario(int id_empresario) {
        this.id_empresario = id_empresario;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Image getFoto_empresa() {
        return foto_empresa;
    }

    public void setFoto_empresa(Image foto_empresa) {
        this.foto_empresa = foto_empresa;
    }

    // Métodos getters y setters para acceder y modificar los atributos de la empresa
    @Override
    public String toString() {

        // Método para obtener una representación en cadena de la empresa
        return "Empresa{" +
                "id_empresa=" + id_empresa +
                ", id_empresario=" + id_empresario +
                ", categorias=" + categorias +
                ", nombre='" + nombre + '\'' +
                ", CIF='" + CIF + '\'' +
                ", horario='" + horario + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", foto_empresa=" + foto_empresa +
                '}';
    }
}
