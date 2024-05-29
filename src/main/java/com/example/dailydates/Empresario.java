package com.example.dailydates;

import javafx.scene.image.Image;

/**
 * La clase Empresario representa a un empresario en la aplicación.
 * Contiene información personal y de contacto del empresario.
 */
public class Empresario {

    private int id;
    private String nombre;
    private String apellidos;
    private String gmail;
    private String contrasenya;
    private String telefono;
    private Image foto_perfil;


    /**
     * Constructor que inicializa un nuevo objeto Empresario con todos los detalles.
     *
     * @param id           el identificador único del empresario
     * @param nombre       el nombre del empresario
     * @param apellidos    los apellidos del empresario
     * @param gmail        el correo electrónico del empresario
     * @param contrasenya  la contraseña del empresario
     * @param telefono     el número de teléfono del empresario
     * @param fotoPerfil   la imagen de perfil del empresario
     */
    public Empresario(int id, String nombre, String apellidos, String gmail, String contrasenya, String telefono, Image fotoPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.gmail = gmail;
        this.contrasenya = contrasenya;
        this.telefono = telefono;
        foto_perfil = fotoPerfil;
    }
    /**
     * Constructor vacío.
     */
    public Empresario() {
    }

    /**
     * Obtiene el identificador único del empresario.
     *
     * @return el identificador del empresario
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del empresario.
     *
     * @param id el identificador del empresario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empresario.
     *
     * @return el nombre del empresario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empresario.
     *
     * @param nombre el nombre del empresario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del empresario.
     *
     * @return los apellidos del empresario
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del empresario.
     *
     * @param apellidos los apellidos del empresario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico del empresario.
     *
     * @return el correo electrónico del empresario
     */
    public String getGmail() {
        return gmail;
    }

    /**
     * Establece el correo electrónico del empresario.
     *
     * @param gmail el correo electrónico del empresario
     */
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    /**
     * Obtiene la contraseña del empresario.
     *
     * @return la contraseña del empresario
     */
    public String getContrasenya() {
        return contrasenya;
    }

    /**
     * Establece la contraseña del empresario.
     *
     * @param contrasenya la contraseña del empresario
     */
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    /**
     * Obtiene el número de teléfono del empresario.
     *
     * @return el número de teléfono del empresario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del empresario.
     *
     * @param telefono el número de teléfono del empresario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la imagen de perfil del empresario.
     *
     * @return la imagen de perfil del empresario
     */
    public Image getFoto_perfil() {
        return foto_perfil;
    }

    /**
     * Establece la imagen de perfil del empresario.
     *
     * @param foto_perfil la imagen de perfil del empresario
     */
    public void setFoto_perfil(Image foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    /**
     * Devuelve una representación en cadena del objeto Empresario.
     *
     * @return una cadena que representa al empresario
     */
    @Override
    public String toString() {
        return "Empresario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }

}


