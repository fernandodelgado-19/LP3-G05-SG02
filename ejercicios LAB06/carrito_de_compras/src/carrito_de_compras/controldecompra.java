package carrito_de_compras;

public class controldecompra {
    private modelotienda modelo;
    private vertienda vista;

    public controldecompra(modelotienda modelo, vertienda vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerTexto("");
            switch (opcion) {
                case "1":
                    vista.mostrarProductos(modelo.obtenerProductos());
                    break;
                case "2":
                    String codigo = vista.leerTexto("Ingrese el código del producto: ");
                    Producto producto = modelo.buscarProductoPorCodigo(codigo);
                    if (producto == null) {
                        vista.mostrarMensaje("El producto no existe.");
                        break;
                    }
                    int cantidad = vista.leerEntero("Ingrese la cantidad: ");
                    if (cantidad <= 0) {
                        vista.mostrarMensaje("Cantidad inválida.");
                        break;
                    }
                    modelo.agregarAlCarrito(producto, cantidad);
                    vista.mostrarMensaje("Producto agregado al carrito.");
                    break;
                case "3":
                    double subtotal = modelo.calcularSubtotal();
                    double envio = modelo.calcularEnvio(subtotal);
                    vista.mostrarCarrito(modelo.obtenerCarrito(), subtotal, envio);
                    break;
                case "4":
                    String eliminar = vista.leerTexto("Ingrese el código del producto a eliminar: ");
                    modelo.eliminarDelCarrito(eliminar);
                    vista.mostrarMensaje("Producto eliminado (si existía).");
                    break;
                case "5":
                    double descuento = 0;
                    try { descuento = Double.parseDouble(vista.leerTexto("Ingrese descuento (%): ")); }
                    catch (Exception e) { descuento = 0; }
                    modelo.realizarCompra(descuento);
                    vista.mostrarMensaje("Compra realizada correctamente.");
                    break;
                case "6":
                    vista.mostrarHistorial(modelo.obtenerHistorialCompras());
                    break;
                case "7":
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("7"));
    }
}
