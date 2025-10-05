package Ejercicio_3;

public class Enemigo {
    private String nombre;
    private int salud;

    public Enemigo(String nombre, int salud) {
        this.nombre = nombre;
        this.salud = salud;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }

    public void atacar(Jugador j) {
        System.out.println(nombre + " ataca a " + j.getNombre());
        j.recibirDano(5);
    }

    public void recibirDano(int d) { salud -= d; }
}