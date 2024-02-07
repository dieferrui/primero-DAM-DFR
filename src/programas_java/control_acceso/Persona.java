package programas_java.control_acceso;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Persona {

    private String nick;
    private String pass;
    private int numSesiones = 0;
    public static DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LocalDateTime ultimoInicio = null;

    public Persona(String nick, String pass) {

        this.nick = nick;
        this.pass = pass;

    }

    public static void entradaUsuario(Persona persona) {

        System.out.println("Hola, " + persona.getNick() + ".");

        try {

            System.out.println("Tu último inicio de sesión fue el día " + fecha.format(persona.ultimoInicio)
                            + " a las " + hora.format(persona.ultimoInicio) + ".");

        } catch (NullPointerException e) {

            System.out.println("Esta es la primera vez que inicias sesión.");

        }
        
        System.out.println("Has iniciado sesión un total de " + persona.getNumSesiones() + " veces.");
        
        System.out.println();

        actualizarSesion(persona);

    }

    public static void actualizarSesion(Persona persona) {

        persona.numSesiones += 1;
        persona.ultimoInicio = LocalDateTime.now();
        
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getNumSesiones() {
        return numSesiones;
    }

    public void setNumSesiones(int numSesiones) {
        this.numSesiones = numSesiones;
    }

    public LocalDateTime getUltimoInicio() {
        return ultimoInicio;
    }

    public void setUltimoInicio(LocalDateTime ultimoInicio) {
        this.ultimoInicio = ultimoInicio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nick == null) ? 0 : nick.hashCode());
        result = prime * result + ((pass == null) ? 0 : pass.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (nick == null) {
            if (other.nick != null)
                return false;
        } else if (!nick.equals(other.nick))
            return false;
        if (pass == null) {
            if (other.pass != null)
                return false;
        } else if (!pass.equals(other.pass))
            return false;
        return true;
    }
}
