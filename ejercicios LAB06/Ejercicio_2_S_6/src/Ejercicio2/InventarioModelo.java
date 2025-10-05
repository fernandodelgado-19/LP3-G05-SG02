package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class InventarioModelo {
    private List<Item> items = new ArrayList<>();

    public void agregar(Item i) { items.add(i); }

    public boolean eliminar(String nombre) {
        return items.removeIf(i -> i.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Item> getItems() { return items; }
}