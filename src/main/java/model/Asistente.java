package model;

public class Asistente {
    private String nombre;
    private String rut;
    private String numeroTelefonico;
    private String preferenciasMusicales;

    public Asistente(String nombre, String rut, String numeroTelefonico, String preferenciasMusicales) {
        this.nombre = nombre;
        this.rut = rut;
        this.numeroTelefonico = numeroTelefonico;
        this.preferenciasMusicales = preferenciasMusicales;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public String getPreferenciasMusicales() {
        return preferenciasMusicales;
    }
}


