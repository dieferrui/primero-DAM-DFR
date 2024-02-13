import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio4 extends JPanel {

    private JTextField nomTextField;
    private JSpinner edatSpinner;
    private JComboBox<String> provinciaComboBox;
    private JRadioButton masculiRadioButton;
    private JRadioButton femeniRadioButton;
    private JRadioButton altreRadioButton;
    private JCheckBox acceptaPublicitatCheckBox;
    private JButton enviarButton;
    private ButtonGroup grupSexe;

    public Ejercicio4() {
        // Estableix el layout del panell (en aquest cas, usem GridLayout)
        setLayout(new GridLayout(7, 1, 5, 5)); // 7 files, 1 columna

        // Afegir components al panell
        JLabel label = new JLabel("Formulari d'inscripció");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);

        // Panell per al nom i l'edat (en una columna)
        JPanel nomEdatPanel = new JPanel(new GridLayout(1, 2, 5, 5));

        // Casella de text per al nom
        nomTextField = new JTextField(20);
        JPanel nomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nomPanel.add(new JLabel("Nom: "));
        nomPanel.add(nomTextField);
        nomEdatPanel.add(nomPanel);

        // Spinner per a l'edat amb restriccions (mínim 18, màxim 99)
        SpinnerModel edatModel = new SpinnerNumberModel(18, 18, 99, 1);
        edatSpinner = new JSpinner(edatModel);
        JPanel edatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        edatPanel.add(new JLabel("Edat: "));
        edatPanel.add(edatSpinner);
        nomEdatPanel.add(edatPanel);

        add(nomEdatPanel);

        // Desplegable per a seleccionar la província
        String[] provincies = {"Alacant", "València", "Castelló"};
        provinciaComboBox = new JComboBox<>(provincies);
        JPanel provinciaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        provinciaPanel.add(new JLabel("Província: "));
        provinciaPanel.add(provinciaComboBox);
        add(provinciaPanel);

        // RadioButtons per a seleccionar el sexe (en una fila)
        grupSexe = new ButtonGroup(); // Inicialitzar el grup de botons d'opció
        JPanel sexePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sexePanel.add(new JLabel("Sexe: "));
        masculiRadioButton = new JRadioButton("Masculí");
        femeniRadioButton = new JRadioButton("Femení");
        altreRadioButton = new JRadioButton("Altres");
        grupSexe.add(masculiRadioButton);
        grupSexe.add(femeniRadioButton);
        grupSexe.add(altreRadioButton);
        sexePanel.add(masculiRadioButton);
        sexePanel.add(femeniRadioButton);
        sexePanel.add(altreRadioButton);
        add(sexePanel);

        // CheckBox per a acceptar la publicitat
        acceptaPublicitatCheckBox = new JCheckBox("Accepta la publicitat");
        JPanel publicitatPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        publicitatPanel.add(acceptaPublicitatCheckBox);
        add(publicitatPanel);

        // Botó d'enviar
        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (acceptaPublicitatCheckBox.isSelected()) {
                    // L'usuari accepta la publicitat, processar les dades
                    int resposta = mostrarDialogoConfirmacio();
                    if (resposta == JOptionPane.YES_OPTION) {
                        mostrarDialogoInformacio("Has acceptat les dades del formulari");
                        reiniciarValorsPerDefecte();
                    } else if (resposta == JOptionPane.NO_OPTION) {
                        System.exit(0); // Sortir completament de l'aplicació
                    } else if (resposta == JOptionPane.CANCEL_OPTION) {
                        // No fer res, mostrarà novament el formulari
                    }
                } else {
                    // L'usuari no accepta la publicitat, mostrar missatge d'advertència
                    JOptionPane.showMessageDialog(Ejercicio4.this,
                            "Per a enviar les dades, heu d'acceptar la publicitat.",
                            "Advertència", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        // Inicialment, desactivar el botó enviar
        enviarButton.setEnabled(false);
        add(enviarButton);

        // Configurant el listener per a la casella de selecció
        acceptaPublicitatCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Habilitar o deshabilitar el botó enviar segons l'estat de la casella de selecció
                enviarButton.setEnabled(acceptaPublicitatCheckBox.isSelected());
            }
        });

        // Podeu afegir més components o personalitzar segons les vostres necessitats.
    }

    private int mostrarDialogoConfirmacio() {
        return JOptionPane.showConfirmDialog(Ejercicio4.this,
                "Vols acceptar les dades del formulari?",
                "Confirmació", JOptionPane.YES_NO_CANCEL_OPTION);
    }

    private void mostrarDialogoInformacio(String missatge) {
        JOptionPane.showMessageDialog(Ejercicio4.this, missatge, "Informació", JOptionPane.INFORMATION_MESSAGE);
    }

    private void reiniciarValorsPerDefecte() {
        // Restablir els valors per defecte aquí
        nomTextField.setText("");
        edatSpinner.setValue(18);
        provinciaComboBox.setSelectedIndex(0);
        grupSexe.clearSelection(); // Limpiar la selección del grupo de botones de opción
        acceptaPublicitatCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        // Crear una finestra per provar el panell
        JFrame frame = new JFrame("Prova del Formulari d'Inscripció");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Afegir el panell a la finestra
        frame.getContentPane().add(new Ejercicio4());

        // Configurar la finestra
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Centrar la finestra en pantalla
        frame.setVisible(true);
    }
}


