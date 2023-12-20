package com.jstorra.ejercicio2;

public class Pelicula {
    private int id;
    private String titulo, director, genero;
    private boolean isEspecial;
    private double precioAlquiler, descuento;
    
    public Pelicula(int id, String titulo, String director, String genero, boolean isEspecial, double precioAlquiler, double descuento) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.isEspecial = isEspecial;
        this.precioAlquiler = precioAlquiler;
        this.descuento = descuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEspecial() {
        return isEspecial;
    }

    public void setEspecial(boolean especial) {
        isEspecial = especial;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler - (precioAlquiler * descuento);
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String mostrarInformacion() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo +
                ", director='" + director +
                ", genero='" + genero +
                ", isEspecial=" + isEspecial +
                ", precioAlquiler=" + precioAlquiler +
                ", descuento=" + descuento +
                '}';
    }
}