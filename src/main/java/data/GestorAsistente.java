package data;

import model.Asistente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorAsistente {
    private List<Asistente> asistentes;

    public GestorAsistente() {
        this.asistentes = new ArrayList<>();
    }

    public void agregarAsistente(Asistente asistente) {
        asistentes.add(asistente);
    }

    // Método para crear archivos de texto con la información de los asistentes
    public void crearArchivoDeAsistentes() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fechaActual = dateFormat.format(new Date());

        String nombreArchivo = "asistentes_" + fechaActual + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Asistente asistente : asistentes) {
                // Escribir información del asistente en el archivo
                writer.println("Nombre: " + asistente.getNombre());
                writer.println("RUT: " + asistente.getRut());
                writer.println("Número Telefónico: " + asistente.getNumeroTelefonico());
                writer.println("Preferencias Musicales: " + asistente.getPreferenciasMusicales());
                // Puedes agregar más información según sea necesario
                writer.println();
            }

            System.out.println("Archivo de asistentes creado exitosamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de asistentes: " + e.getMessage());
        }
    }
}


