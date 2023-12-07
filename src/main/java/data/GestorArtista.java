package data;

import model.Artista;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorArtista {
    private List<Artista> artistas;

    public GestorArtista() {
        this.artistas = new ArrayList<>();
    }

    public void agregarArtista(Artista artista) {
        artistas.add(artista);
    }

    // Método para crear archivos de texto con la información de los artistas
    public void crearArchivoDeArtistas() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fechaActual = dateFormat.format(new Date());

        String nombreArchivo = "artistas_" + fechaActual + ".txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Artista artista : artistas) {
                // Escribir información del artista en el archivo
                writer.println("Nombre Artístico: " + artista.getNombreArtistico());
                writer.println("Género Musical: " + artista.getGeneroMusical());
                // Puedes agregar más información según sea necesario
                writer.println();
            }

            System.out.println("Archivo de artistas creado exitosamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de artistas: " + e.getMessage());
        }
    }
}


