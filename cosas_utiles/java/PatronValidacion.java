package java;

public enum PatronValidacion {
    // Ejemplos previos
    NOMBRE_APELLIDOS("^[a-zA-ZáéíóúÁÉÍÓÚüÜ]+(?:-[a-zA-ZáéíóúÁÉÍÓÚüÜ]+)?(\\s+[a-zA-ZáéíóúÁÉÍÓÚüÜ]+(?:-[a-zA-ZáéíóúÁÉÍÓÚüÜ]+)?)?\\s*,\\s*[a-zA-ZáéíóúÁÉÍÓÚüÜ]+(?:-[a-zA-ZáéíóúÁÉÍÓÚüÜ]+)?$", "Introduzca su nombre y apellido (Apellido1 Apellido2, nombre):"),
    CORREO("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", "Introduzca su correo electrónico (nombre_usuario@dominio):"),
    DIRECCION_IP("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", "Introduzca su dirección IP:"),
    CONTRASENYA("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", "Introduzca su contraseña:"),
    NUMERO_TELEFONO("^\\+?[0-9]{8,15}$", "Introduzca su número de teléfono:"),
    NICK("^[a-z0-9_]+$", "Introduzca su nick:"),
    CODIGO_POSTAL("^[0-9]{5}$", "Introduzca su código postal (5 dígitos):"),
    FECHA_DDMMYYYY("^(0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[012])[-/.](19|20)\\d\\d$", "Introduzca la fecha (DD-MM-YYYY):"),
    FECHA_MMDDYYYY("^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$", "Introduzca la fecha (MM-DD-YYYY):"),
    TARJETA_CREDITO_VISA("^4[0-9]{12}(?:[0-9]{3})?$", "Introduzca su número de tarjeta de crédito (Visa):"),
    TARJETA_CREDITO_MASTERCARD("^5[1-5][0-9]{14}$", "Introduzca su número de tarjeta de crédito (MasterCard):"),
    TARJETA_CREDITO_AMEX("^3[47][0-9]{13}$", "Introduzca su número de tarjeta de crédito (American Express):"),
    TARJETA_CREDITO_DISCOVER("^6(?:011|5[0-9]{2})[0-9]{12}$", "Introduzca su número de tarjeta de crédito (Discover):"),
    URL("^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", "Introduzca una URL válida (http://www.example.com):"),
    DIRECCION_MAC("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$", "Introduzca su dirección MAC (00:1A:2B:3C:4D:5E):"),
    HORA_24H("^(?:[01]\\d|2[0-3]):(?:[0-5]\\d):(?:[0-5]\\d)$", "Introduzca la hora en formato 24h (HH:MM:SS):"),
    HORA_12H("^(0[1-9]|1[0-2]):([0-5]\\d):([0-5]\\d) (AM|PM)$", "Introduzca la hora en formato 12h (HH:MM:SS AM/PM):"),
    COLOR_HEX("^#(?:[0-9a-fA-F]{3}){1,2}$", "Introduzca un color en formato hexadecimal (#FFFFFF):"),
    NUMERO_ENTERO("^-?\\d+$", "Introduzca un número entero:"),
    NUMERO_DECIMAL("^-?\\d*\\.\\d+$", "Introduzca un número decimal:"),
    UUID("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$", "Introduzca un UUID (8-4-4-4-12):"),
    MATRICULA_COCHE("^[0-9]{4}[-\\s]?[A-Z]{3}$", "Introduzca su matrícula de coche (1234 ABC):"),
    NOMBRE_USUARIO_COMPLEJO("^[a-zA-Z0-9._-]{3,16}$", "Introduzca un nombre de usuario (3-16 caracteres, puede incluir letras, números, puntos, guiones bajos y guiones):"),
    DOMINIO("^(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,}$", "Introduzca un nombre de dominio válido (ej. example.com):"),
    CEDULA_PASAPORTE("^[A-Z0-9]{5,20}$", "Introduzca su cédula o pasaporte (5-20 caracteres alfanuméricos):"),
    PLACA_VEHICULO("^[A-Z]{3}-\\d{3}$", "Introduzca su placa de vehículo (ej. ABC-123):"),
    NOMBRE_EMPRESA("^[a-zA-Z0-9 &.,'-]+$", "Introduzca el nombre de la empresa (puede incluir letras, números, espacios, y ciertos caracteres especiales):"),
    CODIGO_SEGURO_SOCIAL("^(?!000|666|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$", "Introduzca su número de Seguro Social (SSN):"),
    FECHA_ISO_8601("^\\d{4}-\\d{2}-\\d{2}$", "Introduzca la fecha en formato ISO 8601 (YYYY-MM-DD):"),
    DIRECCION_POSTAL("^[a-zA-Z0-9 \\-\\.,]+$", "Introduzca su dirección postal (puede incluir letras, números, espacios, y ciertos caracteres especiales):"),
    NIA("^\\d{8}$", "Introduzca su NIA (8 dígitos):"),
    DNI("^[0-9]{8}[A-Z]$", "Introduzca su DNI (8 dígitos seguidos de una letra):");

    private final String regex;
    private final String mensaje;

    PatronValidacion(String regex, String mensaje) {
        this.regex = regex;
        this.mensaje = mensaje;
    }

    public String getRegex() {
        return regex;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean validar(String cadena) {
        return cadena.matches(regex);
    }

    public static void main(String[] args) {
        String[] cadenas = {
                "García-Márquez, Gabriel", "usuario@example.com", "192.168.0.1",
                "Password123!", "+1234567890", "user_name", "28080",
                "31-12-2020", "12-31-2020", "4111111111111111", "5105105105105100",
                "378282246310005", "6011111111111117", "http://www.example.com",
                "00:1A:2B:3C:4D:5E", "23:59:59", "12:59:59 PM", "#FF5733",
                "12345", "-1234.56", "123e4567-e89b-12d3-a456-426614174000", "1234 ABC",
                "usuario_complejo-123", "example.com", "A123456789", "ABC-123",
                "Empresa & Co.", "123-45-6789", "2024-05-21", "123 Main St.",
                "12345678", "12345678Z"
        };

        for (PatronValidacion patron : PatronValidacion.values()) {
            for (String cadena : cadenas) {
                if (patron.validar(cadena)) {
                    System.out.println(cadena + " valida para " + patron.name() + " con mensaje: " + patron.getMensaje());
                }
            }
        }
    }
}