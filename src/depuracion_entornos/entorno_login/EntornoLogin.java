package depuracion_entornos.entorno_login;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class EntornoLogin extends JFrame {

    private boolean isImage1 = true;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(EntornoLogin::new);

    }

    public EntornoLogin() {
        
        setTitle("Tanki Online Classic");
        setDefaultCloseOperation(3);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        setIconImage(getCustomIcon());

        // Añadimos los campos y botones
    
        BackgroundPanel imagenBack = new BackgroundPanel();
        add(imagenBack, BorderLayout.CENTER);

        JLabel titulo = new JLabel("Welcome");
        titulo.setFont(new Font("Source Code Pro", Font.BOLD, 24));
        titulo.setHorizontalAlignment(0);

        JLabel usuarioEtiqueta = new JLabel("User:");
        JTextField usuarioCampo = new JTextField();
        usuarioCampo.setColumns(15);

        JLabel contrasenaEtiqueta = new JLabel("Password:");
        JPasswordField contrasenaCampo = new JPasswordField();
        contrasenaCampo.setColumns(15);

        JButton login = new JButton("LOG IN");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(usuarioCampo, contrasenaCampo);
            }
        });
        login.setOpaque(false);

        JButton changeBackground = new JButton("Cambiar aspecto");
        changeBackground.addActionListener(e -> changeBackground(imagenBack));
        changeBackground.setOpaque(false);

        Dimension logButtonSize = new Dimension(100, 30);
        Dimension backButtonSize = new Dimension(150, 30);
        login.setPreferredSize(logButtonSize);
        changeBackground.setPreferredSize(backButtonSize);

        imagenBack.setLayout(new GridLayout(5, 1));
        imagenBack.add(titulo);

        // Añadimos los paneles con sus respectivos componentes
        JPanel usuarioPanel = new JPanel();
        usuarioPanel.setLayout(new FlowLayout());
        usuarioPanel.add(usuarioEtiqueta);
        usuarioPanel.add(usuarioCampo);
        usuarioPanel.setOpaque(false);
        imagenBack.add(usuarioPanel);

        JPanel contrasenaPanel = new JPanel();
        contrasenaPanel.setLayout(new FlowLayout());
        contrasenaPanel.add(contrasenaEtiqueta);
        contrasenaPanel.add(contrasenaCampo);
        contrasenaPanel.setOpaque(false);
        imagenBack.add(contrasenaPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(login);
        imagenBack.add(buttonPanel);

        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backButtonPanel.setOpaque(false);
        backButtonPanel.add(changeBackground);
        imagenBack.add(backButtonPanel);

        Set<AWTKeyStroke> forwardKeys = new HashSet<>(contrasenaCampo.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        forwardKeys.clear();
        contrasenaCampo.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, forwardKeys);

        contrasenaCampo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(usuarioCampo, contrasenaCampo);
                }
            }
        });

        setVisible(true);
    }

    @Override
    public Image getIconImage() {
        return getCustomIcon();
    }

    private Image getCustomIcon() {

        try {
    
            File imagen = new File("entorno_login\\descarga.ico");
            BufferedImage bufferedImage = ImageIO.read(imagen);
            return bufferedImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH);

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }

    private void login(JTextField usuarioCampo, JPasswordField contrasenaCampo) {

        String nombreUsuario = usuarioCampo.getText();
        char[] contrasena = contrasenaCampo.getPassword();

        Object[] opciones = {"OK"};

        boolean checkCorrecto = chequeo(nombreUsuario, new String(contrasena));

        if (checkCorrecto) {

            dispose();

            VentanaLogin nuevaVentana = new VentanaLogin(nombreUsuario);
            nuevaVentana.setVisible(true);

        } else {

            JOptionPane.showOptionDialog(this, "Incorrect access", "Login Failed", JOptionPane.DEFAULT_OPTION,
                JOptionPane.ERROR_MESSAGE, null, opciones, opciones[0]);

        }

        usuarioCampo.setText("");
        contrasenaCampo.setText("");
    }

    private boolean chequeo(String nombre, String pass) {

        /*
        Como no vamos a tener usuarios registrados en otra clase ni base de datos,
        nos conformaremos con que los dos campos tengan algún valor para darlos por buenos.
        */

        return !nombre.isEmpty() && !pass.isEmpty();

    }

    private void changeBackground(BackgroundPanel panel) {
        
        try {

            BufferedImage newImage;

            if (isImage1) {

                newImage = ImageIO.read(new File("entorno_login\\back2.png"));

            } else {

                newImage = ImageIO.read(new File("entorno_login\\back.png"));

            }

            panel.setBackgroundImage(newImage);
            isImage1 = !isImage1;

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    class BackgroundPanel extends JPanel {

        private Image backImagen;

        public BackgroundPanel() {
            
            try {

                backImagen = ImageIO.read(new File("entorno_login\\back.png"));

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

        public void setBackgroundImage(Image newImage) {
            
            backImagen = newImage;
            repaint();

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backImagen != null) {
                g.drawImage(backImagen, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    class VentanaLogin extends JFrame {

        public VentanaLogin(String username) {

            setTitle("Login correcto");
            setDefaultCloseOperation(2);
            setSize(300, 150);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel label = new JLabel("Welcome, " + username);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton closeButton = new JButton("Close");
            closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            closeButton.addActionListener(e -> dispose());

            panel.add(Box.createVerticalGlue());
            panel.add(label);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(closeButton);
            panel.add(Box.createVerticalGlue());

            // Agregar el panel a la ventana secundaria
            add(panel);

            // Mostrar la ventana secundaria
            setVisible(true);
        }
    }
}
