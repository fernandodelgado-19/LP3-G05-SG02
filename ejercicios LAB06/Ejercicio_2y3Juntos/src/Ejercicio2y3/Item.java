package Ejercicio2y3;

public class Item {
    String nombre;
    String tipo; // Arma o Poción
    int poder;
    int cantidad;
    String descripcion;

    public Item(String nombre, String tipo, int poder, int cantidad, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }

    public void usar(Jugador jugador, Enemigo enemigo) {
        if (cantidad > 0) {
            if (tipo.equalsIgnoreCase("Arma")) {
                enemigo.recibirDano(poder);
                System.out.println(jugador.nombre + " usa " + nombre + " causando " + poder + " de daño.");
            } else if (tipo.equalsIgnoreCase("Pocion")) {
                jugador.salud += poder;
                System.out.println(jugador.nombre + " usa " + nombre + " y recupera " + poder + " de salud.");
            }
            cantidad--;
        } else {
            System.out.println(nombre + " ya no está disponible.");
        }
    }
}
