package universidad;

public class Main {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("Carlos Pérez", "12345678", "Matemáticas");
        Profesor prof2 = new Profesor("Ana Gómez", "87654321", "Programación");

        Curso curso1 = new Curso("Álgebra", "Matemáticas", prof1);
        Curso curso2 = new Curso("POO", "Programación", prof2);

        Estudiante est1 = new Estudiante("Luis Torres", "11112222", "2023-001");
        Estudiante est2 = new Estudiante("María Ruiz", "33334444", "2023-002");

        curso1.inscribirEstudiante(est1);
        curso2.inscribirEstudiante(est2);

        SistemaGestion sistema = new SistemaGestion();
        sistema.agregarProfesor(prof1);
        sistema.agregarProfesor(prof2);
        sistema.agregarEstudiante(est1);
        sistema.agregarEstudiante(est2);
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);

        sistema.mostrarCursosDisponibles();
    }
}
