package Ejercicio3;

public class Producto {
    public String nombre;
    public double precio;

    public Producto(String n, double p){
        nombre = n;
        precio = p;
    }

    public String toString(){
        return nombre + " - S/" + precio;
    }
}
