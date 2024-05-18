import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

public class App extends JFrame implements ActionListener {

    public int[][] cuadriculaCalculo;
    public JButton[][] cuadricula;
    Font font = new Font("Arial", Font.PLAIN, 20);

    public App() {
        super("Ventana Principal");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cuadriculaCalculo = new int[9][9];
        cuadricula = new JButton[9][9];

        cuadriculaCalculo = rellenarNumeros();
        cuadricula = crearCuadricula();

        for (int i = 0; i < this.cuadricula.length; i++) {
            for (int j = 0; j < this.cuadricula[0].length; j++) {
                this.add(this.cuadricula[i][j]);
            }
        }

        this.setLayout(new GridLayout(9, 9));
        this.setVisible(true);
    }

    public int[][] rellenarNumeros() {
        int[][] cuadriculaLlena = new int[9][9];
        int contador = 0;
        while (contador < 10) {
            int x = posicionAleatoria();
            int y = posicionAleatoria();
            int numero = cuadriculaLlena[x][y];
            if (numero == 0) {
                cuadriculaLlena[x][y] = numeroAleatorio();
                contador++;
            }
        }
        return cuadriculaLlena;
    }

    public int numeroAleatorio() {
        int numeroAleatorio = (int) ((Math.random() * 9) + 1);
        return numeroAleatorio;
    }

    public int posicionAleatoria() {
        int posicion = (int) (Math.random() * 9);
        return posicion;
    }

    public JButton[][] crearCuadricula() {
        JButton[][] devolverCuadricula = new JButton[9][9];
        for (int i = 0; i < devolverCuadricula.length; i++) {
            for (int j = 0; j < devolverCuadricula[0].length; j++) {
                devolverCuadricula[i][j] = new JButton(Integer.toString(cuadriculaCalculo[i][j]));
                devolverCuadricula[i][j].setBackground(Color.RED);
                if (cuadriculaCalculo[i][j] != 0) {
                    devolverCuadricula[i][j].setEnabled(false);
                    devolverCuadricula[i][j].setBackground(Color.BLUE);
                }
                devolverCuadricula[i][j].setFont(new Font("Arial", Font.PLAIN, 20));

                devolverCuadricula[i][j].setBorder(new LineBorder(Color.BLACK, 5, rootPaneCheckingEnabled));
                devolverCuadricula[i][j].addActionListener(this);

            }
        }
        return devolverCuadricula;

    }

    public boolean comprobarColumna(int numeroComprobar, int columna) {
        for (int j = 0; j < cuadricula.length; j++) {
            if (cuadriculaCalculo[columna][j] == numeroComprobar) {
                return false;
            }
        }
        return true;
    }

    public boolean comprobarFila(int numeroComprobar, int fila) {
        for (int j = 0; j < cuadricula.length; j++) {
            if (cuadriculaCalculo[j][fila] == numeroComprobar) {
                return false;
            }
        }
        return true;
    }

    public boolean comprobarVictoria() {
        // Verificar filas
        for (int i = 0; i < cuadricula.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < cuadricula[0].length; j++) {
                sumaFila += cuadriculaCalculo[i][j];
            }
            if (sumaFila != 45) {
                return false;
            }
        }

        // Verificar columnas
        for (int j = 0; j < cuadricula[0].length; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < cuadricula.length; i++) {
                sumaColumna += cuadriculaCalculo[i][j];
            }
            if (sumaColumna != 45) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new App();
    }

    public void checkButton(Object whatButton) {
        int numero;
        for (int i = 0; i < cuadricula.length; i++) {
            for (int j = 0; j < cuadricula[0].length; j++) {
                if (whatButton == cuadricula[i][j]) {
                    while (true) {
                        try {
                            String input = JOptionPane.showInputDialog("Introduzca un numero");

                            if (input == null)
                                return;
                            numero = Integer.parseInt(input);
                            if (comprobarColumna(numero, i) && comprobarFila(numero, j)) {
                                cuadricula[i][j].setBackground(Color.GREEN);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Numero no valido");
                            }

                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Entrada no válida. Introduce un número entero.");
                        }
                    }

                    cuadricula[i][j].setText(Integer.toString(numero));
                    cuadriculaCalculo[i][j] = numero;

                }
            }
        }

        if (comprobarVictoria()) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¡Has Ganado! ¿Quieres salir?", "Victoria",
                    JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object whatButton = e.getSource();
        checkButton(whatButton);
    }

}