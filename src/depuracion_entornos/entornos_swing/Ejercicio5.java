import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio5 extends JPanel {

    private JTextField nomTextField;  // Camp de text per al nom
    private JSpinner edatSpinner;  // Spinner per a l'edat
    private JComboBox<String> provinciaComboBox;  // ComboBox per a la província
    private JRadioButton masculiRadioButton;  // RadioButton per al sexe masculí
    private JRadioButton femeniRadioButton;  // RadioButton per al sexe femení
    private JRadioButton altreRadioButton;  // RadioButton per a altres sexes
    private JCheckBox acceptaPublicitatCheckBox;  // CheckBox per acceptar publicitat
    private JButton enviarButton;  // Botó d'enviar

    // Camps d'espill (mostra dades)
    private JLabel espillNomLabel;  // Etiqueta per a mostrar el nom
    private JLabel espillEdatLabel;  // Etiqueta per a mostrar l'edat
    private JLabel espillProvinciaLabel;  // Etiqueta per a mostrar la província
    private JLabel espillSexeLabel;  // Etiqueta per a mostrar el sexe

    // Constructor del panell
    public Ejercicio5() {
        setLayout(new BorderLayout(10, 10));  // Establim el layout del panell

        // Panell superior amb el títol
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("Formulari d'inscripció");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(label);
        add(titlePanel, BorderLayout.NORTH);

        // Panell central amb els camps editables
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Etiquetes i camps de text, spinner, combo box, radio buttons
        formPanel.add(new JLabel("Nom: "), gbc);
        gbc.gridy++;
        formPanel.add(new JLabel("Edat: "), gbc);
        gbc.gridy++;
        formPanel.add(new JLabel("Província: "), gbc);
        gbc.gridy++;
        formPanel.add(new JLabel("Sexe: "), gbc);
        gbc.gridy++;
        gbc.gridx = 1;
        gbc.gridy = 0;

        // Camp de text per al nom
        nomTextField = new JTextField(20);
        // Afegeix KeyListener per a gestionar esdeveniments de teclat (keyPressed)
        nomTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                actualitzarCampsEspill();
            }
        });
        formPanel.add(nomTextField, gbc);
        gbc.gridy++;

        // Spinner per a l'edat amb restriccions
        SpinnerModel edatModel = new SpinnerNumberModel(18, 18, 99, 1);
        edatSpinner = new JSpinner(edatModel);
        // Afegeix ChangeListener per a gestionar esdeveniments de canvi d'estat (JSpinner)
        edatSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualitzarCampsEspill();
            }
        });
        formPanel.add(edatSpinner, gbc);
        gbc.gridy++;

        // ComboBox per a la província
        String[] provincies = {"Alacant", "València", "Castelló"};
        provinciaComboBox = new JComboBox<>(provincies);
        // Afegeix ItemListener per a gestionar esdeveniments de canvi d'ítem (JComboBox)
        provinciaComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualitzarCampsEspill();
            }
        });
        formPanel.add(provinciaComboBox, gbc);
        gbc.gridy++;

        // RadioButtons per al sexe
        ButtonGroup grupSexe = new ButtonGroup();
        masculiRadioButton = new JRadioButton("Masculí");
        femeniRadioButton = new JRadioButton("Femení");
        altreRadioButton = new JRadioButton("Altres");
        grupSexe.add(masculiRadioButton);
        grupSexe.add(femeniRadioButton);
        grupSexe.add(altreRadioButton);
        JPanel sexePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sexePanel.add(masculiRadioButton);
        sexePanel.add(femeniRadioButton);
        sexePanel.add(altreRadioButton);
        formPanel.add(sexePanel, gbc);

        // CheckBox per acceptar publicitat
        acceptaPublicitatCheckBox = new JCheckBox("Accepta la publicitat");
        JPanel publicitatPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        publicitatPanel.add(acceptaPublicitatCheckBox);
        add(publicitatPanel, BorderLayout.WEST);

        // Panell dret amb els camps d'espill
        JPanel espillPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        espillNomLabel = new JLabel("Nom: ");
        espillEdatLabel = new JLabel("Edat: ");
        espillProvinciaLabel = new JLabel ("Província: ");
        espillSexeLabel = new JLabel("Sexe: ");
        espillNomLabel.setForeground(Color.BLUE);
        espillEdatLabel.setForeground(Color.BLUE);
        espillProvinciaLabel.setForeground(Color.BLUE);
        espillSexeLabel.setForeground(Color.BLUE);

        espillPanel.add(new JLabel("Nom: "));
        espillPanel.add(espillNomLabel);
        espillPanel.add(new JLabel("Edat: "));
        espillPanel.add(espillEdatLabel);
        espillPanel.add(new JLabel("Província: "));
        espillPanel.add(espillProvinciaLabel);
        espillPanel.add(new JLabel("Sexe: "));
        espillPanel.add(espillSexeLabel);

        add(formPanel, BorderLayout.CENTER);
        add(espillPanel, BorderLayout.EAST);

        // Panell inferior amb el botó d'enviar
        JPanel enviarButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        enviarButton = new JButton("Enviar");
        // Afegeix ActionListener per a gestionar esdeveniments del botó d'enviar
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualitzarCampsEspill();
            }
        });
        enviarButton.setFont(enviarButton.getFont().deriveFont(Font.PLAIN, 12f));
        enviarButton.setEnabled(false);
        enviarButtonPanel.add(enviarButton);
        add(enviarButtonPanel, BorderLayout.SOUTH);

        // Configurant el listener per a la casella de selecció
        acceptaPublicitatCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarButton.setEnabled(acceptaPublicitatCheckBox.isSelected());
            }
        });
    }

    // Mètode per actualitzar els camps d'espill amb les dades actuals
    private void actualitzarCampsEspill() {
        espillNomLabel.setText("Nom: " + nomTextField.getText());
        espillEdatLabel.setText("Edat: " + edatSpinner.getValue());
        espillProvinciaLabel.setText("Província: " + provinciaComboBox.getSelectedItem());

        String sexeSeleccionat = "";
        if (masculiRadioButton.isSelected()) {
            sexeSeleccionat = "Masculí";
        } else if (femeniRadioButton.isSelected()) {
            sexeSeleccionat = "Femení";
        } else if (altreRadioButton.isSelected()) {
            sexeSeleccionat = "Altres";
        }
        espillSexeLabel.setText("Sexe: " + sexeSeleccionat);
    }

    // Mètode principal per provar el panell
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prova del Formulari d'Inscripció");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Ejercicio5());
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


