package Ejercicio2;

public class InventarioControlador {
    private InventarioModelo modelo;
    private InventarioVista vista;
    public InventarioControlador(InventarioModelo m, InventarioVista v) {
        modelo = m; vista = v;
    }
    public void iniciar() {
        String op;
        do {
            vista.menu();
            op = vista.pedirOpcion();
            switch (op) {
                case "1":
                    modelo.agregar(new Item(vista.pedirNombre(), vista.pedirCantidad()));
                    vista.mostrar("Item agregado.");
                    break;
                case "2":
                    if (modelo.eliminar(vista.pedirNombre())) vista.mostrar("Eliminado.");
                    else vista.mostrar("No encontrado.");
                    break;
                case "3":
                    vista.mostrarInventario(modelo.getItems());
                    break;
                case "4":
                    vista.mostrar("Se guardo, saliendo");
            }
        } while (!op.equals("4"));
    }
}