package Ejercicio3;

import java.util.List;

class SinDescuento implements Estrategia {

    public double calcular(List<Producto> p){
        double t = 0;
        for(Producto x : p) t += x.precio;
        return t;
    }

    public String getNombre(){ return "Sin Descuento"; }

    public String toString(){ return getNombre(); }
}

class Descuento10 implements Estrategia {

    public double calcular(List<Producto> p){
        double t = 0;
        for(Producto x : p) t += x.precio;
        return t * 0.90;
    }

    public String getNombre(){ return "10% Fijo"; }

    public String toString(){ return getNombre(); }
}

class DosIguales30 implements Estrategia {

    public double calcular(List<Producto> p){
        if(p.size()==2){
            Producto a = p.get(0);
            Producto b = p.get(1);
            if(a.precio == b.precio){
                return (a.precio + b.precio) * 0.70;
            }
        }
        double t = 0;
        for(Producto x : p) t += x.precio;
        return t;
    }
    public String getNombre(){ return "30% si son iguales"; }

    public String toString(){ return getNombre(); }
}
class Acumulado50 implements Estrategia {

    public double calcular(List<Producto> p){
        if(p.size() < 3){
            double t = 0;
            for(Producto x : p) t += x.precio;
            return t;
        }

        double t = 0;
        double menor = p.get(0).precio;

        for(Producto x : p){
            t += x.precio;
            if(x.precio < menor) menor = x.precio;
        }

        return t - (menor * 0.50);
    }
    public String getNombre(){ return "50% al más barato (3+)"; }

    public String toString(){ return getNombre(); }
}
