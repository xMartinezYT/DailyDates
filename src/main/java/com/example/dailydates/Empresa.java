package com.example.dailydates;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Empresa {

    private int id_empresa;
    private int id_empresario;
    private ArrayList<Categoria> categorias;
    private String nombre;
    private String CIF;
    private String horario;
    private String ciudad;
    private String direccion;
    private Image foto_empresa;


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

    @Override
    public String toString() {
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
