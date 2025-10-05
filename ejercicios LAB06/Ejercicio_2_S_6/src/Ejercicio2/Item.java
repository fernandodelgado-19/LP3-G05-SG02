package Ejercicio2;

public class Item {
    private String nombre;
    private int cantidad;

    public Item(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
}