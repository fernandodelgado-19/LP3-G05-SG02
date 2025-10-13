package ejer1_2;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ DE GESTIÓN DE PERSONAJES =====");
            System.out.println("1. Agregar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Filtrar por vida");
            System.out.println("6. Ver estadísticas");
            System.out.println("7. Agregar personaje aleatorio");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); 
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: "); String n = sc.nextLine();
                    System.out.print("Vida: "); int v = sc.nextInt();
                    System.out.print("Ataque: "); int a = sc.nextInt();
                    System.out.print("Defensa: "); int d = sc.nextInt();
                    System.out.print("Alcance: "); int al = sc.nextInt();
                    gestor.agregar(new Personaje(n, v, a, d, al));
                }
                case 2 -> gestor.mostrar();
                case 3 -> {
                    System.out.print("Nombre a modificar: "); String n = sc.nextLine();
                    System.out.print("Nueva vida: "); int v = sc.nextInt();
                    System.out.print("Nuevo ataque: "); int a = sc.nextInt();
                    System.out.print("Nueva defensa: "); int d = sc.nextInt();
                    System.out.print("Nuevo alcance: "); int al = sc.nextInt();
                    gestor.modificar(n, v, a, d, al);
                }
                case 4 -> {
                    System.out.print("Nombre a eliminar: ");
                    gestor.eliminar(sc.nextLine());
                }
                case 5 -> gestor.filtrarPorVida();
                case 6 -> gestor.estadisticas();
                case 7 -> {

                    Personaje aleatorio = Utilidades.generarAleatorio();
                    gestor.agregar(aleatorio);
                }
                case 0 -> System.out.println("👋 Programa finalizado.");
                default -> System.out.println("❗ Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}