package Ejercicio2y3;

public class InventarioView {
    public void mostrarInventario(Jugador jugador, String tipo) {
        System.out.println("\nInventario (" + tipo + "):");
        for (int i = 0; i < jugador.inventario.length; i++) {
            Item item = jugador.inventario[i];
            if (item.tipo.equalsIgnoreCase(tipo) && item.cantidad > 0) {
                System.out.println((i+1) + ". " + item.nombre + " x" + item.cantidad + " - " + item.descripcion);
            }
        }
    }

    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("\nEl combate a iniciado \nEstado actual:");
        System.out.println(jugador.nombre + " Salud: " + jugador.salud);
        System.out.println(enemigo.nombre + " Salud: " + enemigo.salud);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
