# Software de java

## JRE (Java Runtime Environment):

El JRE es un conjunto de software que proporciona todos los recursos necesarios para ejecutar una aplicación Java, pero
no para desarrollarla. Incluye la Máquina Virtual de Java (JVM), bibliotecas de clases Java (como las clases del paquete
Java Standard Edition), y otros archivos necesarios para ejecutar aplicaciones Java.
El JRE es necesario para ejecutar aplicaciones Java en un entorno de producción, pero no es suficiente si estás
desarrollando software en Java.

## JDK (Java Development Kit):

El JDK es un conjunto más completo de herramientas para desarrollar aplicaciones Java.
Incluye el JRE, pero además proporciona compiladores y herramientas de depuración (como javac y jdb), bibliotecas
adicionales, y documentación. Es necesario tener instalado el JDK si deseas escribir, compilar y ejecutar programas
Java. Además, el JDK incluye el JRE, por lo que, al instalar el JDK, también obtienes la capacidad de ejecutar
aplicaciones Java.

## JVM (Java Virtual Machine):

La JVM es una máquina virtual que ejecuta el código bytecode generado por el compilador Java (javac).
La JVM es una parte integral del JRE y del JDK. Es responsable de ejecutar programas Java de manera independiente de la
plataforma, lo que significa que puedes escribir un programa Java una vez y ejecutarlo en cualquier dispositivo o
sistema operativo que tenga una JVM compatible.
La JVM interpreta y ejecuta el bytecode, proporcionando así la capacidad de "write once, run anywhere" (escribir una
vez, ejecutar en cualquier lugar).

## SINTAXIS

```java
public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

Cada aplicación empieza con un nombre de clase que debe coincidir con el nombre del archivo: public class NombreArchivo

## Método principal:

### Main:

main() es un método obligatorio y está en todos los programas:
public static void main(String[] args)

### Static

Indica que el método es estático y permite acceder a las variables y métodos, aunque no tengamos una instancia del
objeto que los contiene

Public
Indica que el campo es accesible desde cualquier clase
Clase(class)

println:
Para imprimir una línea de texto en pantalla usamos el método println():
System.out.println("Hola mundo")
Comentario:
Para poner un comentario en el código sin que afecte al mismo se usa // :
// Comentario
System.out.println("Hello World"); // Comentario
Para introducir comentarios de varias líneas se usa /* y se cierra con */:

```java
/* HOLAAAAAAAAAAAAAAAAAAAAAAAAAAA
AAAAAAAAAAAAAAA */
System.out.println("Hello World");
```

# VARIABLES DE JAVA:

Las variables con contenedores para almacenar valores

### Sintaxis:

```java
tipo variable = valor;
```

También puedes declarar una variable sin asignar el valor y asignar el valor más tarde:
tipo variable;
variable = valor;

### String:

Almacena texto: “Hola”

```java
String nombre = "Angel";
```

### int:

Almacena números enteros: 9/10/34

```java
int Num = 15;
```

### float:

Almacena números de coma flotante: 5,88/-5,88

```java
float numf = 4.2;
```

### char:

Almacena caracteres individuales: ‘a’/’B’

```java
char Letra = 'A’;
```

### boolean:

Almacena valores con dos estados: Verdadero o falso

```java
Boolean bool = false;
````

## Variables globales y locales

En java el alcance de las variables puede variar en función de donde y como estén declaradas

### Variables globales:

Son variables que están declaradas fuera de los métodos y, por tanto, son accesibles desde cualquier parte de la clase.

### Variables locales:

Son aquellas que están creadas dentro de los métodos y solo se pueden utilizar dentro de ellos.

# INTRODUCIR PARÁMETROS POR LÍNEA DE COMANDOS

Se usa la clase Scanner para obtener información directamente del usuario introduciendo datos mediante el teclado.
Sintaxis:

```java
import java.util.Scanner; // Importa la clase Scanner

class MyClass {
    public static void main(String[] args) {
        Scanner nombre = new Scanner(System.in);  // Crea un objeto Scanner
        System.out.println("Introduce el nombre de usuario");

        String usuNombre = nombre.nextLine();  // Lee el texto introducido por el usuario
        System.out.println("El nombre de usuario es: " + usuNombre);  // Output user input
    }
}
```

La entrada puede variar dependiendo del tipo de dato:

- nextBoolean(): Lee un valor booleano del usuario
- nextByte(): Lee un valor de byte del usuario
- nextDouble(): Lee un valor doble del usuario
- nextFloat(): Lee un valor flotante del usuario
- nextInt(): Lee un valor int del usuario
- nextLine(): Lee un valor de cadena del usuario
- nextLong(): Lee un valor largo del usuario
- nextShort(): Lee un valor corto del usuario

# OPERADORES

## Operadores aritméticos

Los operadores aritméticos sirven para realizar operaciones con variables y valores:

- `+`: suma dos valores
- `-`: Resta dos valores
- `*`: Multiplica dos valores
- `/`: Divide dos valores
- `%`: Devuelve el resto de una división entre dos valores
- `++`: Incrementa en 1 un valor
- `--`: Disminuye en 1 un valor

### Sintaxis:

```java
int x = 100 + 50;
int y = x--;
```

## Operadores de asignación

- `=` (`x = 3`): `x = 3`
- `+=` (`x += 3`): `x = x + 3`
- `-=` (`x -= 3`): `x = x - 3`
- `*=` (`x *= 3`): `x = x * 3`
- `/=` (`x /= 3`): `x = x / 3`
- `%=` (`x %= 3`): `x = x % 3`
- `&=` (`x &= 3`): `x = x & 3`
- `|=` (`x |= 3`): `x = x | 3`
- `^=` (`x ^= 3`): `x = x ^ 3`
- `>>=` (`x >>= 3`): `x = x >> 3`
- `<<=` (`x <<= 3`): `x = x << 3`

## Operadores de comparación

- `==` (`x == y`): Igual
- `!=` (`x != y`): No igual
- `>` (`x > y`): Mayor que
- `<` (`x < y`): Menor que
- `>=` (`x >= y`): Mayor o igual que
- `<=` (`x <= y`): Menor o igual que

## Operadores lógicos

- `&&` (`x<5 && 1<10`): Devuelve el valor verdadero si las dos declaraciones son verdaderas
- `||` (`x<5 || 1<10`): Devuelve el valor verdadero si una declaración es verdadera
- `!` [`!`(`x < 5 && x < 10`)]: Invierte el resultado, devuelve falso si el resultado es verdadero

# MÉTODOS

En java un método es un conjunto de instrucciones definidas en una clase que realizan tareas y se invocan mediante
nombres. Consta de tres partes:

- Firma: El nombre y parámetros del método
- Cuerpo: Conjunto de instrucciones que posee el método
- Valor de retorno: Hay ciertos métodos que devuelven valores

```java
tipoDeAcceso modificador;

tipoMétodo nombreMétodo(tipoArg arg) {
    declaración de variables globales;
    código del método;
}
```

```java
public static void metodoEjemplo(String ejemplo) {
    System.out.println(ejemplo);
}
```

## Usos

- Reutilización del código: Permite llamar el vario método varias veces para evitar repetir código
- Organización: Ayudan a dividir el código en bloques más pequeños
- Abstracción: Permiten encapsular la lógica dentro de una interfaz simple
- Lectura: Al usar nombres descriptivos se mejora la legibilidad.

## Métodos con retorno

Los métodos con tienen un tipo de dato de retorno especifico declarado. Se utiliza la palabra return para devolver un
valor.

```java
tipoDeAcceso tipoDato

nombreMetodo(parametros) {
    código;
    return valor;
}
```

```java 
public int sumar(int a, intb) {
    Suma = a + b;
    Return suma;
}
```

En los métodos sin retorno se usa void como tipo de dato para indicar que no va a devolverse nada.

## Paso de parámetros

A los métodos se le pasan parámetros con los que pueden realizar tareas. Existen dos formas:

### Por valor:

En el paso por valor se crea una declaración del parámetro introducido, dentro del método, la declaración puede tener un
valor distinto al que tenía antes y solo tendrá efecto el cambio dentro del propio método ya que esa declaración no
afecta a la que existe fuera del método ya que está separada.

### Por referencia:

En el paso por referencia se llama al parámetro introducido, haciendo referencia directamente al mismo, por tanto, los
cambios realizados dentro del método quedan vigentes en el parámetro al acabarse el método.

### Sobrecarga de métodos

La sobrecarga de métodos permite definir varios métodos con el mismo nombre en una clase pero con diferentes listas de
parámetros. Por tanto la acción que realizara dependerá de los parámetros que se le pasen. Ej:

```java
public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

}
```

# STRINGS DE JAVA

Los Strings son variables que almacenan texto. Contiene un conjunto de caracteres rodeados por comillas:

```java
String saludo = "Hola";
```

Los String en java son objetos, que contienen métodos que realizan operaciones en los Strings

## Métodos:

Un método es un conjunto de instrucciones definidas dentro de una clase, que realizan tareas determinadas y que se
pueden invocar con un nombre. La sintaxis para usar métodos es:

```java
variable.método();
```

## length

El método length indica el número de caracteres de un String:

```java
String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
System.out.println("El abecedario tiene: "+abc.length() +”letras”);
```

## toUpperCase() y toLowerCase()

- toUppercase: Cambia el texto a mayúscula
- toLowerCase: Cambia el texto a minúscula

```java
String txt = "Hola mundo";
System.out.

println(txt.toUpperCase()); // Devuelve "HOLA MUNDO"
        System.out.

println(txt.toLowerCase()); // Devuelve "hola mundo "
```

## IndexOf()

El método indexOF devuelve la primera posición de un texto específico en una cadena incluyendo los espacios en blanco

```java
  String txt = "Please locate where 'locate' occurs!";
  System.out.

println(txt.IndexOf("locate")); // Outputs 7
```

## Concatenación de cadenas

El operador + Se puede usar para concatenar textos:

```java
String nombre = "Ángel";
String Apellido = "Marco";
System.out.println(nombre +" "+Apellido);
```  

También se puede usar el método concat() para concatenar Strings:

```java
String nombre = "Ángel";
String Apellido = "Marco";
System.out.

println(nombre.concat(Apellido));
```

## Caracteres especiales

Los Strings se escriben en declaraciones que están delimitadas por comillas (“), por tanto, si un texto incluye
comillas puede dar lugar a errores:

- `\’`: `‘`
- `\”`: `“`
- `\\`: ``\``

## Math

Es una clase que contiene un conjunto de métodos para realizar cálculos matemáticos

### Math.max(x,y)

Es un método para encontrar el número más grande en una lista
Math.max(5, 10); \\Devuelve 10

### Math.min(x,y)

Es un método para encontrar el número más pequeño en una lista
Math.min(5, 10); \\Devuelve 5

### Math.random()

Devuelve un número aleatorio entre 0 y un número concreto:

```java
int numRandom = (int) (Math.random() * 10);
```

Devuelve un número aleatorio entre dos números determinados:

```java
int numRandom = (int) (Math.random(numMayor – numMenor + 1)) + numMenor;
```

### Math.round()

Redondea un número con decimales
Math.round(número * 100.0) / 100.0

El número de 0 es igual al número decimales que quieras poner

Math.pow()
Eleva una base a un exponente
Math.pow(base, exponente)

Booleans
Son valores que solo pueden ser o verdaderos o falsos
Expresiones booleanas
Es una expresión de Java que devuelve un valor booleano. Se pueden usar operadores de comparación
int x = 10;
int y = 9;
System.out.println(x > y); //Devuelve true

DECIMALFORMAT

```java
import java.text.DecimalFormat;

public class LimitarDecimales {
    public static void main(String[] args) {
        double numero = 123.456789;

        // Especificar el formato deseado con dos decimales
        DecimalFormat formato = new DecimalFormat("#.##");

        // Formatear el número
        String numeroFormateado = formato.format(numero);

        // Convertir el número formateado de nuevo a un double
        double numeroLimitado = Double.parseDouble(numeroFormateado);

        System.out.println("Número original: " + numero);
        System.out.println("Número con dos decimales: " + numeroLimitado);
    }
}
```

# FINAL

Final es una palabra clave que indica que un elemento (clase, método o variable) no se puede cambiar:

## Clases:

Cuando se aplica Final a una clase, esta no puede tener subclases, es decir, que es útil cuando vas a crear clases sin
subclases y se busque evitar que puedan

```java
final class claseEjemplo {
}
```

## Métodos:

Al aplicar Final a un método, se evita que ese método pueda ser sobreescrito por las subclases, lo cual permite crear
métodos que van a actuar siempre igual en las subclases que lo hereden sin que pueda ser sobreescrito ni cambiado.

## Variables:

Una variable final hace que no pueda cambiar la referencia a un objeto, no hace que un objeto sea inmutable, sino que la
referencia a ese objeto lo sea y en caso de que se haga en un objeto cuyo tipo de valor sea inmutable (ejemplo: objetos
de valores primitivos) este no cambiara su valor. Es decir, hace que los objetos de valor inmutable sean inmutables y
que objetos mutables no puedan se puedan volver a instanciar, pero sí cambiar sus valores.

# STATIC

Clases:
En java las clases no se pueden declarar como estáticas ya que están de forma natural en esa jerarquía, pero se pueden
crear clases internas

Métodos:
Cuando un método es estático, este método se puede usar directamente en la clase sin instanciar un objeto de la clase,
es decir, permite crear métodos de clase.

Variables:
Una variable estática

# Estructura de control de flujo

## IF … ELSE

Establece una condición y una acción en caso de que se cumpla o no esa condición:

- If: Establece el código que se ejecutara en caso de que se cumpla una condición
- Else: Establece el código que se ejecutara en caso de que no se cumpla la condición establecida en el if
- Else if: Establece otro if en caso de que no se cumpla la condición establecida en el if
```java
if (x<y) {
  System.out.print(“y es mayor que X”)
} else if (x==y) {
  System.out.print(“y es igual a X”)
} else {
  System.out.print(“x es mayor que y”)
}
```

## SWITCH

Sirve para elegir un bloque de código concreto en un caso determinado

```java
switch(expression) {
case x:
// bloque de código
break;
case y:
// bloque de código
break;
default:
// bloque de código
}
```


# BUCLES

Ejecutan un bloque de código repetidamente hasta o mientras se cumpla una condición.

## While

Recorre un bloque de código mientras se cumpla una condición:

```java
int i = 0;

while(i< 5){
    System.out.println(i);
    i++;
}
```

## Do…while

Es una variante del bucle while, que ejecuta el bloque una vez antes de comprobar si la condición es verdadera, y luego
se repetirá el bucle mientras la condición se esté cumpliendo

```java
int i = 0;

do{
    System.out.println(i);
    i++;
}while(i< 5);
```

## For

Se usa cuando sabes cuantas veces quieres repetir un bloque de código:

```java
for(declaracion1;declaracion2;declaracion3){
// bloque de código a ejecutar
        }
```

- La declaración 1 se ejecuta (una vez) antes de la ejecución del bloque de código.
- La declaración 2 define la condición para ejecutar el bloque de código.
- La declaración 3 se ejecuta (cada vez) después de que se haya ejecutado el bloque de código.

El siguiente ejemplo imprimirá los números del 0 al 4:

```java
for(int i = 0; i< 5; i++){
    System.out.println(i);
}
```

# CASTING

Operación que permite realizar una conversión entre diferentes tipos de variables

## Casting implícito

Cuando el tipo de dato de destino es mayor en memoria que el del tipo de origen

`byte -> short -> char -> int -> long -> float -> double`

```java
int datoInt = 9;
double datoDouble = datoInt;
```

## Casting explícito

Cuando el tipo de dato de destino es menor en memoria que el del tipo de origen

`double -> float -> long -> int -> char -> short -> byte`

```java
double datoDouble = 9.78d;
int datoInt = (int) datoDouble;
```

# PARSE

Es un método que consiste en cambiar el tipo de dato a una cadena de texto

### Sintaxis

```java
String texto = “Texto”;
Tipo cambio = Nombretipo.parsetipo(texto);
System.out.println(cambio);
```

ParseInt:
String fecha = “2005”;
Int numero = Integer.parseInt(fecha);
System.out.println(“El año de nacimiento es: ”+numero);

# ARRAYS

Los arrays se usan para almacenar valores múltiples en una sola variable, sin tener que declarar variables con valores
separados. Para declarar un array, se define el tipo de variable con corchetes:
```java 
String  []  juegos;
```
Para insertar valores en el array hay dos formas distintas:

- Añadir directamente los datos al array:
```java
String [] juegos = {“Nintendo”, “Xbox” } ;//Array de cadenas
int[] numeros = {10, 20, 30}; //Array de enteros
```
- Establecer previamente el tamaño del array
```java 
int [] numero = new int [7]; //Establece que el array tiene 8 espacios (0-7)
numero[0] = 54; //Añade 54 en la posición 0 del array
numero[1] = 43; //Añade 43 en la posición 1 del array
```

## Acceder a los datos
Para acceder a los datos de un array se hace referencia a su número índice

```java 
String[] coches = {"Volvo", "BMW", "Ford", "Mazda"};
System.out.println(coches[0]);
// Devuelve Volvo
```
Cambiar datos de un array:

Para cambiar un dato específico de un array, tienes que llamar al array y al número de índice del dato que quieras 
cambiar (Esto corresponde a la segunda forma de insertar valores):

```java 
coches [3] = “Opel” // Cambiaría el cuarto dato de la lista (comienza a partir de 0) a Opel
```
## Métodos
Sintaxis:
```java 
Arrays.método(array);
```
## Arrays:

Para poder usar la clase Arrays y sus métodos se debe importar
```java 
import java.util.Arrays;
```
## toString():

Es un método que devuelve una cadena de texto del array que selecciones

```java 
int[] numeros = {4, 2, 3, 1, 7};

System.out.println(Arrays.toString(numeros));
```
## copyOf():

Se usa para copiar los elementos de un array en otro

```java 
int[] numeros = {2, 1, 7, 1, 9};
int[] numeros2 = Arrays.copyOf(numeros, numeros.length);

System.out.println(Arrays.toString(numeros2));
```
## copyOfRange():
Se usar para copiar un rango concreto de elementos de un array

```java 
int[] numeros = {2, 1, 6, 8, 3};
int[] range = Arrays.copyOfRange(numeros, 1, 4); //Se especifica el array, la posición inicial y la posición final

System.out.println(Arrays.toString(range));
```
## equals():
Se usa para comprobar si dos arrays son iguales
```java 
int[] numeros = {1, 8, 5, 4, 3};
int[] numerosIguales = {3, 2, 7, 1, 3};

boolean comparacion = Arrays.equals(numeros, numerosIguales);
```

## sort():
Sirve para ordenar una array
```java 
int[] numeros = {52, 22, 58, 15, 31};
Arrays.sort(numeros);
```
### sort con índices
Sirve para ordenar un rango de elementos de una array
```java
int[] numeros = {9, 5, 2, 7, 5, 8, 3, 9, 7};

Arrays.sort(numeros, 0, 2); //Se especifica el array, la posición inicial y la posición final
System.out.println(Arrays.toString(numeros));
```
# ARRAYS BIDIMENSIONALES (2D)
Son array que se componen y organizan mediante filas y columnas. Se usan cuando se necesita tener la información
organizada de forma determinada
## Sintaxis:
Para introducir directamente los datos en el array:
```java 
int[] [] numeros = {
{1, 2, 3 },
{4, 5, 6 },
{7, 8, 9 },
{10, 11, 12 },
};
```
Para establecer previamente el tamaño del array:
```java 
int[] [] numeros= new int[3] [4]; //Indica que el tamaño va a ser de 4 filas y 5 columnas
```
Para determinar el número de columnas de cada fila:
```java 
int[] [] nArray = new int [3] [];
nArray[0] = new int[4]
```
Para introducir datos en una posición concreta:
```java 
int [] num1 = Arrays.copyOf(numeros, numeros.length + 1;
int valor = 5;
num1 [numeros.length] = valor;
```
# ARRAYLIST
La clase Arraylist, es una matriz de datos, pero, a diferencia de Array, es dinámica ,por tanto, se le pueden añadir
datos sin definir su tamaño y se pueden añadir datos de forma indefinida durante la ejecución del programa ya que su
tamaño se ajusta de automáticamente
```java 
ArrayList<tipoDato> nombreArraylist = new ArrayList<>();

nombreArraylis.add(dato1);
nombreArraylis.add(dato2);

Arraylist<String> listaNombres = new Arraylist<>();
listaNombres(“Pablo”);
listaNombre(“Pedro”);
```
Para utilizarlo hace falta importar la clase ArrayList:
```java 
import java.util.ArrayList;
```
Métodos:

- `.add`: Añade un dato
- `.remove`: Elimina un dato
- `.get`: Permite acceder a un dato
- `.set`: Modifica un dato
- `.clear`: Borra todo el contenido del ArrayList
- `.size`: Devuelve el tamaño del ArrayList

```java 
nombreArrayList.metodo();
listaNombres.add(“Angel”);
```
# MÉTODOS IMPORTANTES

## toString:
Devuelve una cadena de texto sobre un objeto, es decir, un texto que da información del estado actual de un objeto

## equals:
Es un método que sirve para comparar dos objetos y determinar si son o no iguales

## hashCode:
HashCode es un método que se encarga de devolver un valor numérico calculado mediante la dirección de memoria de un
objeto, es decir, que objetos diferentes tienen diferente hashcode aunque tengan los mismos valores

## getclass():
Devuelve una representación de la clase del objeto sobre el cual usemos el método. Nos permite acceder a ciertas
características del objeto: nombre de la clase, nombre de la superclase y nombres de interfaces que implementa

## INSTANCEOF() ISINSTANCE
Son métodos que sirven para determinar si un objeto es una instancia de una clase o no.

### isInstance():
Es un método propio de Java que devuelve un booleano y comprueba si un objeto es de una clase concreta.

```java 
Clase nombreObjeto;
Boolean nombreBoolean = nombreClase.isInstance(nombreObjeto);

Object obj = "Hola mundo";

// Verificar si obj es una instancia de la clase String
boolean esString = String.class.isInstance(obj);
```
En caso de que un objeto pertenezca a una subclase de la clase a comprobar, devolverá true

### instanceOf:
Es un operador que sirve para comprobar si un objeto es una instancia de una clase
```java
nombreObjeto instanceOf Clase;
obj instanceOf String;
```

Solo se puede usar entre objetos que hereden de la misma clase o que estén relacionados, es decir, entre objetos de la
misma clase y que hereden de la misma clase

# ABSTRACCIÓN

La abstracción es un proceso en el que representa un sistema complejo de forma conceptual. Implica identificar las
partes que componen un concepto (aparatos, vehículos, animales…) y representarlas.

## Clases Abstractas:
Las clases abstractas son aquellas que se utilizan para definir conceptos muy generales (Vehiculo, animal, planta…) y
que pueden derivar en conceptos más concretos (Coche, Pajaro, Arbol). No tienen una implementación directa en el código
y definen los atributos y métodos que vayan a tener las subclases. Tienen varias reglas:

- No pueden ser instanciadas
- Se declara la existencia de métodos, pero no su implementación
- Al menos uno de sus métodos debe ser abstracto
- Deben ser public o protected
- Se pueden crear varias subclases

En resumen son clases Padre (o superclases) que representan conceptos generales que poseen subclases que representan
conceptos más concretos y no se pueden implementar.

```java
public abstract class Animal {
    public String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void hacerSonido();

}

class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    public void hacerSonido() {
        System.out.println(nombre + " dice: Guau!");
    }

}
```

# ENCAPSULACIÓN

Es la práctica por la que se separan del resto del código atributos y funcionalidades específicas de los objetos.
Consiste en agrupar los datos e impedir el acceso del usuario, se usan los modificadores de acceso y los métodos getter
y setter.

## Modificadores de acceso:

- Public: Permite que se pueda acceder desde cualquier otra clase.
- Protected: Solo permite que puedan acceder clases del mismo paquete (package) y las que heredan de ella.
- Private:  Solo permite acceder desde la misma clase

## Métodos Get y Set:
Son métodos que permiten acceder a un dato de un objeto y modificarlo:

- `Get`: Sirve para acceder al dato del objeto.
```java 
Objeto.getNombre(); //Devuelve el nombre del objeto
```
- `Set`: Sirve para modificar el dato objeto.
```java 
Objeto.setNombre(“Hola”); //Cambia el nombre del objeto a “Hola”
```
# HERENCIA

La herencia, permite que las subclases hereden los atributos y métodos de la clase padre, para poder definir métodos y
atributos comunes entre varias clases

## Tipos de herencia:

- Única: Una subclase hereda de la clase padre (Animal > Pajaro)
- Múltiple: Una subclase hereda de otra subclase que a su vez hereda de una clase padre (Vehículo, Vehículo a motor,
  Coche)

```java
 public class Animal {
    String nombre;
    int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void comer() {
        System.out.println("El animal está comiendo.");
    }

    public void dormir() {
        System.out.println("El animal está durmiendo.");
    }
}
```

Para que una clase hereda de otra se usa la palabra clave extends:

```java
class Perro extends Animal {
    String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);  // Llama al constructor de la clase padre (Animal)
        this.raza = raza;
    }

    public void ladrar() {
        System.out.println("Guau! Guau!");
    }
}
```

## Herencia de métodos
Una subclase no tiene porque sobrescribir todos los métodos de la clase padre, sin embargo, siempre y cuando no estén
marcados como Final en la clase padre tendrá que sobrescribirlos si los usa

# POLIMORFISMO

Es el concepto de que un objeto puede comportarse de diferentes formas dependiendo del contexto. Para aplicar dicho
concepto se suelen usar las clases abstractas e interfaces.

Clases Abstractas:

```java
abstract class Figura {

    abstract double calcularArea();

    void mostrarInformacion() {
        System.out.println("Esta es una figura.");
    }
}

class Circulo extends Figura {
    double radio;

    Circulo(double radio) {
        this.radio = radio;
    }

    @Override
        //Se sobreescrive el método heredado
    double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo extends Figura {
    double longitud;
    double anchura;

    Rectangulo(double longitud, double anchura) {
        this.longitud = longitud;
        this.anchura = anchura;
    }

    @Override
//Se sobreescrive el método heredado
    double calcularArea() {
        return longitud * anchura;
    }
}
```

Aquí se aplica el polimorfismo porque se calcula el área de distintas formas

# INTERFACES

Es una clase de la cual no se pueden crear instancias y permiten que otras clases implementen sus métodos. Se declaran
usando la palabra clave interface. Pueden estar compuestas únicamente por métodos y constantes

```java 
public interface IEjemplo {
	void método();
}
```
- Sus métodos son implícitamente abstractos (No es necesario especificarlo)
- Las clases que los implementan deben sobrescribir todos sus métodos
- Sus variables y atributos son implícitamente constantes (No es necesario especificarlo)
- Una clase puede extender de una sola clase, pero implementar varias interfaces
- Para que una interfaz herede de otra se usa la palabra clave extends
## Default:
  Los métodos que incluyen default, especifican una funcionalidad por defecto en la interfaz que depende solo de ella.
  Tienen una implementación en la propia interfaz lo cual permite cambiar el método sin afectar a las clases que la
  implementan. Es un método que no va a variar en ninguna clase que lo implemente porque solo depende de su interfaz.

## Static:
Los métodos estáticos en las interfaces pertenecen a la interfaz en sí misma y no pueden ser sobrescritos ni
implementados por las clases que la implementan, se pueden utilizar sin crear una instancia de la interfaz y solo
afectan al funcionamiento y comportamiento de la interfaz ya que no se pueden implementar.

# INMUTABILIDAD DEL CÓDIGO

La inmutabilidad del código es la capacidad de un objeto para no cambiar después de ser creados.
Código inmutable:
Las clases inmutables se crean de forma que los objetos no pueden cambiar después de ser creados:

- Clases de datos primitivos: El valor de los datos primitivos no se puede cambiar, sin embargo, puedes crear una nueva
  instancia de un dato primitivo con valores distintos.
- Clases de datos complejos: Al igual que con los datos primitivos puedes instanciar a la variable con un valor distinto
- Clases de fecha y tiempo
- Enumeraciones
## Clone:
  Creas una copia del objeto con un hashcode diferente

# CLASES Y OBJETOS

Las clases y objetos sirven para modelar entidades de la vida real en un programa con sus acciones y atributos
## Clases
En java una clase es una estructura a partir de la cual se van a crear objetos. Define las propiedades y acciones (
métodos) que van a poseer los objetos y actúa como un molde para los objetos:
```java 
Class Objeto {
String Atributo1;
String Atributo2; // Los atributos pueden ser de distintos tipos
Int Atributo3;
}
```
## Objetos
Los objetos son instancias de una clase y representan una entidad de esa clase
```java 
Objeto objeto1 = new Objeto(“Parametro1”, ”Parametro2”, 3);
// Declara los objetos con los atributos
```
## Constructor
Es un método especial que se invoca al declarar un objeto de una clase .Cuya función es inicializar los atributos de la
clase:

- Su nombre ha de ser igual al de la clase
- No tienen retorno (Pero no es necesario usar void)
- Se declaran públicos para ser accedidos desde otras clases
- Si no se introducen valores en un constructor se iniciara con el valor predeterminado

```java 
public Coche(String marca, String modelo, String color){
  this.marca = marca;
  this.modelo = modelo;
  this.color = color;
}
```
## This
Es una palabra que hace referencia al atributo de la clase para distinguirlo del parámetro

# IMPORT Y PACKAGE

Para poder acceder a clases que se encuentran en otros archivos o carpetas se usan las palabras clave import y package.

## Import:

Permite usar una clase que se encuentre en otro paquete (package);

```java 
import carpeta1.carpeta2.nombreClase;

import Java.util.Scanner;
```
## Package:

Permite que se pueda acceder al paquete en el que se encuentra una clase para poder utilizarla
Package nombreDelPaquete;
Los nombres son mayoritariamente en minúscula

# PILA Y RECURSIVIDAD

La pila es una estructura de datos que sigue el principio de “último en llegar, primero en salir”. Se utiliza para
almacenar datos temporales (variables locales, registros de llamada a métodos) cada vez que se llama a un método se crea
un marco de pila para ese método en la pila.

## Recursividad
La recursividad es un concepto donde una función se llama a sí misma para resolver un problema más pequeño del mismo
tipo

# EXCEPCIONES
En java, una excepción es un evento que interrumpe el flujo del funcionamiento del programa, que puede ser resultado de 
un fallo en el funcinamiento del programa o creada por el desarrollador. Pueden ser manejadas para evita y prevenir 
errores. 

## Excepciones verificadas
Las excepciones verificadas son aquellas que el compilador te obliga a manjear o declarar. Extienden de la clase 
`Exception`. Han de ser manejadas con un `try-catch` o ser declaradas en el método con `throws`

## Excepciones no verificadas
Son aquellas que el compilador no te obliga a manejar. Extienden de la clase `RuntimeException`. Nacen de errores en la 
lógica del programa. Deben ser manejadas mediante la corrección del código ya que son errores de lógica.

## Error
Los `Error` son situaciones especiales que se hayan fuera del control del programador ya que se deben a problemas de la 
`JVM` (Java Virtual Machine). No deben manejarse ya que representan un estado irrecuperable

Ej:
- `OutOfMemoryError`: La `JVM` se queda sin memoria.
- `StackOverflowError`: La pila se ha desbordado.
- `LinkageError`: Problema de vinculacion de clases.

# MANEJO DE EXCEPCIONES

Para manejar y prevenir errores se usa `try`, `catch` y `finally` que sirven para detectar excepciones concretas y 
responder de una forma determinada permitiendo que el programa continue

## Try y catch

`try` sirve para “intentar” ejecutar una línea de código, y `catch` se encarga de realizar una acción concreta en base a 
una excepción esperada que la línea de código puede producir y que el programa continue.

Sintaxis: 
```java
try{
línea de código;
}catch(Excepción){
Respuesta al error;
}
```

Ejemplo:
```java
try {
    int division = 10 / 0; // Esto causará una excepción
} catch (ArithmeticException e) {
    System.out.println("Se ha producido una excepción: " + e.getMessage());
}
```
## finally

`finally` se utiliza para especificar que un bloque de código se ejecutaña siempre, ocurra o no la excepción
Sintaxis:
```java
try {
    // Código que podría lanzar una excepción
} catch (TipoDeExcepcion e) {
    // Manejo de la excepción
} finally {
    // Código que se ejecuta siempre
}
```

Ejemplo:

```java
try {
    int division = 10 / 0; // Esto causará una excepción
} catch (ArithmeticException e) {
    System.out.println("Se ha producido una excepción: " + e.getMessage());
} finally {
 System.out.println("Este texto se mostrará siempre");
}
```

### try-with-resources
Consiste en declarar recursos dentro de la clausula `try` para trabajar con ellos en el try, una vez se sale del `try`
los recursos se cierran:

Sintaxis:
```java
try (Recurso1 recurso1 = new Recurso1(); Recurso2 recurso2 = new Recurso2()) {
// Código que utiliza los recursos
} catch (ExcepcionTipo e) {
// Manejo de excepciones
}
```

## Variable `e`
Es una variable que funciona dentro del bloque catch y hace referencia a la excepcion qiue se esté manejando 



# LANZAR EXCEPCIONES

El lanzamiento de excepciones consiste en lanzar excepciones desde métodos. Se pueden lanzar tanto excepciones 
predefinidas como excepciones personalizadas y manejarlas desde donde se utilize el método.

## Throw

`throw` se utiliza para lanzar una excepcion de forma manual en un programa. Puedes crear una instancia de la excepcion 
y lanzarla en cualquier punto del códgio:

Sintaxis: 
```java
throw new NombreExcepcion("mensaje"); // Lanza una excepcion y un mensaje
```

Ejemplo:
```java
try {
    if (edad < 18) {
      throw new IllegalArgumentException("La edad debe ser mayor o igual a 18");
    }
  } catch (IllegalArgumentException e){
    System.out.println(e.getMessage());
}
```

## Throws

La clausula `throws` se utiliza para indicar que un método lanza una excepción verificada o personalizada para ser 
manejada externamente, no por el propio método.

Sintaxis:
```java
nombreMetodo() throws Excepcion {
    // Cuerpo del método
}
``` 

Ejemplo:
```java
public static void leerNumero() throws InputMismatchException {
  Scanner sc = new Scanner(System.in);
  System.out.print("Introduce un número: ");
  int numEjemplo = sc.nextInt();
  System.out.println("El número introducido es: " + numEjemplo);
  sc.close();
}
```
# EXCEPCIONES PERSONALIZADAS

Java permite crear excepciones personalizadas para manejar situaciones concretas en el programa, lo cual permite manejar
errores con mayor libertad. Heredan de la clase `Exception`:

Sintaxis:
```java
// Declaración de la excepción
public class ExcepcionEjemplo extends Exception {
  public ExcepcionEjemplo() {
    super();
  }

  public ExcepcionEjemplo(String mensaje) {
    super(mensaje);
  }
}

// Utilización de la excepción
public class Ejemplo {
  public void metodo() throws ExcepcionEjemplo {

    throw new ExcepcionEjemplo("Mensaje");
  }
}
```

# LOG

Los logs permiten a los desarrolladores monitorear y solucionar problemas de aplicaciones, recopilando y analizando 
datos y fallos ocurridos durante la ejecución de un programa. Existen distintos frameworks de registro de logs en java 
el que se a a explicar es `LOG4J` (Log For Java)

## Instrucciones

1. Descargar `log4j-api-2.22.1.jar` y `log4j-core-2.22.1.jar`
2. Incorporar estos dos archivos JAR a las librerías del proyecto en las propiedades del proyecto.

## Configuración

1. Crear una carpeta `resources` en el proyecto.
2. Configurar esta carpeta como carpeta de recursos en las propiedades del proyecto.
3. Dentro de la carpeta `resources`, crear un archivo `log4j2.xml` con el siguiente contenido:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="INFO">
    <Appenders>
        <Console name="LogToConsole" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
        <File name="LogToFile" fileName="app.log">
            <PatternLayout>
                <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
            </PatternLayout>
        </File>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="LogToFile"/>
            <AppenderRef ref="LogToConsole"/>
        </Root>
    </Loggers>
</Configuration>
```

## Uso

1. Declarar el logger.
2. Usarlo en el proyecto.

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MiClase {

    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {
        try {
            // Código que puede generar una excepción
        } catch (ArithmeticException e) {
            LOGGER.error("¡Error aritmético! No se puede dividir por cero.");
        }
    }
}
```

# ESTRUCTURAS DE DATOS

Las estructuras de datos son métodos para representar y organizar la información de manera que sea eficientemente 
accesible y manipulable. Permiten al programador elegir la forma más adecuada para organizar y acceder a los datos 
según las necesidades específicas del programa que se está desarrollando.

## Estructuras de datos dinámicas

Las estructuras de datos dinámicas son colecciones de elementos conectados mediante punteros, que son variables que 
contienen la dirección de memoria donde se almacena un valor. Son utilizadas debido a su flexibilidad y eficiencia.

- Listas (`List`): 
- Pilas (`Deque`):
- Colas (`Queue`):
- Arboles (`Tree`):
- Grafos (`Map`):

## Collections

Son estructuras de datos que permiten almacenar, manipular y acceder a grupos de objetos eficientemente. Forman parte de 
`java.util`. Nacen de la interfaz `Collection`  existen varios tipos: 

### Listas 

Alacenan una coleccion de elementos de forma ordenada:

- Permiten almacenar los elementos en base a un orden
- Permite duplicados
- Ej: `ArrayList`, `LinkedList`

### Sets

Colecciones de elementos únicos que se almacenan de forma no ordenada:

- Almacenan los elementos sin un orden
- No permite duplicados
- Ej: `HashSet`, `TreeSet`, `LinkedHashet`

### Colas (Queues y Deque)

Estructuras FIFO en las que los elementos se añaden al final y se eliminan desde el principio (`Queue`) o permiten 
inserción y eliminación eficiente en ambos extremos (`Deque`).

- Se ordenan en base al Algoritmo FIFO, el primer elemento de la cola es el ultimo en ser agregado y viceversa
- Ej: `LinkedList`, `PriorityQueue`

### Mapas

Estructuras de datos que almacenan datos en base a una clave almacenando la clave y el valor 

- Los valores esta asociados a una clave
- Permite duplicar claves pero no valores, por lo tanto dos claves pueden referenciar el mismo valor
- Ej: `HashMap`, `TreeMap`, `LinkedHashMap`

## Propiedades

| Estructura de Datos | Acceso Rápido por Índice | Inserción/Eliminación Frecuente | Colección sin Duplicados | Mantener Orden | Cola de Prioridad | Implementación de Pila/Cola Eficiente |
|---------------------|--------------------------|---------------------------------|--------------------------|----------------|-------------------|-------------------------------------|
| ArrayList           | Sí                       | No                              | No                       | No             | No                | No                                  |
| LinkedList          | No                       | Sí                              | No                       | No             | No                | No                                  |
| HashSet             | No                       | No                              | Sí                       | No             | No                | No                                  |
| TreeSet             | No                       | No                              | Sí                       | Sí             | No                | No                                  |
| HashMap             | Sí                       | No                              | No                       | No             | No                | No                                  |
| TreeMap             | No                       | No                              | No                       | Sí             | No                | No                                  |
| LinkedHashMap       | Sí                       | No                              | Sí                       | Sí             | No                | No                                  |
| PriorityQueue       | No                       | No                              | No                       | No             | Sí                | No                                  |
| ArrayDeque          | Sí                       | Sí                              | No                       | No             | No                | Sí                                  |
| Stack y Queue       | No                       | Sí (al principio o al final)    | No                       | No             | No                | Sí                                  |


## Cuando usar cada una 
| No. | Requisito                                    | Respuesta        | Estructura de Datos    | Próximo Paso                                                                                 |
|-----|----------------------------------------------|------------------|-----------------------|---------------------------------------------------------------------------------------------|
| 1   | ¿Necesitas mantener los elementos ordenados? | Sí               |                       | Ve a "¿Permitir duplicados?" (3)                                                            |
| 2   |                                              | No               |                       | Ve a "¿Permitir duplicados?" (7)                                                            |
| 3   | ¿Permitir duplicados?                        | Sí               | `LinkedList`          |                                                                                             |
| 4   |                                              | No               |                       | Ve a "¿Acceso rápido por clave?" (5)                                                        |
| 5   | ¿Acceso rápido por clave?                    | Sí               | `TreeMap`             |                                                                                             |
| 6   |                                              | No               | `TreeSet`             |                                                                                             |
| 7   | ¿Permitir duplicados?                        | Sí               |                       | Ve a "¿Acceso rápido por índice?" (9)                                                       |
| 8   |                                              | No               |                       | Ve a "¿Necesitas una estructura de pila o cola?" (11)                                       |
| 9   | ¿Acceso rápido por índice?                   | Sí               | `ArrayList`           |                                                                                             |
| 10  |                                              | No               | `LinkedList`          |                                                                                             |
| 11  | ¿Necesitas una estructura de pila o cola?    | Sí               |                       | Ve a "¿Cola de prioridad?" (13)                                                             |
| 12  |                                              | No               |                       | Ve a "¿Acceso rápido por clave?" (15)                                                       |
| 13  | ¿Cola de prioridad?                          | Sí               | `PriorityQueue`       |                                                                                             |
| 14  |                                              | No               |                       | Ve a "¿Acceso rápido por índice?" (17)                                                      |
| 15  | ¿Acceso rápido por clave?                    | Sí               |                       | Ve a "¿Mantener orden de inserción?" (16)                                                   |
| 16  |                                              | No               | `HashSet`             |                                                                                             |
| 17  | ¿Mantener orden de inserción?                | Sí               | `LinkedHashMap`       |                                                                                             |
| 18  |                                              | No               | `HashMap`             |                                                                                             |


# ITERABLE

`iterable` es una interfaz que proporciona mecanismos para iterar sobre estructuras de datos. Se utiliza el método
`iterator`. Se utiliza cuando se quiere recorrer un conjunto de datos de forma secuencial.

Sintaxis: 

```java
public class ClaseEjemplo<T> implements Iterable<T> {
    private List<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    @Override
    public Iterator<T> iterator() {
        return elementos.iterator();
    }
}
```


Usar iterator para recorrer una estructura de datos: 
```java
List<String> personas = new ArrayList<>();
personas.add("Pedro");
personas.add("David");
personas.add("Miguel");
personas.add("Antonio");
personas.add("Pedro");

Iterator<String> iterador = personas.iterator();
while (iterador.hasNext()) {
    System.out.println(iterador.next());
}
```
`iterator` recorre una estructura de datos siguiendo el orden definido por la estructura sobre la cual se está iterando

# INTERFAZ COMPARABLE

Las interfaz `comparable` tiene la función de comparar objetos de una misma clase para determinar su orden relativo. Se
usa para ordenar estructuras de datos en base a un criterio establecido por el programador. Para utilizarla solo debemos 
implementar el método `compareTo`

```java
public class Coche implements Comparable<Coche> { // Implementación de la interfaz Comparable
  private String marca;
  private int numeroSerie;
  
  public Coche(String marca, int numeroSerie) {
    this.marca = marca;
    this.numeroSerie = numeroSerie;
  }

  @Override // Implementar el método compareTo
  public int compareTo(Coche coche) {
    return Integer.compare(this.numeroSerie, coche.numeroSerie);
  }
}

```

Dependiendo del tipo, algunas estructuras basan su criterio de ordenación en base a esta interfaz:

- `TreeSet`
- `TreeMap`
- `PriorityQueue`
- `Collections.sort()`

## compareTo

Se utiliza el método `compareTo`, que realiza una operación que devuelve un entero que positivo, negativo o 0, para
determinar la diferencia entre el valor de los atributos de los elementos que se está comparando.

```java

@Override
public int compareTo(Coche coche) {
  return Integer.compare(this.numeroSerie, coche.numeroSerie);
}
```

# Comparator

La interfaz `comparator` permite definir una clase con varios criterios de ordenación para clases que no implementan 
`comparable`:

```java 
class MiComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Integer && o2 instanceof Integer) {
            return Integer.compare((Integer) o1, (Integer) o2);
        } else if (o1 instanceof String && o2 instanceof String) {
            return ((String) o1).compareTo((String) o2);
        } else if (o1 instanceof Integer) {
            return -1;
        } else {
            return 1;
        }
    }
}
```

## comparable

`Comparator` utiliza el método `compare` para comparar dos objetos en base a un criterio definido por el programador y 
no en base a un solo argumento: 

```java
 @Override
public int compare(Object o1, Object o2) {
  if (o1 instanceof Integer && o2 instanceof Integer) {
    return Integer.compare((Integer) o1, (Integer) o2);
  } else if (o1 instanceof String && o2 instanceof String) {
    return ((String) o1).compareTo((String) o2);
  } else if (o1 instanceof Integer) {
    return -1;
  } else {
    return 1;
  }
```

# ENUM

Un `Enum` es un tipo de dato que consta de un conjunto de valores constantes definidas por el programador. Se usan para 
representar conjuntos de datos relacionados entre sí (valores de cartas, generos de libros, dias de la semana).

## Constantes

Las constantes son los valores que se definene en el `Enum`. Para referirse a ellas debes referenciar el enum y el valor

```java
NombreEnum.valor; 
```

## Métodos

Los enum pueden contener métodos para tratar con las constantes

## Atributos

Las constantes de los enums pueden contener atributos


```java
public enum DiaSemana {
    // Constantes con atributos (numeros)
    LUNES(1),   
    MARTES(2), 
    MIÉRCOLES(3), 
    JUEVES(4), 
    VIERNES(5), 
    SÁBADO(6), 
    DOMINGO(7);
    
    private int numero;

    // Constructor del enum con el atributo
    private Moneda(int numero) {
        this.numero = numero;
    }

    // Método que devuelve el valor del atributo
    public int getNumero() {
        return numero;
    }
}
```

# JavaIO

Es el paquete I/O de Java y se basa en flujos de operaciones de entrada y salida de datos y proporciona metodos y clases.

## File

La clase `File` proporciona métodos para tratar con ficheros. se usa para acceder a la información como la ruta, tamaño, 
atributos o permisos entre otras. El resto de clases que manipulan ficheros parten de la existencia de una clase File, 
por lo que es la base de cualquier operación de manipulación de ficheros.

### Crear ficheros

```java
File archivo1 = new File(“ruta/al/archivo.txt”);
File directorio = new File(“ruta/al/directorio”);
File archivo2 = new File(directorio, “archivo.txt”);
```

| Método                          | Descripción                                             |
|---------------------------------|---------------------------------------------------------|
| `File(String pathname)`         | Crea un nuevo objeto de tipo File a partir de su ruta    |
| `boolean createNewFile()`       | Crea un nuevo archivo vacío con la ruta definida por el File |
| `boolean delete()`              | Borra el fichero/directorio                             |
| `boolean exists()`              | Indica si el fichero/directorio existe                  |
| `String getName()`              | Devuelve el nombre del fichero/directorio sin ruta      |
| `String getParent()`            | Devuelve la ruta al fichero/directorio                  |
| `File[] listFiles()`            | Obtiene un listado de ficheros en el directorio         |
| `boolean isDirectory()`         | Indica si se trata de un directorio                     |
| `boolean isFile()`              | Indica si se trata de un fichero                        |
| `String getAbsolutePath()`      | Retorna la ruta absoluta del archivo o directorio       |
| `boolean mkdir()` y `mkdirs()`  | Crea un directorio/directorios representado por el File |

### Leer ficheros

`BufferedReader` se utiliza para leer el fichero de texto de forma más eficiente, usa un buffer (memoria temporal) para 
almacenar datos de entrada, intenta leer tantos caracteres como sea posible a la vez en el buffer

```java
BufferedReader br = new BufferedReader(new FileReader(“file”));
```

```java
import java.io.BufferedReader;

public void leerFichero(File file) {

  try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;

    while ((line = bufferedReader.readLine()) != null) { // Leer línea por línea del archivo de entrada
      System.out.println(line);      // Procesar cada línea como desees
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
}
```

### Escribir en ficheros

`BufferedWriter` se utiliza para escribir texto en un fichero de forma más eficiente. Utiliza un buffer para agrupar 
múltiples operaciones de escritura y enviarlas todas juntas, reduciendo así el número de accesos al disco y mejorando el 
rendimiento.

```java
BufferedWriter bw = new BufferedWriter(newFileWriter(file));
```

```java
import java.io.BufferedWriter;

public void escribirFichero(File file) {
  String texto = "Texto";

  try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
    bufferedWriter.write(texto); // Escribe el texto en el fichero
    bufferedWriter.newLine(); // Escribir un salto de línea
  } catch (IOException e) {
    e.printStackTrace();
  }
}
```

| Método                | Descripción                                                                                                     |
|-----------------------|-----------------------------------------------------------------------------------------------------------------|
| `readLine()`          | Lee una línea de texto                                                                                          |
| `Int read()`          | Lee un carácter y devuelve el valor Unicode del carácter o -1 al alcanzar el final del archivo                  |
| `Void newLine()`      | Escribe una línea de separación                                                                                 |
| `Void write(int c)`   | Escribe un único carácter en el archivo                                                                         |
| `Void write(String str)` | Escribe una cadena en el archivo                                                                              |
| `Void flush()`        | Vacía el stream. Si habían caracteres del método write() en el buffer, se escriben antes de vaciar.             |

# SERIALIZACIÓN

La serializacion es un mecanismo que se utiliza para convertir el estado de un objeto en una secuencia de bytes, 
permitiendo el guardado de objetos en un archivo o BD, siendo también posible transmitirlos por red. La deserialización 
se refiere al proceso de transformar estos bytes en objetos de nuevo. Los ficheros binarios nos permiten almacenar 
objetos. Para ello se debe seguir una política de almacenamiento adecuada. Por ejemplo, se puede guardar un objeto de la 
clase Grupo, guardando uno a uno los objetos que la forman(por ejemplo objetos Alumno). Además un fichero puede contener 
diferentes clases o objetos y datos primitivos.

Para poder leer/escribir los objetos de una clase es necesario que esta implemente Serializable.

```java
Public class Grupo implements Serializable{
//cuerpo de clase
}
```
La serialiazación es un proceso inseguro, ya que es vulnerable ante la inyección de objetos. Por esto es importarte 
asegurarse de las fuentes de las cuales vas a deserializar datos.

## ACTIVAR para CREAR el UID de SERIALIZACION

Ejemplos serialización:

Serializar:

```java
import java.io.FileOutputStream;
import java.io.IOException;               // Imports                      
import java.io.ObjectOutputStream;

public void guardarEstado(Usuario usuario){
    File file = new File(RUTA);
    
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
        oos.write(usuario);
    }catch (IOException e){
        LOOGER.error("Error al guardar el estado del usuario");
    }
}
```

Deserializar:

```java
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public Usuario cargarEstado(Usuario usuario) {
  File file = new File(RUTA);

  try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
    usuario = (Usuario) ois.readObject();
  } catch (IOException e) {
    LOOGER.error("Error al cargar el estado del usuario");
  }
  
  return usuario;
}
```
