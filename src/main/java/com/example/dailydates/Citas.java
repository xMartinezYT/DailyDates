package com.example.dailydates;

import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Esta clase representa una cita entre un usuario y una empresa, incluyendo la fecha, la hora y el pedido.
 */

public class Citas {

    // Identificador del usuario que solicita la cita
    private int id_usuario;

    // Identificador de la empresa con la que se tiene la cita
    private int id_empresa;

    // Fecha de la cita
    private LocalDate fecha;

    // Hora de la cita
    private Time hora;


    // Descripción del pedido o servicio solicitado
    private String pedido;

    /**
     * Constructor de la clase Citas.
     *
     * @param id_usuario Identificador del usuario que solicita la cita
     * @param id_empresa Identificador de la empresa con la que se tiene la cita
     * @param fecha Fecha de la cita
     * @param hora Hora de la cita
     * @param pedido Descripción del pedido o servicio solicitado
     */

    public Citas(int id_usuario, int id_empresa, LocalDate fecha, Time hora, String pedido) {
        this.id_usuario = id_usuario;
        this.id_empresa = id_empresa;
        this.fecha = fecha;
        this.hora = hora;
        this.pedido = pedido;
    }

    /**
     * Obtiene el identificador del usuario que solicita la cita.
     *
     * @return el identificador del usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Establece el identificador del usuario que solicita la cita.
     *
     * @param id_usuario el nuevo identificador del usuario
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * Obtiene el identificador de la empresa con la que se tiene la cita.
     *
     * @return el identificador de la empresa
     */
    public int getId_empresa() {
        return id_empresa;
    }

    /**
     * Establece el identificador de la empresa con la que se tiene la cita.
     *
     * @param id_empresa el nuevo identificador de la empresa
     */
    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    /**
     * Obtiene la fecha de la cita.
     *
     * @return la fecha de la cita
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la cita.
     *
     * @param fecha la nueva fecha de la cita
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la cita.
     *
     * @return la hora de la cita
     */
    public Time getHora() {
        return hora;
    }

    /**
     * Establece la hora de la cita.
     *
     * @param hora la nueva hora de la cita
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la descripción del pedido o servicio solicitado.
     *
     * @return la descripción del pedido
     */
    public String getPedido() {
        return pedido;
    }

    /**
     * Establece la descripción del pedido o servicio solicitado.
     *
     * @param pedido la nueva descripción del pedido
     */
    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto.
     * Incluye la fecha, la hora y el pedido.
     *
     * @return una cadena que representa la cita
     */
    @Override
    public String toString() {
        return "Citas{" +
                "fecha=" + fecha +
                ", hora=" + hora +
                ", pedido='" + pedido + '\'' +
                '}';
    }

}
