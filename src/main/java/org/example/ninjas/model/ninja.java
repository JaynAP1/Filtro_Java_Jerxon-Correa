package org.example.ninjas.model;

import java.util.ArrayList;

public class ninja {
    int id;
    String nombre;
    String rango;
    String aldea;

    public ninja(int id, String nombre, String rango,String aldea) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
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

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    @Override
    public String toString() {
        return "ninja{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rango='" + rango + '\'' +
                ", aldea='" + aldea + '\'' +
                '}';
    }
}
