import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjercicioEspejo {

    private JFrame ventana;
    private JCheckBox aceptarPubliCheck;
    private JButton enviarButton;
    private JTextField nombreTextField;
    private JSpinner edadSpinner;
    private JComboBox<String> provinciasComboBox;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femeninoRadioButton;
    private JRadioButton otroRadioButton;
    private JLabel resultadoNombreLabel;
    private JLabel resultadoEdadLabel;
    private JLabel resultadoProvinciaLabel;
    private JLabel resultadoSexoLabel;

    public EjercicioEspejo() {
        // Crear la ventana principal
        ventana = new JFrame("Prueba de formulario de inscripción");
        ventana.setSize(700, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear y configurar el panel principal
        JPanel panelPrincipal = new JPanel(new GridLayout(0, 3, 10, 10));
        ventana.add(panelPrincipal);

        // Columna 1
        JPanel columna1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        aceptarPubliCheck = new JCheckBox("Acepto la publicidad");
        aceptarPubliCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarEstadoBotonEnviar();
            }
        });
        columna1Panel.add(aceptarPubliCheck);
        panelPrincipal.add(columna1Panel);

        // Columna 2
        JPanel columna2Panel = new JPanel(new GridLayout(0, 2, 5, 5));
        columna2Panel.setBorder(BorderFactory.createTitledBorder("Formulario de inscripción"));

        // Etiqueta y campo para el nombre
        columna2Panel.add(new JLabel("Nombre:"));
        nombreTextField = new JTextField(15);
        columna2Panel.add(nombreTextField);

        // Etiqueta y campo para la edad
        columna2Panel.add(new JLabel("Edad:"));
        edadSpinner = new JSpinner(new SpinnerNumberModel(18, 18, 99, 1));
        columna2Panel.add(edadSpinner);

        // Etiqueta y campo para la provincia
        columna2Panel.add(new JLabel("Provincia:"));
        String[] provincias = { "Castellón", "Valencia", "Alicante" };
        provinciasComboBox = new JComboBox<>(provincias);
        columna2Panel.add(provinciasComboBox);

        // Etiqueta y campo para el sexo
        columna2Panel.add(new JLabel("Sexo:"));
        ButtonGroup grupoSexo = new ButtonGroup();
        masculinoRadioButton = new JRadioButton("Masculino");
        femeninoRadioButton = new JRadioButton("Femenino");
        otroRadioButton = new JRadioButton("Otro");

        grupoSexo.add(masculinoRadioButton);
        grupoSexo.add(femeninoRadioButton);
        grupoSexo.add(otroRadioButton);

        columna2Panel.add(masculinoRadioButton);
        columna2Panel.add(femeninoRadioButton);
        columna2Panel.add(otroRadioButton);

        panelPrincipal.add(columna2Panel);

        // Columna 3 (Columna espejo)
        JPanel columna3Panel = new JPanel();
        columna3Panel.setLayout(new BoxLayout(columna3Panel, BoxLayout.Y_AXIS));

        resultadoNombreLabel = new JLabel("Nombre: ");
        resultadoEdadLabel = new JLabel("Edad: ");
        resultadoProvinciaLabel = new JLabel("Provincia: ");
        resultadoSexoLabel = new JLabel("Sexo: ");

        columna3Panel.add(resultadoNombreLabel);
        columna3Panel.add(resultadoEdadLabel);
        columna3Panel.add(resultadoProvinciaLabel);
        columna3Panel.add(resultadoSexoLabel);

        panelPrincipal.add(columna3Panel);

        // Botón de enviar
        enviarButton = new JButton("Enviar");
        enviarButton.setEnabled(aceptarPubliCheck.isSelected());
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVentanaConfirmacion();
            }
        });

        // Ajustar tamaño y centrar el botón de enviar
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botonesPanel.add(enviarButton);
        panelPrincipal.add(botonesPanel);

        // Configurar la visibilidad de la ventana principal
        ventana.setVisible(true);
    }

    private void actualizarEstadoBotonEnviar() {
        // Habilitar el botón "Enviar" solo si la casilla de verificación está marcada
        enviarButton.setEnabled(aceptarPubliCheck.isSelected());
    }

    private void mostrarVentanaConfirmacion() {
        // Crear la ventana de confirmación
        JFrame ventanaConfirmacion = new JFrame("Confirmación");
        ventanaConfirmacion.setSize(300, 150);
        ventanaConfirmacion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear y configurar el panel de la ventana de confirmación
        JPanel panelConfirmacion = new JPanel(new GridLayout(0, 1));
        ventanaConfirmacion.add(panelConfirmacion);

        JLabel mensajeLabel = new JLabel("¿Desea guardar y cerrar el formulario?");
        JButton siButton = new JButton("Sí");
        JButton noButton = new JButton("No");
        JButton cancelarButton = new JButton("Cancelar");

        siButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para guardar el formulario
                ventanaConfirmacion.dispose();
                mostrarEleccionesEnEspejo();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaConfirmacion.dispose();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaConfirmacion.dispose();
                ventana.dispose();
            }
        });

        panelConfirmacion.add(mensajeLabel);
        panelConfirmacion.add(siButton);
        panelConfirmacion.add(noButton);
        panelConfirmacion.add(cancelarButton);

        // Configurar la visibilidad de la ventana de confirmación
        ventanaConfirmacion.setVisible(true);
    }

    private void mostrarEleccionesEnEspejo() {
        // Implementa la lógica para mostrar las elecciones en la columna espejo
        resultadoNombreLabel.setText("Nombre: " + nombreTextField.getText());
        resultadoEdadLabel.setText("Edad: " + edadSpinner.getValue());
        resultadoProvinciaLabel.setText("Provincia: " + provinciasComboBox.getSelectedItem());

        String sexoSeleccionado = "";
        if (masculinoRadioButton.isSelected()) {
            sexoSeleccionado = "Masculino";
        } else if (femeninoRadioButton.isSelected()) {
            sexoSeleccionado = "Femenino";
        } else if (otroRadioButton.isSelected()) {
            sexoSeleccionado = "Otro";
        }
        resultadoSexoLabel.setText("Sexo: " + sexoSeleccionado);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EjercicioEspejo();
            }
        });
    }
}
