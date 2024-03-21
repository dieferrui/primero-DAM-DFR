

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PlataformaAcceso {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Persona> usuarios = adminConfig();
        String usuario;
        String contrasena;
        String eleccion;
        Boolean inicio = false;

        do {

            System.out.println("Hola, usuario, ¿qué desea hacer?\n1. Iniciar sesión\n2. Salir");
            eleccion = tryWithScanner();
            inicio = false;

            if (eleccion.equals("1")) {

                System.out.println("Por favor, introduzca su nombre de usuario:");
                usuario = tryWithScanner();
                System.out.println("Por favor, introduzca su contraseña:");
                contrasena = tryWithScanner();

                for (Persona persona : usuarios) {

                    String nick = persona.getNick();
                    String pass = persona.getPass();

                    if (nick.equals(usuario) && pass.equals(contrasena)) {

                        Persona.entradaUsuario(persona);
                        inicio = true;
                    }

                }

                if (Boolean.FALSE.equals(inicio)) {

                    System.out.println("Usuario o contraseña incorrectos.\n");

                }
            }

        } while (eleccion.equals("1"));

        SC.close();
    }

    private static ArrayList<Persona> adminConfig() {

        ArrayList<Persona> personas = new ArrayList<>();

        Persona admin = new Persona("admin", "admin1234");
        Persona marcos = new Persona("marcos", "1234");
        Persona marisa = new Persona("marisa", "qwerty");

        personas.add(admin);
        personas.add(marcos);
        personas.add(marisa);

        return personas;

    }

    private static String tryWithScanner() {

        String returned = "";

        try {

            returned = SC.nextLine();

        } catch (NoSuchElementException e) {

            System.out.println("No se ha encontrado el elemento.");
            System.exit(0);

        } catch (IllegalStateException e) {

            System.out.println("Escáner cerrado. Reabriendo...");
            SC.reset();

        } 
        
        return returned;
    }
}
