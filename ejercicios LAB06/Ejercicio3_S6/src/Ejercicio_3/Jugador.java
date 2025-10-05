package Ejercicio_3;

public class Jugador {
    private String nombre;
    private int salud;

    public Jugador(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }

    public void atacar(Enemigo e) {
        System.out.println(nombre + " ataca a " + e.getNombre());
        e.recibirDano(10);
    }

    public void recibirDano(int d) { salud -= d; }
}
