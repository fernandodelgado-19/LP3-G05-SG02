package universidad;

public class Estudiante extends Persona {
    private String matricula;
    private static int contadorEstudiantes = 0; // atributo de clase

    public Estudiante(String nombre, String dni, String matricula) {
        super(nombre, dni);
        this.matricula = matricula;
        contadorEstudiantes++;
    }

    public static int getContadorEstudiantes() {
        return contadorEstudiantes;
    }

    public String mostrarInfo() {
        return "Estudiante: " + nombre + ", Matrícula: " + matricula;
    }
}
