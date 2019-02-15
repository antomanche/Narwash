package com.example.listview_narwash;

public class Evento {
    private String Titulo;
    private Double Latitud;
    private Double Longitud;
    public Evento() {
    }
    public Evento(String titulo, Double latitud, Double longitud) {
        Titulo = titulo;
        Latitud = latitud;
        Longitud = longitud;
    }

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
}
