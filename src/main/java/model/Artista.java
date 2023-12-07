package model;
public class Artista {
    private String nombreArtistico;
    private String generoMusical;

    public Artista(String nombreArtistico, String generoMusical) {
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void mostrarInformacion() {
        System.out.println("Artista: " + nombreArtistico);
        System.out.println("Género Musical: " + generoMusical);
    }
}

