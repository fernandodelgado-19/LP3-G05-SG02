package Ejercicio2;

import java.util.List;
import java.util.Scanner;

public class InventarioVista {
    private Scanner sc = new Scanner(System.in);

    public String pedirNombre() {
        System.out.print("Nombre: ");
        return sc.nextLine();
    }
    public int pedirCantidad() {
        System.out.print("Cantidad: ");
        return Integer.parseInt(sc.nextLine());
    }
    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) System.out.println("Inventario vacío.");
        else {
            System.out.println("Inventario:");
            for (Item i : items) {
                System.out.println("- " + i.getNombre() + " (x" + i.getCantidad() + ")");
            }
        }
    }
    public void menu() {
        System.out.println("n1. Agregar");
        System.out.println("2. Eliminar");
        System.out.println("3. Ver Inventario");
        System.out.println("4. Salir");
    }
    public String pedirOpcion() {
        System.out.print("Opción: ");
        return sc.nextLine();
    }
    public void mostrar(String msg) {
        System.out.println(msg);
    }
}
