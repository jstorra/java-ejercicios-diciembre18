package com.jstorra.ejercicio2;

public class Cliente {
    private String nombre, correo, numeroCelular;

    public Cliente(String nombre, String correo, String numeroCelular) {
        this.nombre = nombre;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String mostrarInformacion() {
        return "Cliente{" +
                "nombre='" + nombre +
                ", correo='" + correo +
                ", numeroCelular='" + numeroCelular +
                '}';
    }
}
