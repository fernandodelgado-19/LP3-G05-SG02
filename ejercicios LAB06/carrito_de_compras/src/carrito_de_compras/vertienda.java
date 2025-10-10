package carrito_de_compras;

import java.util.List;
import java.util.Scanner;

public class vertienda {
    private Scanner entrada = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n===== MENÚ DE TIENDA =====");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar producto del carrito");
        System.out.println("5. Aplicar descuento y comprar");
        System.out.println("6. Ver historial de compras");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarProductos(List<Producto> lista) {
        System.out.println("\nCatálogo de productos:");
        for (Producto p : lista)
            System.out.println(p);
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine().trim();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try { return Integer.parseInt(entrada.nextLine().trim()); }
        catch (Exception e) { return 0; }
    }

    public void mostrarCarrito(List<objetoscarrito> carrito, double subtotal, double envio) {
        System.out.println("\nCarrito de compras:");
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        for (objetoscarrito item : carrito) {
            System.out.println(item.getProducto().getCodigo() + " - " +
                    item.getProducto().getNombre() + " x" + item.getCantidad() +
                    " -> S/ " + String.format("%.2f", item.obtenerSubtotal()));
        }
        System.out.println("Subtotal: S/ " + String.format("%.2f", subtotal));
        System.out.println("Costo de envío: S/ " + String.format("%.2f", envio));
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarHistorial(List<String> historial) {
        System.out.println("\nHistorial de compras:");
        if (historial.isEmpty()) {
            System.out.println("Aún no se han realizado compras.");
        } else {
            for (String registro : historial)
                System.out.println(registro);
        }
    }
}
