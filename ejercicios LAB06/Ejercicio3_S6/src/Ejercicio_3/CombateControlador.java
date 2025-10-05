package Ejercicio_3;

public class CombateControlador {
    private Jugador jugador;
    private Enemigo enemigo;

    public CombateControlador(Jugador j, Enemigo e) {
        jugador = j; enemigo = e;
    }

    public void iniciarCombate() {
        System.out.println("Combate a iniciado");
        while (jugador.getSalud() > 0 && enemigo.getSalud() > 0) {
            jugador.atacar(enemigo);
            if (enemigo.getSalud() > 0) enemigo.atacar(jugador);

            System.out.println(jugador.getNombre() + " HP: " + jugador.getSalud());
            System.out.println(enemigo.getNombre() + " HP: " + enemigo.getSalud());
        }
        if (jugador.getSalud() > 0) System.out.println("Ganó el jugador");
        else System.out.println("Perdiste");
    }
}
