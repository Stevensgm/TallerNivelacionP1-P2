import java.util.Scanner;

public class ContadorVocalesConsonantes {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int vocales = 0;
        int consonantes = 0;
        String palabra;

        System.out.println("--- Contador de Vocales y Consonantes ---");
        System.out.print("Ingresa una palabra (en minúsculas, sin acentos ni símbolos): ");
        palabra = entrada.nextLine();

        for (int i = 0; i < palabra.length(); i++) {
            char caracter = palabra.charAt(i);

            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                vocales++;
            } else if (caracter >= 'a' && caracter <= 'z') {
                consonantes++;
            }
        }

        System.out.println("La palabra tiene " + vocales + " vocales y " + consonantes + " consonantes.");
        entrada.close();
    }
}
