package Ejercicio2;

import java.util.*;

public class ProductoDAO {
    ArrayList<Producto> lista = new ArrayList<>();

    public void agregar(Producto p) {
        lista.add(p);
        System.out.println("Producto agregado.");
    }

    public void mostrar() {
        if (lista.isEmpty()) System.out.println("No hay productos.");
        for (Producto p : lista) System.out.println(p);
    }

    public void actualizar(int id, double nuevoPrecio) {
        for (Producto p : lista)
            if (p.id == id) { p.precio = nuevoPrecio; System.out.println("Precio actualizado."); return; }
        System.out.println("ID no encontrado.");
    }

    public void eliminar(int id) {
        lista.removeIf(p -> p.id == id);
        System.out.println("Producto eliminado.");
    }
}
