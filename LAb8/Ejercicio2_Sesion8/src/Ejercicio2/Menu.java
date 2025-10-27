package Ejercicio2;

import java.util.*;

public class Menu {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			ProductoDAO dao = new ProductoDAO();
			GestorProductos gestor = new GestorProductos(dao);
			String clave = "1234";

			while (true) {
			    System.out.println("\n1.Agregar  2.Mostrar  3.Actualizar  4.Eliminar  5.Consultar  6.Salir");
			    int op = sc.nextInt();

			    if (op == 1) {
			        System.out.print("ID Nombre Precio Stock: ");
			        dao.agregar(new Producto(sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextInt()));
			    }

			    else if (op == 2) dao.mostrar();

			    else if (op == 3) {
			        System.out.print("ID y nuevo precio: ");
			        int id = sc.nextInt(); double precio = sc.nextDouble();
			        System.out.print("Clave: ");
			        if (sc.next().equals(clave)) dao.actualizar(id, precio);
			        else System.out.println("Clave incorrecta.");
			    }

			    else if (op == 4) {
			        System.out.print("ID: "); int id = sc.nextInt();
			        System.out.print("Clave: ");
			        if (sc.next().equals(clave)) dao.eliminar(id);
			        else System.out.println("Clave incorrecta.");
			    }

			    else if (op == 5) {
			        System.out.print("Campo(nombre/precio/todo): "); String campo = sc.next();
			        System.out.print("Filtro(o 'todos'): "); String filtro = sc.next();
			        System.out.print("Orden(asc/desc): "); String orden = sc.next();
			        System.out.print("Limite: "); int lim = sc.nextInt();
			        gestor.consultar(campo, filtro, orden, lim);
			    }

			    else break;
			}
		}
    }
}
