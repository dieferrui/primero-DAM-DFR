package programacion.tercera_evaluacion.encriptacion;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Pattern;

public class Encriptador {

    private static Scanner sc = new Scanner(System.in);
    static final Logger LOGGER = LogManager.getLogger(Encriptador.class.getName());
    private static StringBuilder sb = new StringBuilder("src/encriptacion/");
    private static final Pattern PATRON_TXT = Pattern.compile("[a-zA-Z]*[0-9]*.txt$");
    private static final int VALOR_MINIMO = 0;
    private static final int VALOR_MAXIMO = 800;
    private static final int VALOR_MEDIO = 500;

    public static void main(String[] args) {

        if (preguntarAccion().equalsIgnoreCase("encriptar")) {

            sb.append(seleccionarFicheroTrabajo(Boolean.TRUE));
        } else {
            sb.append(seleccionarFicheroTrabajo(Boolean.FALSE));
        }

        File file = new File(sb.toString());

        if (!file.exists()) {
            System.err.println("No se ha encontrado ningun archivo con ese nombre, se saldra del programa...");
            sc.close();
            System.exit(0);
        }

        int bytePalabra = Math.abs(introducirPalabraEncriptacion());

        if (bytePalabra >= VALOR_MINIMO && bytePalabra <= VALOR_MEDIO) {
            encriptacionSimple(file);
        } else if (bytePalabra > VALOR_MEDIO && bytePalabra <= VALOR_MAXIMO) {
            encriptacionBase64(file);
        } else encriptacionCipher(file);
    }

    public static String preguntarAccion() {

        String opcion = null;

        try {

            System.out.println("""
                    Bienvenido al Desencriptameitor
                    ¿Qué opción desea utilizar encriptar o desencriptar?
                    Escriba lo que desee:""");
            opcion = sc.next();

            while (!(opcion.equalsIgnoreCase("encriptar") || opcion.equalsIgnoreCase("desencriptar"))) {
                System.out.println("Seleccione una opcion correcta (encriptar o desencriptar)");
                opcion = sc.next();
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            LOGGER.error("Se ha producido un error en la entrada de datos, se saldrá del programa... ");
            LOGGER.error(e.getStackTrace());
            sc.close();
            System.exit(0);
        }
        return opcion;
    }

    public static String seleccionarFicheroTrabajo(Boolean encriptar) {

        String nombreFichero = "";
        try {

            System.out.print("Introduzca el nombre del archivo que se quiera usar: ");
            nombreFichero = sc.next();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.err.println("Ha ocurrido un error en la introduccion de datos, se saldra del programa...");
            //LOGGER.error(e.getStackTrace());
            sc.close();
            System.exit(0);
        }
        return nombreFichero + (encriptar ? ".txt" : ".crip");
    }

    public static void encriptacionSimple(File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            List<Integer> listaAscii = new ArrayList<>();
            int valorAscii;

            while ((valorAscii = bufferedReader.read()) != -1) {

                listaAscii.add(valorAscii);
            }

            if (PATRON_TXT.matcher(file.getName()).matches()) {
                String nuevaRuta = file.getParent() + "\\" + file.getName().substring(0, file.getName().indexOf(".")) + ".crip";
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nuevaRuta))) {

                    bufferedWriter.write(sumarRestarCodigo(listaAscii, Boolean.TRUE));
                }
                //LOGGER.info("Se ha creado el fichero .crip correctamente " + file.getAbsolutePath());
            } else {

                System.out.print("El fichero " + file + "tiene el contenido: \n" + sumarRestarCodigo(listaAscii, Boolean.FALSE));
            }
        } catch (IOException e) {
            System.err.println("No se ha acceder al archivo");
            //LOGGER.error(e.getStackTrace());
        }
    }

    public static void encriptacionBase64(File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String linea;

            if (PATRON_TXT.matcher(file.getName()).matches()) {
                String nuevaRuta = file.getParent() + "\\" + file.getName().substring(0, file.getName().indexOf(".")) + ".crip";
                List<String> textoEncriptado = new ArrayList<>();
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nuevaRuta))) {

                    while ((linea = bufferedReader.readLine()) != null) {
                        String lineaEncriptada = Base64.getEncoder().encodeToString(linea.getBytes());
                        textoEncriptado.add(lineaEncriptada);
                    }
                    for (String lineaNueva : textoEncriptado) {
                        bufferedWriter.write(lineaNueva + "\n");
                    }
                }
                //LOGGER.info("Se ha creado el fichero .crip correctamente " + file.getAbsolutePath());

            } else {

                StringBuilder sbDesencriptar = new StringBuilder();
                while ((linea = bufferedReader.readLine()) != null) {
                    try {
                        byte[] byteDecodeados = Base64.getDecoder().decode(linea);

                        String temp = new String(byteDecodeados);
                        sbDesencriptar.append(temp).append("\n");

                    } catch (IllegalArgumentException e) {

                        System.err.println("Ha ocurrido un error con la desencriptacion");
                        //LOGGER.error(e.getStackTrace());
                    }
                }
                System.out.println("El fichero " + file.getName() + " tiene el contenido\n " + sbDesencriptar);
            }

        } catch (IOException e) {
            System.err.println("No se ha podido encriptar el archivo");
            //LOGGER.error(e.getStackTrace());
        }
    }

    public static void encriptacionCipher(File file) {

        try {

            final String KEY = "thisisa128bitkey";
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");

            if (PATRON_TXT.matcher(file.getName()).matches()) {
                String nuevaRuta = file.getParent() + "\\" + file.getName().substring(0, file.getName().indexOf(".")) + ".crip";
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                try {

                    byte[] entradaByte = Files.readAllBytes(Paths.get(String.valueOf(sb)));
                    byte[] encriptadoByte = cipher.doFinal(entradaByte);
                    Files.write(Paths.get(nuevaRuta), encriptadoByte);

                    //LOGGER.info("Se ha creado el fichero .crip correctamente " + file.getAbsolutePath());

                } catch (IllegalBlockSizeException | BadPaddingException e) {
                    System.err.println("Ha ocurrido un error con la encriptacion");
                    //LOGGER.error(e.getStackTrace());
                }

            } else {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);

                byte[] entradaByte = Files.readAllBytes(Paths.get(String.valueOf(sb)));
                byte[] encriptadoByte = cipher.doFinal(entradaByte);
                System.out.println("El fichero " + file + " tiene este contenido:\n" + new String(encriptadoByte));

            }

        } catch (IOException e) {

            System.err.println("Ha habido un error al conectarse al fichero");
            //LOGGER.error(e.getStackTrace());

        } catch (NoSuchAlgorithmException e) {

            System.err.println("Ha ocurrido un error con la fomracion del algoritmo");
            //LOGGER.error(e.getStackTrace());

        } catch (NoSuchPaddingException e) {

            System.err.println("Ha ocurrido un error en la encriptacion");
            //LOGGER.error(e.getStackTrace());

        } catch (InvalidKeyException e) {

            System.err.println("Ha ocurrido un error en la creacion de la llave");
            //LOGGER.error(e.getStackTrace());

        } catch (IllegalBlockSizeException | BadPaddingException e) {

            System.err.println("ha ocurrido un error en la fomracion de la encriptaion");
            //LOGGER.error(e.getStackTrace());
        }
    }

    private static String sumarRestarCodigo(List<Integer> listaAscii, Boolean esEncriptar) {

        final Integer VALORENCRIPTACION = 1;

        StringBuilder sbFinal = new StringBuilder();

        for (Integer codigo : listaAscii) {
            char nuevoCaracter = (char) (esEncriptar ? codigo + VALORENCRIPTACION : codigo - VALORENCRIPTACION);
            if (codigo == 11 || codigo == 10) {
                sbFinal.append("\n");
            } else sbFinal.append(nuevoCaracter);
        }
        return String.valueOf(sbFinal);
    }

    public static int introducirPalabraEncriptacion() {

        String palabraEncriptacion = null;
        int byteTotales = 0;

        try {
            System.out.print("Introduzca la palabra de encriptacion: ");
            palabraEncriptacion = sc.next();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.err.println("Ha ocurrido un error en la introduccion de datos, se saldra del programa...");
            System.exit(0);
            //LOGGER.error(e.getStackTrace());
        } finally {
            sc.close();
        }

        try {
            if (palabraEncriptacion == null) {

                throw new NullPointerException("No se ha introducido ninguna palabra de encriptacion, se saldra del programa...");
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            //LOGGER.error(e.getStackTrace());
            sc.close();
            System.exit(0);
        }

        byte[] palabraEncriptacionBytes = palabraEncriptacion.getBytes();
        for (byte palabraEncriptacionByte : palabraEncriptacionBytes) {
            byteTotales += palabraEncriptacionByte;
        }

        return byteTotales;
    }
}