import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio3 extends JFrame {
    private JTextField textField;
    private JComboBox<String> comboBox;

    public Ejercicio3() {
        super("Saludar con ComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear els components
        JLabel label = new JLabel("Introdueix el teu nom:");
        textField = new JTextField(20);
        JButton afegirButton = new JButton("Afegir al ComboBox");
        JButton saludarButton = new JButton("Saludar");
        comboBox = new JComboBox<>();

        // Afegir un ActionListener al botó "Afegir al ComboBox"
        afegirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textField.getText();
                comboBox.addItem(nom);
                textField.setText(""); // Netegem el camp de text després d'afegir el nom al ComboBox
            }
        });

        // Afegir un ActionListener al botó "Saludar"
        saludarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomSeleccionat = (String) comboBox.getSelectedItem();
                if (nomSeleccionat != null) {
                    JOptionPane.showMessageDialog(Ejercicio3.this, "Hola, " + nomSeleccionat + "!");
                } else {
                    JOptionPane.showMessageDialog(Ejercicio3.this, "No hi ha cap nom seleccionat!");
                }
            }
        });

        // Configurar el layout
        setLayout(new FlowLayout());

        // Afegir els components a la finestra
        add(label);
        add(textField);
        add(afegirButton);
        add(comboBox);
        add(saludarButton);

        // Establir les dimensions i fer visible la finestra
        setSize(350, 150);
        setLocationRelativeTo(null); // Centrar la finestra
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear una instància de la classe SaludarConComboBox
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ejercicio3();
            }
        });
    }
}
