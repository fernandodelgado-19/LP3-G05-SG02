package Ejercicio2y3;

public class Jugador {
    String nombre;
    int salud;
    Item[] inventario;

    public Jugador(String nombre, int salud, Item[] inventario) {
        this.nombre = nombre;
        this.salud = salud;
        this.inventario = inventario;
    }

    public void usarItem(Enemigo enemigo, Item item) {
        item.usar(this, enemigo);
    }

    public void recibirDano(int dano) {
        salud -= dano;
        System.out.println(nombre + " recibe " + dano + " de daño. Salud actual: " + salud);
    }
}
