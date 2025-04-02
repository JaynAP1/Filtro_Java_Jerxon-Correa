package org.example.misiones;

public class misiones {
    int id;
    String descripcion;
    String rango;
    int recompensa;
    String fecha_inicio;
    String fecha_final;
    int id_ninja;

    public misiones(int id, String descripcion, String rango, int recompensa) {
        this.id = id;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;
    }

    public misiones(int id, int id_ninja, String descripcion, String fecha_inicio, String fecha_final) {
        this.id = id;
        this.id_ninja = id_ninja;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getId_ninja() {
        return id_ninja;
    }

    public void setId_ninja(int id_ninja) {
        this.id_ninja = id_ninja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }
}
