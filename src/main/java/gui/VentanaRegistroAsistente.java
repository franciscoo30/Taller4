package gui;

import data.GestorAsistente;
import model.Asistente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroAsistente extends JFrame {
    private JTextField nombreTextField;
    private JTextField rutTextField;
    private JTextField telefonoTextField;
    private JTextField preferenciasTextField;
    private JButton registrarButton;

    private GestorAsistente gestorAsistente;

    public VentanaRegistroAsistente(GestorAsistente gestorAsistente) {
        this.gestorAsistente = gestorAsistente;

        // Configuración de la ventana
        setTitle("Registro de Asistente");
        setSize(400, 250);
        // Cambiar el comportamiento de cierre al ocultar en lugar de cerrar
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Creación de componentes
        nombreTextField = new JTextField();
        rutTextField = new JTextField();
        telefonoTextField = new JTextField();
        preferenciasTextField = new JTextField();
        registrarButton = new JButton("Registrar Asistente");

        // Configuración del diseño
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nombre:"));
        add(nombreTextField);
        add(new JLabel("RUT:"));
        add(rutTextField);
        add(new JLabel("Número Telefónico:"));
        add(telefonoTextField);
        add(new JLabel("Preferencias Musicales:"));
        add(preferenciasTextField);
        add(registrarButton);

        // Configuración de eventos
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarAsistente();
            }
        });
    }

    private void registrarAsistente() {
        String nombre = nombreTextField.getText();
        String rut = rutTextField.getText();
        String numeroTelefonico = telefonoTextField.getText();
        String preferenciasMusicales = preferenciasTextField.getText();

        if (!nombre.isEmpty() && !rut.isEmpty() && !numeroTelefonico.isEmpty() && !preferenciasMusicales.isEmpty()) {
            Asistente nuevoAsistente = new Asistente(nombre, rut, numeroTelefonico, preferenciasMusicales);
            gestorAsistente.agregarAsistente(nuevoAsistente);

            JOptionPane.showMessageDialog(this, "Asistente registrado exitosamente.");

            // Limpiar campos después de registrar
            nombreTextField.setText("");
            rutTextField.setText("");
            telefonoTextField.setText("");
            preferenciasTextField.setText("");

            // Crear el archivo de asistentes
            gestorAsistente.crearArchivoDeAsistentes();

            // Opcional: Ocultar la ventana en lugar de cerrarla
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


