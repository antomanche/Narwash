package com.antonio.listview_narwash;

public class Evento {
    private String descripcion;
    private String titulo;
    private Double latitud;
    private Double longitud;

    public Evento() {
    }

    public Evento(String descripcion, String titulo, Double latitud, Double longitud) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
