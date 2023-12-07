package model;

import java.util.ArrayList;
import java.util.List;

public class Asistente {
    private String informacion;
    private List<Entrada> entradasCompradas;

    public Asistente(String informacion) {
        this.informacion = informacion;
        this.entradasCompradas = new ArrayList<>();
    }

    public void comprarEntrada(Entrada entrada) {
        entradasCompradas.add(entrada);
    }

    public void cancelarAsistencia() {
        // Implementar lógica de cancelación de asistencia
    }
}

