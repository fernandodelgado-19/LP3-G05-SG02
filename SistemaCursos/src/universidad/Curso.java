package universidad;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String categoria;
    private Profesor profesor; // agregación
    private List<Estudiante> estudiantes; // composición

    private static final int MAX_ESTUDIANTES = 30; // constante
    private static int contadorCursos = 0;

    public Curso(String nombre, String categoria, Profesor profesor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
        contadorCursos++;
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("Cupo lleno en el curso: " + nombre);
        }
    }

    public int getCantidadEstudiantes() {
        return estudiantes.size();
    }

    public static int getContadorCursos() {
        return contadorCursos;
    }

    public String mostrarInfo() {
        return "Curso: " + nombre + " (" + categoria + 
               "), Profesor: " + (profesor != null ? profesor.getNombre() : "Sin asignar");
    }
}
