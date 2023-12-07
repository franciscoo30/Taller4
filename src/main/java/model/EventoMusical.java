package model;

import java.util.Date;
import java.util.List;

public class EventoMusical {
    private String nombre;
    private Date fecha;
    private String lugar;
    private List<Artista> artistas;
    private List<Entrada> entradas;

    public EventoMusical(String nombre, Date fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        // Inicializar artistas y entradas según sea necesario
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void agregarArtista(Artista artista) {
        artistas.add(artista);
    }

    public void agregarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public void cancelarEvento() {
        // Implementar lógica de cancelación del evento
    }

    public void mostrarDetalles() {
        System.out.println("Evento: " + nombre);
        System.out.println("Fecha: " + fecha);
        System.out.println("Lugar: " + lugar);
        System.out.println("Artistas:");
        for (Artista artista : artistas) {
            System.out.println("- " + artista.getNombreArtistico());
        }
    }
}





