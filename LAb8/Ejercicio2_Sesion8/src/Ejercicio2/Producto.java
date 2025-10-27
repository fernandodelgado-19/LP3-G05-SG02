package Ejercicio2;

public class Producto {
    int id;
    String nombre;
    double precio;
    int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String toString() {
        return id + " | " + nombre + " | " + precio + " | " + stock;
    }
}
