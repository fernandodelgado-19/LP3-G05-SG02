package DatosEmpleados;

import modelo.Empleado;
import java.io.*;
import java.util.*;
public class EmpleadoController {
    private final String archivo = "empleados.txt";
    public List<Empleado> leerEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(",");
                lista.add(new Empleado(Integer.parseInt(p[0]), p[1], Double.parseDouble(p[2])));
            }
        } catch (IOException e) {}
        return lista;
    }
    public void agregarEmpleado(Empleado e) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(e.toString());
            System.out.println("Empleado agregado con éxito.");
        } catch (IOException ex) {
            System.out.println("Error al agregar empleado.");
        }
    }
    public void buscarEmpleado(int num) {
        for (Empleado e : leerEmpleados()) {
            if (e.getNumero() == num) {
                System.out.println("Encontrado: " + e);
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }
    public void eliminarEmpleado(int num) {
        List<Empleado> lista = leerEmpleados();
        boolean eliminado = lista.removeIf(e -> e.getNumero() == num);
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Empleado e : lista) pw.println(e);
        } catch (IOException e) {}
        System.out.println(eliminado ? "Empleado eliminado." : "Empleado no encontrado.");
    }
}

