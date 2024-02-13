import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeshabilitarCampos extends JPanel {

    private JTextField nombreTextField;
    private JSpinner edadSpinner;
    private JComboBox<String> provinciaComboBox;
    private JRadioButton hombreRadioButton;
    private JRadioButton mujerRadioButton;
    private JRadioButton otroRadioButton;
    private JCheckBox publiCheckBox;
    private JButton enviarButton;
    private ButtonGroup sexoGroup;

    public DeshabilitarCampos() {
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
        nombreTextField = new JTextField(20);
        JPanel nomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nomPanel.add(new JLabel("Nom: "));
        nomPanel.add(nombreTextField);
        nomEdatPanel.add(nomPanel);

        // Spinner per a l'edat amb restriccions (mínim 18, màxim 99)
        SpinnerModel edatModel = new SpinnerNumberModel(18, 18, 99, 1);
        edadSpinner = new JSpinner(edatModel);
        JPanel edatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        edatPanel.add(new JLabel("Edat: "));
        edatPanel.add(edadSpinner);
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
        sexoGroup = new ButtonGroup(); // Inicialitzar el grup de botons d'opció
        JPanel sexePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sexePanel.add(new JLabel("Sexe: "));
        hombreRadioButton = new JRadioButton("Masculí");
        mujerRadioButton = new JRadioButton("Femení");
        otroRadioButton = new JRadioButton("Altres");
        sexoGroup.add(hombreRadioButton);
        sexoGroup.add(mujerRadioButton);
        sexoGroup.add(otroRadioButton);
        sexePanel.add(hombreRadioButton);
        sexePanel.add(mujerRadioButton);
        sexePanel.add(otroRadioButton);
        add(sexePanel);

        // CheckBox per a acceptar la publicitat
        publiCheckBox = new JCheckBox("Accepta la publicitat");
        JPanel publicitatPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        publicitatPanel.add(publiCheckBox);
        add(publicitatPanel);

        // Botó d'enviar
        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (publiCheckBox.isSelected()) {
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
                    JOptionPane.showMessageDialog(DeshabilitarCampos.this,
                            "Per a enviar les dades, heu d'acceptar la publicitat.",
                            "Advertència", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        // Inicialment, desactivar el botó enviar
        enviarButton.setEnabled(false);
        add(enviarButton);

        // Podeu afegir més components o personalitzar segons les vostres necessitats.
    }

    private int mostrarDialogoConfirmacio() {
        return JOptionPane.showConfirmDialog(DeshabilitarCampos.this,
                "Vols acceptar les dades del formulari?",
                "Confirmació", JOptionPane.YES_NO_CANCEL_OPTION);
    }

    private void mostrarDialogoInformacio(String missatge) {
        JOptionPane.showMessageDialog(DeshabilitarCampos.this, missatge, "Informació", JOptionPane.INFORMATION_MESSAGE);
    }

    private void reiniciarValorsPerDefecte() {
        // Restablir els valors per defecte aquí
        nombreTextField.setText("");
        edadSpinner.setValue(18);
        provinciaComboBox.setSelectedIndex(0);
        sexoGroup.clearSelection(); // Limpiar la selección del grupo de botones de opción
        publiCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        // Crear una finestra per provar el panell
        JFrame frame = new JFrame("Prova del Formulari d'Inscripció");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Afegir el panell a la finestra
        DeshabilitarCampos formularioPanel = new DeshabilitarCampos();
        frame.getContentPane().add(formularioPanel);

        // Crear el menú de opciones
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opcions");

        // Submenú para agrupar checkboxes
        JMenu subMenu = new JMenu("Deshabilitar camps");

        JCheckBoxMenuItem deshabilitarNom = new JCheckBoxMenuItem("Nom");
        deshabilitarNom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formularioPanel.nombreTextField.setEnabled(!deshabilitarNom.isSelected());
            }
        });
        subMenu.add(deshabilitarNom);

        JCheckBoxMenuItem deshabilitarEdat = new JCheckBoxMenuItem("Edat");
        deshabilitarEdat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formularioPanel.edadSpinner.setEnabled(!deshabilitarEdat.isSelected());
            }
        });
        subMenu.add(deshabilitarEdat);

        JCheckBoxMenuItem deshabilitarProvincia = new JCheckBoxMenuItem("Província");
        deshabilitarProvincia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formularioPanel.provinciaComboBox.setEnabled(!deshabilitarProvincia.isSelected());
            }
        });
        subMenu.add(deshabilitarProvincia);

        JCheckBoxMenuItem deshabilitarSexe = new JCheckBoxMenuItem("Sexe");
        deshabilitarSexe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formularioPanel.hombreRadioButton.setEnabled(!deshabilitarSexe.isSelected());
                formularioPanel.mujerRadioButton.setEnabled(!deshabilitarSexe.isSelected());
                formularioPanel.otroRadioButton.setEnabled(!deshabilitarSexe.isSelected());
            }
        });
        subMenu.add(deshabilitarSexe);

        JCheckBoxMenuItem deshabilitarPublicitat = new JCheckBoxMenuItem("Publicitat");
        deshabilitarPublicitat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formularioPanel.publiCheckBox.setEnabled(!deshabilitarPublicitat.isSelected());
            }
        });
        subMenu.add(deshabilitarPublicitat);

        menu.add(subMenu);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Configurar la finestra
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Centrar la finestra en pantalla
        frame.setVisible(true);
    }
}

