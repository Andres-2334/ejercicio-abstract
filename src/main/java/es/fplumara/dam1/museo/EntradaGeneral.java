package es.fplumara.dam1.museo;

import java.time.LocalDate;

public class EntradaGeneral extends Entrada{
    public EntradaGeneral(String id, double precioBase, LocalDate fecha) {
        super(id, precioBase, fecha);
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