package programas_java.control_acceso;

import java.util.ArrayList;
import java.util.Scanner;

public class PlataformaAcceso {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Persona> usuarios = adminConfig();
        String usuario;
        String contraseña;
        String eleccion;
        Boolean inicio = false;

        do {

            System.out.println("Hola, usuario, ¿qué desea hacer?\n1. Iniciar sesión\n2. Salir");
            eleccion = SC.nextLine();
            inicio = false;

            if (eleccion.equals("1")) {

                System.out.println("Por favor, introduzca su nombre de usuario:");
                usuario = SC.nextLine();
                System.out.println("Por favor, introduzca su contraseña:");
                contraseña = SC.nextLine();

                for (Persona persona : usuarios) {

                    String nick = persona.getNick();
                    String pass = persona.getPass();

                    if (nick.equals(usuario) && pass.equals(contraseña)) {

                        Persona.entradaUsuario(persona);
                        inicio = true;
                    }

                }

                if (!inicio) {

                    System.out.println("Usuario o contraseña incorrectos\n");

                }
            }

        } while (eleccion.equals("1"));

    }

    private static ArrayList<Persona> adminConfig() {

        ArrayList<Persona> personas = new ArrayList<Persona>();

        Persona admin = new Persona("admin", "admin1234");
        Persona marcos = new Persona("marcos", "1234");
        Persona marisa = new Persona("marisa", "qwerty");

        personas.add(admin);
        personas.add(marcos);
        personas.add(marisa);

        return personas;

    }
}
