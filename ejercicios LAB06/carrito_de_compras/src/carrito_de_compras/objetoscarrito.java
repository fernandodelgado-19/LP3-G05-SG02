package carrito_de_compras;

public class objetoscarrito {
    private Producto producto;
    private int cantidad;

    public objetoscarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double obtenerSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}
