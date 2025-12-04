package Ejercicio3;

import java.util.List;

public interface Estrategia {
    double calcular(List<Producto> productos);
    String getNombre();
}
