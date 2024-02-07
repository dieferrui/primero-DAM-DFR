import java.util.Scanner;

public class OrganizarAnimales {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el animal del que quieras saber el tipo (cat, dog, lion, cow, tiger)");
        String animal = sc.nextLine();

        String tipo =
            switch (animal) {
                case "cat" -> "domestico";
                case "dog" -> "domestico";
                case "lion" -> "salvaje";
                case "cow" -> "domestico";
                case "tiger" -> "salvaje";
                default -> "desconocido";
            };
        
        System.out.println("Tu animal es " + tipo + ".");

        sc.close();
    }
}
