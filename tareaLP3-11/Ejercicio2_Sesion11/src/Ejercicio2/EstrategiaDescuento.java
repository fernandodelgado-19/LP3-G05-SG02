package Ejercicio2;
import java.util.List;

public interface EstrategiaDescuento {
    double aplicar(List<Producto> productos);
}
// Descuen
class SinDescuento implements EstrategiaDescuento {
    public double aplicar(List<Producto> productos){
        return productos.stream().mapToDouble(p -> p.precio).sum();
    }
}
// fijo10
class DescuentoFijo implements EstrategiaDescuento {
    public double aplicar(List<Producto> productos){
        double total = productos.stream().mapToDouble(p -> p.precio).sum();
        return total * 0.90;
    }
}
// 2 : 30%
class DescuentoPorcentual implements EstrategiaDescuento {
    public double aplicar(List<Producto> productos){
        if(productos.size() == 2 &&
           productos.get(0).precio == productos.get(1).precio){
            return productos.get(0).precio * 2 * 0.70;
        }
        return productos.stream().mapToDouble(p -> p.precio).sum();
    }
}
//3: 50%
class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    public double aplicar(List<Producto> productos){
        if(productos.size() < 3)
            return productos.stream().mapToDouble(p -> p.precio).sum();

        double total = productos.stream().mapToDouble(p -> p.precio).sum();
        double menor = productos.stream().mapToDouble(p -> p.precio).min().getAsDouble();

        return total - (menor * 0.50);
    }
}
