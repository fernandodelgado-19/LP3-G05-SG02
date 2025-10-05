package carrito_de_compras;

public class Main {
    public static void main(String[] args) {
        modelotienda modelo = new modelotienda();
        vertienda vista = new vertienda();
        controldecompra controlador = new controldecompra(modelo, vista);
        controlador.iniciar();
    }
}
