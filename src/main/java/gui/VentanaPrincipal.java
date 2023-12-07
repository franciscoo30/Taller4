package gui;

import data.GestorArtista;
import data.GestorAsistente;
import data.GestorEvento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JButton btnRegistrarEvento;
    private JButton btnRegistrarArtista;
    private JButton btnRegistrarAsistente;

    private GestorEvento gestorEvento;
    private GestorArtista gestorArtista;
    private GestorAsistente gestorAsistente;

    public VentanaPrincipal(GestorEvento gestorEvento, GestorArtista gestorArtista, GestorAsistente gestorAsistente) {
        this.gestorEvento = gestorEvento;
        this.gestorArtista = gestorArtista;
        this.gestorAsistente = gestorAsistente;

        // Configuración de la ventana principal
        setTitle("Ventana Principal");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de componentes
        btnRegistrarEvento = new JButton("Registrar Evento");
        btnRegistrarArtista = new JButton("Registrar Artista");
        btnRegistrarAsistente = new JButton("Registrar Asistente");

        // Configuración del diseño
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(btnRegistrarEvento);
        add(btnRegistrarArtista);
        add(btnRegistrarAsistente);

        // Configuración de eventos
        btnRegistrarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistroEvento();
            }
        });

        btnRegistrarArtista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistroArtista();
            }
        });

        btnRegistrarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaRegistroAsistente();
            }
        });
    }

    private void abrirVentanaRegistroEvento() {
        VentanaRegistroEvento ventanaRegistroEvento = new VentanaRegistroEvento(gestorEvento);
        ventanaRegistroEvento.setVisible(true);
    }

    private void abrirVentanaRegistroArtista() {
        VentanaRegistroArtista ventanaRegistroArtista = new VentanaRegistroArtista(gestorArtista);
        ventanaRegistroArtista.setVisible(true);
    }

    private void abrirVentanaRegistroAsistente() {
        VentanaRegistroAsistente ventanaRegistroAsistente = new VentanaRegistroAsistente(gestorAsistente);
        ventanaRegistroAsistente.setVisible(true);
    }
}




