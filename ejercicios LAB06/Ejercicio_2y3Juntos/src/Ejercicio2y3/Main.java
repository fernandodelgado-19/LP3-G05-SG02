package Ejercicio2y3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("=Preparate para el combate= \n¿Cuántos tendras en tu invetario? (máx 3): ");
        int n = Math.min(sc.nextInt(), 3);
        sc.nextLine();

        Item[] inventario = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nObjeto " + (i+1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Tipo (Arma/Pocion): ");
            String tipo = sc.nextLine();
            System.out.print("Poder (daño o curación): ");
            int poder = sc.nextInt();
            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine();
            System.out.print("Descripción: ");
            String desc = sc.nextLine();

            inventario[i] = new Item(nombre, tipo, poder, cantidad, desc);
        }

        Jugador jugador = new Jugador("Héroe", 50, inventario);
        Enemigo enemigo = new Enemigo("La Jarjacha", 100);
        InventarioView vista = new InventarioView();

        InventarioController controller = new InventarioController(jugador, enemigo, vista);
        controller.iniciarCombate();
    }
}
