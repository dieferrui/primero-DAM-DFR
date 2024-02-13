import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConSaludo extends JFrame {

    private JTextField textField;

    public VentanaConSaludo() {

        super("Ventana de saludo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Componentes
        JLabel label = new JLabel("Introduce tu nombre: ");
        textField = new JTextField(20);
        JButton saludarButton = new JButton("Saluda!");

        // Action listener para el botón de saludo
        saludarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = textField.getText();
                JOptionPane.showMessageDialog(VentanaConSaludo.this, "Hola, " + nombre + "!");

            }
        });

        setLayout(new FlowLayout());

        // Añadir componentes a la ventana
        add(label);
        add(textField);
        add(saludarButton);

        // Dimensiones, visibilidad
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Instancia de la ventana
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaConSaludo();
            }
        });
    }
}

