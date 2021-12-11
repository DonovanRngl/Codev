package com.example.proyectov2.models;

import android.content.Intent;

import java.io.Serializable;

public class modelo implements Serializable {
    private String Nombre;
    private Intent Accion;

    public modelo(String nombre, Intent accion) {
        Nombre = nombre;
        this.Accion = accion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nomnbre) {
        Nombre = nomnbre;
    }

    public Intent getAccion() {
        return Accion;
    }

    public void setAccion(Intent accion) {
        Accion = accion;
    }
}