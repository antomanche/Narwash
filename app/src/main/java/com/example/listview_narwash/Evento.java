package com.example.listview_narwash;

public class Evento {
    private String Descripcion;
    private String Titulo;
    private Double Latitud;
    private Double Longitud;

    public Evento() {
    }

    public Evento(String descripcion, String titulo, Double latitud, Double longitud) {
        this.Descripcion = descripcion;
        Titulo = titulo;
        Latitud = latitud;
        Longitud = longitud;
    }

    public String getDescripcion() { return Descripcion; }

    public String getTitulo() {
        return Titulo;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
