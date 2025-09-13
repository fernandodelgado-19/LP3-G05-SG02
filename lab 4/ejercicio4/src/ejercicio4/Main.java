package ejercicio4;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad máxima de estudiantes: ");
        int capacidad = sc.nextInt();
        sc.nextLine();

        RegistroEstudiantes registro = new RegistroEstudiantes(capacidad);

        for (int i = 0; i < capacidad; i++) {
            try {
                System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
                String nombre = sc.nextLine();
                registro.agregarEstudiante(nombre);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                i--;
            }
        }

        System.out.print("\nIngrese el nombre del estudiante a buscar: ");
        String nombreBuscar = sc.nextLine();

        try {
            String encontrado = registro.buscarEstudiante(nombreBuscar);
            System.out.println("✅ Estudiante encontrado: " + encontrado);
        } catch (NoSuchElementException e) {
            System.out.println("❌ " + e.getMessage());
        }

        sc.close();
    }
}
