package Ejercicio2;

public class MainInventario {
    public static void main(String[] args) {
        InventarioModelo m = new InventarioModelo();
        InventarioVista v = new InventarioVista();
        InventarioControlador c = new InventarioControlador(m, v);
        c.iniciar();
    }
}