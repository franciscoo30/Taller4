package main;

import data.GestorArtista;
import data.GestorAsistente;
import data.GestorEvento;
import gui.VentanaPrincipal;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                iniciarAplicacion();
            }
        });
    }

    private static void iniciarAplicacion() {
        GestorEvento gestorEvento = new GestorEvento();
        GestorArtista gestorArtista = new GestorArtista();
        GestorAsistente gestorAsistente = new GestorAsistente();

        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(gestorEvento, gestorArtista, gestorAsistente);
        ventanaPrincipal.setVisible(true);
    }
}



