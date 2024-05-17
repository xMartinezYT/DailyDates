package com.example.dailydates;

import javafx.scene.control.DatePicker;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Citas {

    private int id_usuario;
    private int id_empresa;
    private LocalDate fecha;
    private Time hora;
    private String pedido;

    public Citas(int id_usuario, int id_empresa, LocalDate fecha, Time hora, String pedido) {
        this.id_usuario = id_usuario;
        this.id_empresa = id_empresa;
        this.fecha = fecha;
        this.hora = hora;
        this.pedido = pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Citas{" +
                "fecha=" + fecha +
                ", hora=" + hora +
                ", pedido='" + pedido + '\'' +
                '}';
    }

}
