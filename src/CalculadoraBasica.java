import java.util.Scanner;
public class CalculadoraBasica {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double num1, num2, resultado;
        char operacion;

        System.out.println("--- Calculadora Básica ---");
        System.out.print("Ingresa el primer número: ");
        num1 = entrada.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        num2 = entrada.nextDouble();

        System.out.print("Ingresa la operación (+, -, *, /): ");
        operacion = entrada.next().charAt(0);

        switch (operacion) {
            case '+':
                resultado = num1 + num2;
                System.out.println("El resultado de la suma es: " + resultado);
                break;
            case '-':
                resultado = num1 - num2;
                System.out.println("El resultado de la resta es: " + resultado);
                break;
            case '*':
                resultado = num1 * num2;
                System.out.println("El resultado de la multiplicación es: " + resultado);
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                    System.out.println("El resultado de la división es: " + resultado);
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                }
                break;
            default:
                System.out.println("Operación no válida.");
        }
        entrada.close();
    }
}

