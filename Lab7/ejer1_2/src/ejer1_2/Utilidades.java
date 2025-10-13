package ejer1_2;

import java.util.Random;

public class Utilidades {

    public static Personaje generarAleatorio() {
        Random r = new Random();

        String nombre = "NPC" + (r.nextInt(900) + 100);
        int vida = r.nextInt(500) + 50;     // entre 50 y 550
        int ataque = r.nextInt(100) + 10;   // entre 10 y 110
        int defensa = r.nextInt(100) + 10;  // entre 10 y 110
        int alcance = r.nextInt(10) + 1;    // entre 1 y 10

        System.out.println("\n Personaje generado automáticamente:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Alcance: " + alcance);

        return new Personaje(nombre, vida, ataque, defensa, alcance);
    }
}