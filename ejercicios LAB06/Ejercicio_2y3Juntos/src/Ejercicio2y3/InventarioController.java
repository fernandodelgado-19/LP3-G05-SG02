package Ejercicio2y3;

import java.util.Scanner;

public class InventarioController {
    Jugador jugador;
    Enemigo enemigo;
    InventarioView vista;

    public InventarioController(Jugador jugador, Enemigo enemigo, InventarioView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }
    public void iniciarCombate() {
        Scanner sc = new Scanner(System.in);
        while (jugador.salud > 0 && enemigo.salud > 0) {
            vista.mostrarEstado(jugador, enemigo);
            System.out.println("\nElige una acción:");
            System.out.println("1. Atacar");
            System.out.println("2. Curarte");
            int accion = sc.nextInt();

            if (accion == 1) {
                vista.mostrarInventario(jugador, "Arma");
                System.out.print("Elige arma: ");
                int opcion = sc.nextInt() - 1;
                if (opcion >= 0 && opcion < jugador.inventario.length) {
                    jugador.usarItem(enemigo, jugador.inventario[opcion]);
                }
            } else if (accion == 2) {
                vista.mostrarInventario(jugador, "Pocion");
                System.out.print("Elige poción: ");
                int opcion = sc.nextInt() - 1;
                if (opcion >= 0 && opcion < jugador.inventario.length) {
                    jugador.usarItem(enemigo, jugador.inventario[opcion]);
                }
            }
            if (enemigo.salud > 0) {
                enemigo.atacar(jugador);
            }
        }
        if (jugador.salud > 0) {
            vista.mostrarMensaje("/nGG Ganaste el combate");
        } else {
            vista.mostrarMensaje("/nHas sido derrotado");
        }
    }
}
