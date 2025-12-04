package Ejercicio2;

import java.util.List;

public class CalculadoraDePrecios {

    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento e){
        estrategia = e;
    }

    public double calcular(List<Producto> productos){
        return estrategia.aplicar(productos);
    }
}
