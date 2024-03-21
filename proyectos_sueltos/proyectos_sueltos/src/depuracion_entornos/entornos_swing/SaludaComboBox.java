import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaludaComboBox extends JFrame {
    private JTextField textField;
    private JComboBox<String> comboBox;

    public SaludaComboBox() {

        super("Saludar con ComboBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Componentes
        JLabel label = new JLabel("Introduce tu nombre:");
        textField = new JTextField(20);
        JButton anadirBoton = new JButton("Añadir...");
        JButton saludarBoton = new JButton("Saluda!");
        comboBox = new JComboBox<>();

        // Action Listener
        anadirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                comboBox.addItem(nombre);
                textField.setText(""); // Netegem el camp de text després d'afegir el nombre al ComboBox
            }
        });

        // Afegir un ActionListener al botó "Saludar"
        saludarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePuntero = (String) comboBox.getSelectedItem();
                if (nombrePuntero != null) {
                    JOptionPane.showMessageDialog(SaludaComboBox.this, "Salu2, " + nombrePuntero + ".");
                } else {
                    JOptionPane.showMessageDialog(SaludaComboBox.this, "No has seleccionado ningún nombre.");
                }
            }
        });

        // Configurar el layout
        setLayout(new FlowLayout());

        // Añadir componentes
        add(label);
        add(textField);
        add(anadirBoton);
        add(comboBox);
        add(saludarBoton);

        // Dimensiones, posición
        setSize(350, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SaludaComboBox();
            }
        });
    }
}
