package DatosEmpleados;

import modelo.Empleado;
import controlador.EmpleadoController;
import java.util.*;

public class EmpleadoView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpleadoController c = new EmpleadoController();
        int op;

        do {
            System.out.println("\n1. Listar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) c.leerEmpleados().forEach(System.out::println);
            else if (op == 2) {
                System.out.print("Número: "); int n = sc.nextInt(); sc.nextLine();
                System.out.print("Nombre: "); String nom = sc.nextLine();
                System.out.print("Sueldo: "); double s = sc.nextDouble();
                c.agregarEmpleado(new Empleado(n, nom, s));
            }
            else if (op == 3) {
                System.out.print("Número a buscar: ");
                c.buscarEmpleado(sc.nextInt());
            }
            else if (op == 4) {
                System.out.print("Número a eliminar: ");
                c.eliminarEmpleado(sc.nextInt());
            }
        } while (op != 5);
    }
}
