package DatosEmpleados;

public class Empleado {
    private int numero;
    private String nombre;
    private double sueldo;
    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    public int getNumero() { return numero; }
    public String getNombre() { return nombre; }
    public double getSueldo() { return sueldo; }
    public String toString() {
        return numero + "," + nombre + "," + sueldo;
    }
}
