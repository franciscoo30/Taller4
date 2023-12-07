package gui;

import data.GestorArtista;
import model.Artista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroArtista extends JFrame {
    private JTextField nombreTextField;
    private JTextField generoTextField;
    private JButton registrarButton;

    private GestorArtista gestorArtista;

    public VentanaRegistroArtista(GestorArtista gestorArtista) {
        this.gestorArtista = gestorArtista;

        // Configuración de la ventana
        setTitle("Registro de Artista");
        setSize(400, 200);
        // Cambiar el comportamiento de cierre al ocultar en lugar de cerrar
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Creación de componentes
        nombreTextField = new JTextField();
        generoTextField = new JTextField();
        registrarButton = new JButton("Registrar Artista");

        // Configuración del diseño
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nombre Artístico:"));
        add(nombreTextField);
        add(new JLabel("Género Musical:"));
        add(generoTextField);
        add(registrarButton);

        // Configuración de eventos
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarArtista();
            }
        });
    }

    private void registrarArtista() {
        String nombreArtistico = nombreTextField.getText();
        String generoMusical = generoTextField.getText();

        if (!nombreArtistico.isEmpty() && !generoMusical.isEmpty()) {
            Artista nuevoArtista = new Artista(nombreArtistico, generoMusical);
            gestorArtista.agregarArtista(nuevoArtista);

            JOptionPane.showMessageDialog(this, "Artista registrado exitosamente.");

            // Limpiar campos después de registrar
            nombreTextField.setText("");
            generoTextField.setText("");

            // Crear el archivo de artistas
            gestorArtista.crearArchivoDeArtistas();

            // Opcional: Ocultar la ventana en lugar de cerrarla
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}



