package com.jstorra.ejercicio1;

public class PartidoLiga extends Partido{
    private int jornada;

    public PartidoLiga(String equipoLocal, String equipoVisitante, String fechaPartido, int jornada) {
        super(equipoLocal, equipoVisitante, fechaPartido);
        this.jornada = jornada;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }
    
    @Override
    String mostrarPartido() {
        return "\nPartido{" +
                "equipoLocal=" + super.getEquipoLocal() + 
                ", equipoVisitante=" + super.getEquipoVisitante() + 
                ", cestasLocal=" + super.getCestasLocal() + 
                ", cestasVisitante=" + super.getCestasVisitante() + 
                ", finalizado=" + super.isFinalizado() + 
                ", jornada=" + this.jornada + 
                ", fechaPartido=" + super.getFechaPartido() + '}';
    }

    @Override
    public String obtenerGanador() {
        if (super.getCestasLocal() > super.getCestasVisitante() && super.isFinalizado()){
            return "Equipo local: " + super.getEquipoLocal();
        }else if(super.getCestasLocal() < super.getCestasVisitante() && super.isFinalizado()){
            return "Equipo visitante: " + super.getEquipoVisitante();
        }else if (super.getCestasLocal() == super.getCestasVisitante() && super.isFinalizado()) {
            return "\nEmpate";
        } else{
            return "\nPartido no finalizado";
        }
    }

    @Override
    public boolean finalizarPartido() {
        super.setFinalizado(true);
        return true;
    }
}