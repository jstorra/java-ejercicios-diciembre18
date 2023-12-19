package com.jstorra;

interface operaciones {
    String obtenerGanador();
    boolean finalizarPartido();
}

public abstract class Partido implements operaciones {
    private String equipoLocal, equipoVisitante, fechaPartido;
    private int cestasLocal, cestasVisitante;
    private boolean finalizado;

    public Partido(String equipoLocal, String equipoVisitante, String fechaPartido) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.cestasLocal = 0;
        this.cestasVisitante = 0;
        this.finalizado = false;
        this.fechaPartido = fechaPartido;
    }
    
    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        if (equipoLocal == null || equipoLocal.isBlank()) {
            System.out.println("\nERROR: Debe ingresar un equipo local.");
        } else {
            this.equipoLocal = equipoLocal;
        }
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        if (equipoVisitante == null || equipoVisitante.isBlank()) {
            System.out.println("\nERROR: Debe ingresar un equipo visitante.");
        } else {
            this.equipoVisitante = equipoVisitante;
        }
    }

    public int getCestasLocal() {
        return cestasLocal;
    }

    public void setCestasLocal(int cestasLocal) {
        this.cestasLocal = cestasLocal;
    }

    public int getCestasVisitante() {
        return cestasVisitante;
    }

    public void setCestasVisitante(int cestasVisitante) {
        this.cestasVisitante = cestasVisitante;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        if (finalizado != true && finalizado != false) {
            System.out.println("\nERROR: El valor ingresado no es válido.");
        } else {
            this.finalizado = finalizado;
        }
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        if (fechaPartido == null || fechaPartido.isBlank()) {
            System.out.println("\nERROR: Debe ingresar una fecha para el partido.");
        } else {
            this.fechaPartido = fechaPartido;
        }
    }

    abstract String mostrarPartido();
    
    public String obtenerResultado() {
        return this.getEquipoLocal() + " " + this.getCestasLocal() +
                " - " + this.getEquipoVisitante() + " " + this.getCestasVisitante();
    }
}