package Ejertcicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        try {
            System.out.print("Ingrese primer número: ");
            double a = sc.nextDouble();
            System.out.print("Ingrese segundo número: ");
            double b = sc.nextDouble();

            System.out.println("Suma: " + calc.sumar(a, b));
            System.out.println("Resta: " + calc.restar(a, b));
            System.out.println("Multiplicación: " + calc.multiplicar(a, b));
            System.out.println("División: " + calc.dividir(a, b));

        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
