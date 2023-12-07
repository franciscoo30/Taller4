package model;

public class Entrada {
    private String tipo;
    private double precio;
    private int disponibilidad;

    public Entrada(String tipo, double precio, int disponibilidad) {
        this.tipo = tipo;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public void anularEntrada() {
        // Implementar lógica de anulación de entrada
    }

    public void mostrarDetalles() {
        System.out.println("Tipo de Entrada: " + tipo);
        System.out.println("Precio: " + precio);
        System.out.println("Disponibilidad: " + disponibilidad);
    }
}

