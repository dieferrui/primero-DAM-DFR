import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioInscripcion extends JPanel {

    private JTextField nombreTextField;
    private JSpinner edadSpinner;
    private JComboBox<String> provinciaComboBox;
    private JRadioButton hombreRadioButton;
    private JRadioButton mujerRadioButton;
    private JRadioButton otroRadioButton;
    private JCheckBox publicidadCheckBox;
    private JButton enviarButton;
    private ButtonGroup sexoGroup;

    public FormularioInscripcion() {

        // Usamos un grid layout al ser más conveniente
        setLayout(new GridLayout(7, 1, 5, 5));

        // Añadir componentes
        JLabel label = new JLabel("Formulario inscripción");
        label.setFont(new Font("Calibri", Font.BOLD, 18));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        // Panel del nombre y edad
        JPanel panelPrimero = new JPanel(new GridLayout(1, 2, 5, 5));

        // Casilla del nombre
        nombreTextField = new JTextField(20);
        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nombrePanel.add(new JLabel("Nombre: "));
        nombrePanel.add(nombreTextField);
        panelPrimero.add(nombrePanel);

        // Spinner para edad
        SpinnerModel spinnerEdad = new SpinnerNumberModel(18, 18, 99, 1);
        edadSpinner = new JSpinner(spinnerEdad);
        JPanel panelEdad = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEdad.add(new JLabel("Edad: "));
        panelEdad.add(edadSpinner);
        panelPrimero.add(panelEdad);

        add(panelPrimero);

        // ComboBox provincia
        String[] provincias = {"Alacant", "València", "Castelló"};
        provinciaComboBox = new JComboBox<>(provincias);
        JPanel provinciaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        provinciaPanel.add(new JLabel("Provincia: "));
        provinciaPanel.add(provinciaComboBox);
        add(provinciaPanel);

        // RadioButton sexo
        sexoGroup = new ButtonGroup();
        JPanel panelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT)); // PanelSexo jaja
        panelSexo.add(new JLabel("Sexo: "));
        hombreRadioButton = new JRadioButton("Hombre");
        mujerRadioButton = new JRadioButton("Mujer");
        otroRadioButton = new JRadioButton("Otro");
        sexoGroup.add(hombreRadioButton);
        sexoGroup.add(mujerRadioButton);
        sexoGroup.add(otroRadioButton);
        panelSexo.add(hombreRadioButton);
        panelSexo.add(mujerRadioButton);
        panelSexo.add(otroRadioButton);
        add(panelSexo);

        // CheckBox publicidad (si no se acepta no se puede enviar el formulario)
        publicidadCheckBox = new JCheckBox("Acepto toda la publicidad");
        JPanel panelPubli = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelPubli.add(publicidadCheckBox);
        add(panelPubli);

        // Botón enviar con action listener
        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (publicidadCheckBox.isSelected()) {
                    
                    int seleccion = ventanaConfirmacion();

                    if (seleccion == JOptionPane.YES_OPTION) {
                        mostrarDialogoInformacio("Datos enviados");
                        reiniciarValorsPerDefecte();

                    } else if (seleccion == JOptionPane.NO_OPTION) {

                        System.exit(0);
                        
                    } else if (seleccion == JOptionPane.CANCEL_OPTION) {

                        // Esto no hace nada más que mostrar el formulario otra vez

                    }

                } else {
                    
                    JOptionPane.showMessageDialog(FormularioInscripcion.this,
                            "Acepte la publicidad para poder enviar el formulario de isncripción.",
                            "Aviso!", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // El botón debe estar desactivado incialmente hasta que se acepte la publicidad
        enviarButton.setEnabled(false);
        add(enviarButton);

        // Listener de la casilla de publi
        publicidadCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                enviarButton.setEnabled(publicidadCheckBox.isSelected());

            }
        });
    }

    private int ventanaConfirmacion() {

        return JOptionPane.showConfirmDialog(FormularioInscripcion.this,
                "¿Confirmas los datos del formulario?",
                "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        
    }

    private void mostrarDialogoInformacio(String mensaje) {

        JOptionPane.showMessageDialog(FormularioInscripcion.this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

    }

    private void reiniciarValorsPerDefecte() {
        
        nombreTextField.setText("");
        edadSpinner.setValue(18);
        provinciaComboBox.setSelectedIndex(0);
        sexoGroup.clearSelection();
        publicidadCheckBox.setSelected(false);

    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Formulario de inscripción");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new FormularioInscripcion());

        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


