package universidad;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {
    private List<Curso> cursos;
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;

    public SistemaGestion() {
        cursos = new ArrayList<>();
        estudiantes = new ArrayList<>();
        profesores = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void mostrarCursosDisponibles() {
        for (Curso curso : cursos) {
            System.out.println(curso.mostrarInfo() + 
                               " - Estudiantes inscritos: " + curso.getCantidadEstudiantes());
        }
    }
}