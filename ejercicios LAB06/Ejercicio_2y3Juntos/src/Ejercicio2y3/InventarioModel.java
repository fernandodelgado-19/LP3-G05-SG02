package Ejercicio2y3;

import java.util.ArrayList;

public class InventarioModel {
    ArrayList<Item> items = new ArrayList<>();

    public void agregarItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> obtenerItems() {
        return items;
    }
}

