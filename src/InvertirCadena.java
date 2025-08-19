import java.util.Scanner;

public class InvertirCadena {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String original, invertida = "";

        System.out.println("--- Invertir una Cadena ---");
        System.out.print("Ingresa una cadena de texto: ");
        original = entrada.nextLine();

        for (int i = original.length() - 1; i >= 0; i--) {
            invertida += original.charAt(i);
        }

        System.out.println("La cadena invertida es: " + invertida);
        entrada.close();
    }
}