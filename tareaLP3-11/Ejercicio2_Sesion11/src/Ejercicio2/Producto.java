package Ejercicio2;

public class Producto {
    String nombre;
    double precio;

    public Producto(String n, double p){
        nombre = n;
        precio = p;
    }

    public String toString(){
        return nombre + " - S/" + precio;
    }
}
