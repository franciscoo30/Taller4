package data;

import model.EventoMusical;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorEvento {
    private List<EventoMusical> eventos;

    public GestorEvento() {
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(EventoMusical evento) {
        eventos.add(evento);
    }

    // Método para crear archivos de texto con la información de los eventos
    public void crearArchivoDeEventos() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fechaActual = dateFormat.format(new Date());

        String nombreArchivo = "eventos_" + fechaActual + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (EventoMusical evento : eventos) {
                // Escribir información del evento en el archivo
                writer.println("Nombre del Evento: " + evento.getNombre());
                writer.println("Fecha: " + evento.getFecha());
                writer.println("Lugar: " + evento.getLugar());
                // Puedes agregar más información según sea necesario
                writer.println();
            }

            System.out.println("Archivo de eventos creado exitosamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de eventos: " + e.getMessage());
        }
    }
}


