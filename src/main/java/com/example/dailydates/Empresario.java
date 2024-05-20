package com.example.dailydates;

import javafx.scene.image.Image;

public class Empresario {

    private int id;
    private String nombre;
    private String apellidos;
    private String gmail;
    private String contrasenya;
    private String telefono;
    private Image foto_perfil;



    public Empresario(int id, String nombre, String apellidos, String gmail, String contrasenya, String telefono, Image fotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.gmail = gmail;
        this.contrasenya = contrasenya;
        this.telefono = telefono;
        foto_perfil = fotoPerfil;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Image getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(Image foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    @Override
    public String toString() {
        return "Empresario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }



}
