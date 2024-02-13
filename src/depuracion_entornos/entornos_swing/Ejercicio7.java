import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Ejercicio7 extends JFrame {
    private JTextField campEncert;
    private JButton jugaButton;
    private JLabel resultatLabel;

    public Ejercicio7() {
        setTitle("Joc Encertar Número");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        campEncert = new JTextField();
        campEncert.setHorizontalAlignment(JTextField.CENTER);

        jugaButton = new JButton("Juga");
        jugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarJoc();
            }
        });

        resultatLabel = new JLabel();
        resultatLabel.setHorizontalAlignment(JLabel.CENTER);

        add(campEncert);
        add(jugaButton);
        add(resultatLabel);

        // Afegir el menú contextual amb l'opció de generar un número aleatori
        JPopupMenu menuContextual = new JPopupMenu();
        JMenuItem generarAleatoriItem = new JMenuItem("Generar número aleatori");
        generarAleatoriItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campEncert.setText(String.valueOf(generarNumeroAleatori()));
            }
        });

        // Afegim el botó "Generar número aleatori" com a submenú
        JMenu subMenu = new JMenu("Generar número aleatori");
        JMenuItem generarAleatoriSubItem = new JMenuItem("Generar");
        generarAleatoriSubItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campEncert.setText(String.valueOf(generarNumeroAleatori()));
            }
        });
        subMenu.add(generarAleatoriSubItem);
        menuContextual.add(subMenu);

        campEncert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    menuContextual.show(campEncert, e.getX(), e.getY());
                }
            }
        });
    }

    private void jugarJoc() {
        try {
            int intent = Integer.parseInt(campEncert.getText());
            int numeroAleatori = generarNumeroAleatori();
            if (intent == numeroAleatori) {
                resultatLabel.setText("Encertat! El número era " + numeroAleatori);
            } else {
                resultatLabel.setText("Incorrecte! El número era " + numeroAleatori);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Introdueix un número vàlid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int generarNumeroAleatori() {
        Random random = new Random();
        int numeroAleatori = random.nextInt(10) + 1; // Generar un número entre 1 i 10
        return numeroAleatori;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ejercicio7 joc = new Ejercicio7();
                joc.setVisible(true);
            }
        });
    }
}


