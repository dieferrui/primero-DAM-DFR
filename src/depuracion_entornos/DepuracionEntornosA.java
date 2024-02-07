import java.util.Scanner;

public class DepuracionEntornosA {

    public static void main(String[] args) {
        
        /* 
        A continuación se expresan los diferentes métodos
        que puede ejecutar el programa. Retire sólo uno de
        los comentarios a la vez para el correcto funcionamiento
        del programa.
        */

        // AreaRadioCircun();
        // Mira3Cifras();
        // NumPerfecto();
        // PrimosHastaN();
        // MediasDeNumerosPosNeg();
        // NumeroNarcisista();
        // TriangulosMultiples();
        // NumerosACifras();
        // ComprobarUltimo();
        // FactorialDe();
        // NumerosAmigos();
        // MediaAlturas();
        // Num99999E();
        
    }

    public static void AreaRadioCircun() {
        
        Scanner sa;
        sa = new Scanner(System.in);
        double radio, longitud, area;
        
        System.out.println("Introduce radio de la circunferencia:");
        radio = sa.nextDouble();
        
        longitud = 2 * Math.PI * radio;
        area = Math.PI * Math.pow(radio, 2);
        
        System.out.println("Longitud de la circunferencia -> " + longitud); 
        System.out.println("Area de la circunferencia -> " + area);
        
        sa.close();
    }

    public static void Mira3Cifras() {
        
        Scanner sb = new Scanner(System.in);
        int N;
        System.out.print("Introduzca valor de N: ");
        N = sb.nextInt();
        
        System.out.println("Primera cifra de " + N + " -> " + (N / 100));
        System.out.println("Cifra central de " + N + " -> " + ((N % 100) / 10));
        System.out.println("Última cifra de " + N + " -> " + (N % 10));

        sb.close();
    }

    public static void NumPerfecto() {
        
        int i, suma = 0, n;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce un número: ");
        n = sc.nextInt();
        
        for (i = 1; i < n; i++) { 
            if (n % i == 0) {
                suma += i; 
            }
        }
        
        if (suma == n) { 
            System.out.println("Perfecto");
        } else {
            System.out.println("No es perfecto");
        }

        sc.close();
    }

    public static void PrimosHastaN() {
        
        int N, i, j;
        Scanner sd = new Scanner(System.in);
        
        do {
            System.out.print("Introduce un numero > 0: ");
            N = sd.nextInt();
        } while (N <= 0);
        
        System.out.println("Números primos desde 2 hasta " + N);
        
        for (j = 2; j < N; j++) { 
            i = 2; 
            while (j % i != 0) {
                i++;
            }
            
            if (i == j) { 
                System.out.println(j);
            }
        }

        sd.close();
    }

    public static void MediasDeNumerosPosNeg() {
        
        Scanner se = new Scanner(System.in);
        int i;
        int pos = 0, neg = 0; 
        int[] numeros = new int[10]; 
        double sumaPos = 0, sumaNeg = 0; 
            
        System.out.println("Lectura de los elementos del array: ");
        
        for (i = 0; i < 10; i++) {
            System.out.print("numeros[" + i + "]= ");
            numeros[i] = se.nextInt();
        }
        
        for (i = 0; i < 10; i++) {
            if (numeros[i] > 0) {
                sumaPos += numeros[i];
                pos++;
            } else if (numeros[i] < 0) { 
                sumaNeg += numeros[i];
                neg++;
            }
        }

        //Calcular y mostrar las medias
        if (pos != 0) {
            System.out.println("Media de los valores positivos: " + sumaPos / pos); 
        } else {
            System.out.println("No ha introducido numeros positivos");
        }

        if (neg != 0) {
            System.out.println("Media de los valores negativos: " + sumaNeg / neg);
        } else {
            System.out.println("No ha introducido numeros negativos");
        }

        se.close();
    }

    public static void NumeroNarcisista() {
        
        Scanner sf = new Scanner(System.in);
        int N, aux, cifra, numeroCifras = 0;
        double suma;
        
        do {
            System.out.print("Introduce número entero positivo: ");
            N = sf.nextInt();
            
            if (N <= 0) {
                System.out.println("Error. Debe ser un número positivo");
            }
        } while (N <= 0); 
        
        aux = N;

        while (aux != 0) {
            numeroCifras++;
            aux = aux / 10;
        }

        suma = 0; 
        aux = N;

        while (aux != 0) { 
            cifra = aux % 10; 
            suma += Math.pow(cifra, numeroCifras); 
            aux = aux / 10; 
        }

        if (suma != N) { 
            System.out.println("No es narcisista");
        } else {
            System.out.println("Es narcisista");
        }

        sf.close();
    }

    public static void TriangulosMultiples() {
        
        Scanner entrada = new Scanner(System.in);
        int numfiguras;

        do {
            System.out.print("¿Cuántas figuras quieres? ");
            numfiguras = entrada.nextInt();
        } while (numfiguras < 2);

        int nfiguras = numfiguras;
        int numlinea;

        do {
            System.out.print("¿Cuántos asteriscos quieres? ");
            numlinea = entrada.nextInt();
        } while (numlinea < 2);

        int numespacios = 0;
        int posasterisco ;
        int nespacios;

        while (numlinea > 0) {
            
            numfiguras = nfiguras;

            while (numfiguras > 0) {

                posasterisco = numlinea;

                while (posasterisco-- > 0) {
                    System.out.print("*");
                }
                
                nespacios = numespacios;
                
                while (nespacios-- > 0) {
                    System.out.print(" ");
                }
        
                if (numfiguras > 1) {
                    System.out.print("||");
                }
                
                numfiguras = numfiguras - 1;
            }

            System.out.println("");
            numlinea = numlinea - 1;
            numespacios = numespacios + 1;
        }

        entrada.close();
    }

    public static void NumerosACifras() {
        
        int num, i, aux, cont, cifra;
        Scanner sg = new Scanner(System.in);

        do {
            System.out.print("Introduce numero entero positivo: ");
            num = sg.nextInt();
            if (num <= 0) {
                System.out.println("Numero no valido.");
            }
        } while (num <= 0);

        aux = num;
        cont = 0; //variable para contar las cifras del número
       
        while (aux != 0) {
            aux = aux / 10;
            cont++;
        }

        //obtener cada una de las cifras comenzando por la izquierda 
        
        for (i = cont - 1; i >= 0; i--) {
            //obtenemos la cifra de la izquierda
            cifra = num / (int) Math.pow(10, i);
            //mostramos su nombre
            switch (cifra) {
                case 0:
                    System.out.print("cero ");
                    break;
                case 1:
                    System.out.print("uno ");
                    break;
                case 2:
                    System.out.print("dos ");
                    break;
                case 3:
                    System.out.print("tres ");
                    break;
                case 4:
                    System.out.print("cuatro ");
                    break;
                case 5:
                    System.out.print("cinco ");
                    break;
                case 6:
                    System.out.print("seis ");
                    break;
                case 7:
                    System.out.print("siete ");
                    break;
                case 8:
                    System.out.print("ocho ");
                    break;
                case 9:
                    System.out.print("nueve ");
                    break;
            }
            
            if (i != 0) { //si no es la última cifra
                System.out.print(" - ");
                num = num % (int) Math.pow(10, i);
            }
        }
        
        System.out.println();
        System.out.println("Fin de programa");
        sg.close();
    }

    public static void ComprobarUltimo() {
        
        Scanner sh = new Scanner(System.in);
        int n1, n2;

        System.out.print("Introduzca primer número: ");
        n1 = sh.nextInt();
        System.out.print("Introduzca segundo número: ");
        n2 = sh.nextInt();

        if (n1 % 10 != n2 % 10) {
            System.out.println("Los números acaban con cifras distintas");
        } else {
            System.out.println("Los dos números acaban con la misma cifra");
        }

        sh.close();

    }

    public static void FactorialDe() {
        int N;
        double factorial;
        Scanner si = new Scanner(System.in);

        do {
            System.out.print("Introduce un número > 0: ");
            N = si.nextInt();
        } while (N < 0);

        for (int i = 0; i <= N ; i++) {
            factorial = 1;

            for (int j = 1; j <= i; j++) {
                factorial = factorial * j;
            }
            
            System.out.printf("%2d! = %.0f %n", i, factorial);
        }

        si.close();
    }

    public static void NumerosAmigos() {
        
        int i, suma = 0, n1, n2;
        Scanner sj = new Scanner(System.in);

        System.out.print("Introduce primer número: ");
        n1 = sj.nextInt();
        System.out.print("Introduce segundo número: ");
        n2 = sj.nextInt();

        for (i = 1; i < n1; i++) {
            if (n1 % i == 0) {
                suma = suma + i;
            }
        }

        if (suma == n2) {
            suma = 0;
            for(i = 1; i < n2; i++) {
                if(n2 % i == 0) {
                    suma = suma + i;
                }
            }
            
            if(suma != n1) {
                System.out.println("No son Amigos");
            } else {
                System.out.println("Son amigos");
            }

        } else {
            System.out.println("No son amigos");
        }

        sj.close();
    }

    public static void MediaAlturas() {
        
        Scanner sk = new Scanner(System.in);
        int i, N;
        int contMas = 0, contMenos = 0;
        double media = 0;

        do {
            System.out.print("Número de personas: ");
            N = sk.nextInt();
        } while (N <= 0);

        double[] alto = new double[N];

        System.out.println("Lectura de la altura de las personas: ");
        for (i = 0; i < N; i++) {
            System.out.print("Persona " + (i + 1) + " = ");
            alto[i] = sk.nextDouble();
            media = media + alto[i];
        }
        
        media = media / N;

        for (i = 0; i < N; i++) {
            if (alto[i] > media) {
                contMas++;
        } else if (alto[i] < media) {
            contMenos++;
        }

        }
        System.out.println("Estatura media: " + media);
        System.out.println("Personas con estatura superior a la media: " + contMas);
        System.out.println("Personas con estatura inferior a la media: " + contMenos);

        sk.close();
    }

    public static void Num99999E() {
        
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    for (int l = 0; l <= 9; l++) {
                        for (int m = 0; m <= 9; m++) {
                            System.out.print(i != 3 ? i : "E");
                            System.out.print(j != 3 ? j : "E");
                            System.out.print(k != 3 ? k : "E");
                            System.out.print(l != 3 ? l : "E");
                            System.out.print(m != 3 ? m : "E");
                            System.out.println();
                        }
                    }
                }
            }
        }  
    }
}
