package Ejercicio1;

import java.util.ArrayList;

public class Notificacion {
    private ArrayList<Observer> lista = new ArrayList<>();

    public void suscribir(Observer o){
        lista.add(o);
    }
    public void desuscribir(Observer o){
        lista.remove(o);
    }
    public void enviar(String mensaje){
        for(Observer o : lista){
            o.recibir(mensaje);
        }
    }
}
