package EJERCICIO1;

import java.util.*;
public class Menu {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			ProductoDAO dao = new ProductoDAO();
			String clave = "1234";
			while (true) {
			    System.out.println("\n1.Insertar  2.Mostrar  3.Actualizar  4.Borrar  5.Salir");
			    int op = sc.nextInt();
			    if (op == 1) {
			        System.out.print("ID Nombre Precio Stock: ");
			        dao.insertar(new Producto(sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextInt()));
			    } else if (op == 2) dao.mostrar();
			    else if (op == 3) {
			        System.out.print("ID y nuevo precio: ");
			        int id=sc.nextInt(); double pr=sc.nextDouble();
			        System.out.print("Clave: ");
			        if (sc.next().equals(clave)) dao.actualizar(id, pr); else System.out.println("Clave incorrecta");
			    } else if (op == 4) {
			        System.out.print("ID: ");
			        int id=sc.nextInt(); System.out.print("Clave: ");
			        if (sc.next().equals(clave)) dao.borrar(id); else System.out.println("Clave incorrecta");
			    } else break;
			}
		}
    }
}
