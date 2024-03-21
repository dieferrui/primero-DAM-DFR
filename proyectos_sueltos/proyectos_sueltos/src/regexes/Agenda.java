package regexes;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Agenda {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int numPers = 0;

        System.out.println("Introduzca el número de personas que desea añadir a la agenda: ");
        numPers = sc.nextInt();

        String[] agenda = agendador(numPers);
        
        System.out.println("Esta es su agenda: \n");
        for (int i = 0; i < agenda.length; i++) {
            System.out.println(agenda[i]);
        }
    }

    public static String[] construyePersona() {

        Scanner sc = new Scanner(System.in);
        String nombre;
        String correo;
        String direccionIP;
        String telefono;
        
        System.out.println("Introduzca el nombre de la persona (con formato \"Apellido1 Apellido2, Nombre\"): ");
        nombre = sc.nextLine();

        System.out.println("Introduzca el correo electrónico de la persona: ");
        correo = sc.nextLine();
        
        System.out.println("Introduzca la dirección IP de la persona (formato IPv4): ");
        direccionIP = sc.nextLine();

        System.out.println("Introduzca el número de teléfono de la persona (sólo números con prefijo +34 y un espacio): ");
        telefono = sc.nextLine();

        String[] talVezPersona = {nombre, correo, direccionIP, telefono};
        
        return talVezPersona;
    }

    public static boolean comprobador(String[] talVezPersona) {
        
        Pattern nombreVal = Pattern.compile("^[A-Za-zñÑáéíóúÁÉÍÓÚüÜ\\- ]+, [A-Za-zñÑáéíóúÁÉÍÓÚüÜ\\- ]+$");
        Matcher matchNombre = nombreVal.matcher(talVezPersona[0]);

        Pattern correoVal = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        Matcher matchCorreo = correoVal.matcher(talVezPersona[1]);

        Pattern ipVal = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)\\."
                + "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9][0-9]?)$");
        Matcher matchIp = ipVal.matcher(talVezPersona[2]);

        Pattern telefonoVal = Pattern.compile("^\\+(34) (\\d{9})$");
        Matcher matchTelefono = telefonoVal.matcher(talVezPersona[3]);

        if (matchNombre.matches() && matchCorreo.matches() && matchIp.matches() && matchTelefono.matches()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public static String[] agendador(int numPers) {

        Scanner scan = new Scanner(System.in);
        String[] agendaReal = new String[numPers];
        String[] talVezPersona;
        int res;

        StringBuilder nuevaPersona;

        for (int i = 0; i < numPers; i++) {

            boolean comprobado = Boolean.FALSE;

            do {
                talVezPersona = construyePersona();
                comprobado = comprobador(talVezPersona);

                if (!comprobado) {
                    System.out.println("Alguno de los campos no fue rellenado correctamente. Inténtelo de nuevo."); 
                } else {
                    System.out.println("Persona añadida correctamente.\n");
                    nuevaPersona = new StringBuilder(999);
                    nuevaPersona.append("Nombre: " + talVezPersona[0] + "\n");
                    nuevaPersona.append("Correo electrónico: " + talVezPersona[1] + "\n");
                    nuevaPersona.append("Dirección IP: " + talVezPersona[2] + "\n");
                    nuevaPersona.append("Teléfono: " + talVezPersona[3] + "\n");
                    nuevaPersona.append("\n");

                    agendaReal[i] = nuevaPersona.toString();
                }

            } while (!comprobado);

            System.out.println("¿Desea seguir introduciendo contactos?\n1. Sí\n2.No");
            res = scan.nextInt();
            System.out.println();

            if (res == 2) {
                break;
            }
        }

        return agendaReal; 
    }
}
