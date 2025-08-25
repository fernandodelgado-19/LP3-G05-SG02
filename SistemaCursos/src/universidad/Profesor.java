package universidad;

public class Profesor extends Persona {
    private String especialidad;
    private static int contadorProfesores = 0; // atributo de clase

    public Profesor(String nombre, String dni, String especialidad) {
        super(nombre, dni);
        this.especialidad = especialidad;
        contadorProfesores++;
    }

    public static int getContadorProfesores() {
        return contadorProfesores;
    }

    @Override
    public String mostrarInfo() {
        return "Profesor: " + nombre + ", Especialidad: " + especialidad;
    }
}
