package com.jstorra;

public class PartidoPlayOff extends Partido{
    private String ronda;

    public PartidoPlayOff(String equipoLocal, String equipoVisitante, String fechaPartido, String ronda) {
        super(equipoLocal, equipoVisitante, fechaPartido);
        this.ronda = ronda;
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda;
    }

    @Override
    public String mostrarPartido() {
        return "\nPartido{" +
                "equipoLocal=" + super.getEquipoLocal() + 
                ", equipoVisitante=" + super.getEquipoVisitante() + 
                ", cestasLocal=" + super.getCestasLocal() + 
                ", cestasVisitante=" + super.getCestasVisitante() + 
                ", finalizado=" + super.isFinalizado() + 
                ", ronda=" + this.ronda + 
                ", fechaPartido=" + super.getFechaPartido() + '}';
    }

    @Override
    public String obtenerGanador() {
        if (super.getCestasLocal() > super.getCestasVisitante() && super.isFinalizado()){
            return "Equipo local: " + super.getEquipoLocal();
        }else if(super.getCestasLocal() < super.getCestasVisitante() && super.isFinalizado()){
            return "Equipo visitante: " + super.getEquipoVisitante();
        }else{
            return "\nPartido no finalizado";
        }
    }

    @Override
    public boolean finalizarPartido() {
        if (super.getCestasLocal() == super.getCestasVisitante()) {
            return false;
        }else{
            super.setFinalizado(true);
            return true;
        }
    }
}