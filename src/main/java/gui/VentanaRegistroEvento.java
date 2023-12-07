package gui;

import data.GestorEvento;
import model.EventoMusical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaRegistroEvento extends JFrame {
    private JTextField nombreTextField;
    private JTextField fechaTextField;
    private JTextField lugarTextField;
    private JButton registrarButton;

    private GestorEvento gestorEvento;

    public VentanaRegistroEvento(GestorEvento gestorEvento) {
        this.gestorEvento = gestorEvento;

        // Configuración de la ventana
        setTitle("Registro de Evento");
        setSize(400, 200);
        // Cambiar el comportamiento de cierre al ocultar en lugar de cerrar
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Creación de componentes
        nombreTextField = new JTextField();
        fechaTextField = new JTextField();
        lugarTextField = new JTextField();
        registrarButton = new JButton("Registrar Evento");

        // Configuración del diseño
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nombre del Evento:"));
        add(nombreTextField);
        add(new JLabel("Fecha (yyyy-MM-dd):"));
        add(fechaTextField);
        add(new JLabel("Lugar:"));
        add(lugarTextField);
        add(registrarButton);

        // Configuración de eventos
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEvento();
            }
        });
    }

    private void registrarEvento() {
        String nombre = nombreTextField.getText();
        String fechaString = fechaTextField.getText();
        String lugar = lugarTextField.getText();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = dateFormat.parse(fechaString);

            EventoMusical nuevoEvento = new EventoMusical(nombre, fecha, lugar);
            gestorEvento.agregarEvento(nuevoEvento);

            JOptionPane.showMessageDialog(this, "Evento registrado exitosamente.");

            // Limpiar campos después de registrar
            nombreTextField.setText("");
            fechaTextField.setText("");
            lugarTextField.setText("");

            // Crear el archivo de eventos
            gestorEvento.crearArchivoDeEventos();

            // Opcional: Ocultar la ventana en lugar de cerrarla
            setVisible(false);
        } catch (ParseException | IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar el evento: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}



