package es.fplumara.dam1.museo;

import java.time.LocalDate;

public class EntradaVIP extends Entrada implements Descontable,ConAccesoRapido{   
private String zonaVIP;

    private int nivelPrioridad;

    public EntradaVIP(String id, double precioBase, LocalDate fecha, String zonaVIP, int nivelPrioridad) {
        super(id, precioBase, fecha);
        this.zonaVIP = zonaVIP;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getZonaVIP() {
        return zonaVIP;
    }

    public void setZonaVIP(String zonaVIP) {
        this.zonaVIP = zonaVIP;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    @Override
    public int prioridadAcceso() {
        return 0;
    }

    @Override
    public double aplicarDescuento(double cantidad) {
        return 0;
    }

    @Override
    double precioFinal() {
        return 0;
    }

    @Override
    String descripcion() {
        return "";
    }
}