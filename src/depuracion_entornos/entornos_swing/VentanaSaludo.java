import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaSaludo extends JFrame {

    private DefaultComboBoxModel<String> nombresModel;
    private JComboBox<String> comboBox;

    public VentanaSaludo() {
        // Configuración de la ventana
        setTitle("Saluda!");
        setSize(700, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuración del panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));

        // Configuración del panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        // Configuración del panel inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());

        // Etiqueta y campo de texto
        JLabel etiquetaNombre = new JLabel("Nombre: ");
        JTextField campoNombre = new JTextField(15);

        // Botón de Saludo
        JButton botonSaludar = new JButton("Saluda");
        botonSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) comboBox.getSelectedItem();

                if (nombreSeleccionado != null) {
                    JOptionPane.showMessageDialog(VentanaSaludo.this, "¡Hola, " + nombreSeleccionado + "!", "Saludo", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(VentanaSaludo.this, "Introduce un nombre primero.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón para añadir nombres al comboBox
        JButton botonAgregarNombre = new JButton("Añadir");
        botonAgregarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoNombre = campoNombre.getText();

                if (!nuevoNombre.isEmpty()) {
                    nombresModel.addElement(nuevoNombre);
                    campoNombre.setText("");
                    JOptionPane.showMessageDialog(VentanaSaludo.this, "Se ha añadido el nombre: " + nuevoNombre, "Nombre Añadido", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(VentanaSaludo.this, "Por favor, ingresa un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ComboBox para los nombres
        nombresModel = new DefaultComboBoxModel<>();
        comboBox = new JComboBox<>(nombresModel);
        comboBox.setPreferredSize(new Dimension(120, 25));

        // Agregar componentes al panel superior
        panelSuperior.add(etiquetaNombre);
        panelSuperior.add(campoNombre);
        panelSuperior.add(comboBox);

        // Agregar componentes al panel inferior
        panelInferior.add(botonAgregarNombre);
        panelInferior.add(botonSaludar);

        // Agregar paneles al principal
        panelPrincipal.add(panelSuperior);
        panelPrincipal.add(panelInferior);

        // Agregar panel principal a la ventana
        add(panelPrincipal);

        //Centrar ventana
        setLocationRelativeTo(null);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase VentanaSaludo
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaSaludo();
            }
        });
    }
}