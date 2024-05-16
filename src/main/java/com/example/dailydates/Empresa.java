package com.example.dailydates;

public class Empresa {

    private int id_empresa;
    private int id_empresario;
    private Categoria categoria;
    private String nombre;
    private String CIF;
    private String horario;
    private String ciudad;
    private String direccion;


    public Empresa(int id_empresa, int id_empresario, Categoria categoria, String nombre, String CIF, String horario, String ciudad, String direccion) {
        this.id_empresa = id_empresa;
        this.id_empresario = id_empresario;
        this.categoria = categoria;
        this.nombre = nombre;
        this.CIF = CIF;
        this.horario = horario;
        this.ciudad = ciudad;
        this.direccion = direccion;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    @Override
    public String toString() {
        return "Empresa{" +
                "categoria=" + categoria +
                ", nombre='" + nombre + '\'' +
                ", CIF='" + CIF + '\'' +
                ", horario='" + horario + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
