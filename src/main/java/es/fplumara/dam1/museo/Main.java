package es.fplumara.dam1.museo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Entrada> entradas = new ArrayList<>();

        entradas.add(new EntradaGeneral("E-001", 12.0, LocalDate.of(2026, 1, 10)));
        entradas.add(new EntradaGeneral("E-002", 12.0, LocalDate.of(2026, 1, 10)));

        entradas.add(new EntradaEstudiante("E-010", 10.0, LocalDate.of(2026, 1, 11), "IES Laguna"));
        entradas.add(new EntradaEstudiante("E-011", 10.0, LocalDate.of(2026, 1, 11), "IES Lagomar"));

        entradas.add(new EntradaVIP("E-100", 20.0, LocalDate.of(2026, 1, 12), "Sala Impresionistas", 3));
        entradas.add(new EntradaVIP("E-101", 25.0, LocalDate.of(2026, 1, 12), "Backstage exposición", 5));
        double preciofinal = 0;
        for(Entrada entrada : entradas) {
            preciofinal += entrada.getPrecioBase();
        }





        System.out.println("Precio final: " + preciofinal);



    }

}