package Ejercicio_3;

public class MainCombate {
    public static void main(String[] args) {
        Jugador j = new Jugador("Héroe", 50);
        Enemigo e = new Enemigo("Enemigo", 40);

        CombateControlador c = new CombateControlador(j, e);
        c.iniciarCombate();
    }
}