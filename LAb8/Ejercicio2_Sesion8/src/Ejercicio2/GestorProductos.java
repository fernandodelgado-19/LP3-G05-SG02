package Ejercicio2;

import java.util.*;

public class GestorProductos {
    ProductoDAO dao;
    public GestorProductos(ProductoDAO dao) { this.dao = dao; }

    public void consultar(String campo, String filtro, String orden, int limite) {
        List<Producto> datos = new ArrayList<>(dao.lista);

        if (!filtro.equals("todos"))
            datos.removeIf(p -> !p.nombre.contains(filtro));

        datos.sort((a, b) -> orden.equals("asc") ? a.nombre.compareTo(b.nombre)
                                                 : b.nombre.compareTo(a.nombre));

        if (limite < datos.size()) datos = datos.subList(0, limite);

        for (Producto p : datos) {
            if (campo.equals("nombre")) System.out.println(p.nombre);
            else if (campo.equals("precio")) System.out.println(p.precio);
            else System.out.println(p);
        }
    }
}
