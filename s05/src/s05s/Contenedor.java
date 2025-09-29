package s05s;

import java.util.ArrayList;
import java.util.List;

public class Contenedor<F, S> {
    private List<Par<F, S>> listaPares;

    public Contenedor() {
        listaPares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        listaPares.add(new Par<>(primero, segundo));
    }

    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < listaPares.size()) {
            return listaPares.get(indice);
        }
        return null;
    }

    public List<Par<F, S>> obtenerTodosLosPares() {
        return listaPares;
    }

    public void mostrarPares() {
        for (Par<F, S> par : listaPares) {
            System.out.println(par);
        }
    }

    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor = new Contenedor<>();
        contenedor.agregarPar("Uno", 1);
        contenedor.agregarPar("Dos", 2);
        contenedor.agregarPar("Tres", 3);

        System.out.println("Todos los pares en el contenedor:");
        contenedor.mostrarPares();
    }
}
