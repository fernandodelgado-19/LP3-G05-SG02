package Ejercicio2y3;

public class Enemigo {
    String nombre;
    int salud;

    public Enemigo(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }

    public void atacar(Jugador jugador) {
        int dano = (int)(Math.random() * 10) + 5; 
        System.out.println(nombre + " ataca causando " + dano + " de daño.");
        jugador.recibirDano(dano);
    }

    public void recibirDano(int dano) {
        salud -= dano;
        System.out.println(nombre + " recibe " + dano + " de daño. Salud actual: " + salud);
    }
}
