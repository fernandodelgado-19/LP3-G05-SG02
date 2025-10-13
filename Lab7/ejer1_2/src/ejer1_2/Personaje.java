package ejer1_2;

public class Personaje  {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        this.vida = Math.max(1, vida);
        this.ataque = Math.max(1, ataque);
        this.defensa = Math.max(1, defensa);
        this.alcance = Math.max(1, alcance);
    }

    // --- Getters y Setters ---
    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }

    public void setVida(int vida) { this.vida = Math.max(1, vida); }
    public void setAtaque(int ataque) { this.ataque = Math.max(1, ataque); }
    public void setDefensa(int defensa) { this.defensa = Math.max(1, defensa); }
    public void setAlcance(int alcance) { this.alcance = Math.max(1, alcance); }

    public String toString() {
        return nombre + "," + vida + "," + ataque + "," + defensa + "," + alcance;
    }

    public static Personaje fromString(String linea) {
        String[] datos = linea.split(",");
        return new Personaje(
                datos[0],
                Integer.parseInt(datos[1]),
                Integer.parseInt(datos[2]),
                Integer.parseInt(datos[3]),
                Integer.parseInt(datos[4])
        );
    }
}