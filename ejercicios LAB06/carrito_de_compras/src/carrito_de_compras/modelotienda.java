package carrito_de_compras;

import java.util.*;

public class modelotienda {
    private List<Producto> listaProductos;
    private List<objetoscarrito> carrito;
    private List<String> historialCompras;

    public modelotienda() {
        listaProductos = new ArrayList<>();
        carrito = new ArrayList<>();
        historialCompras = new ArrayList<>();
        cargarProductos();
    }

    private void cargarProductos() {
        listaProductos.add(new Producto("P001", "Camiseta", 39.90));
        listaProductos.add(new Producto("P002", "Pantalón", 89.50));
        listaProductos.add(new Producto("P003", "Gorra", 25.00));
        listaProductos.add(new Producto("P004", "Auriculares", 129.99));
    }

    public List<Producto> obtenerProductos() { return listaProductos; }

    public void agregarAlCarrito(Producto producto, int cantidad) {
        for (objetoscarrito item : carrito) {
            if (item.getProducto().getCodigo().equals(producto.getCodigo())) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        carrito.add(new objetoscarrito(producto, cantidad));
    }

    public List<objetoscarrito> obtenerCarrito() { return carrito; }

    public void eliminarDelCarrito(String codigoProducto) {
        carrito.removeIf(item -> item.getProducto().getCodigo().equals(codigoProducto));
    }

    public double calcularSubtotal() {
        double total = 0;
        for (objetoscarrito item : carrito) total += item.obtenerSubtotal();
        return total;
    }

    public double calcularEnvio(double subtotal) {
        return subtotal >= 150.0 ? 0.0 : 10.0;
    }

    public double aplicarDescuento(double subtotal, double descuentoPorcentaje) {
        if (descuentoPorcentaje <= 0) return subtotal;
        return subtotal * (1 - descuentoPorcentaje / 100.0);
    }

    public void realizarCompra(double descuentoPorcentaje) {
        double subtotal = calcularSubtotal();
        double conDescuento = aplicarDescuento(subtotal, descuentoPorcentaje);
        double envio = calcularEnvio(conDescuento);
        double total = conDescuento + envio;

        String resumen = String.format(
            "COMPRA - Subtotal: S/%.2f | Descuento: %.1f%% | Envío: S/%.2f | TOTAL: S/%.2f",
            subtotal, descuentoPorcentaje, envio, total
        );

        historialCompras.add(resumen);
        carrito.clear();
    }

    public List<String> obtenerHistorialCompras() { return historialCompras; }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto p : listaProductos)
            if (p.getCodigo().equals(codigo)) return p;
        return null;
    }
}

