package Ejercicio1;

import javax.swing.*;

public class Usuario implements Observer {
    String nombre;

    public Usuario(String n){
        nombre = n;
    }

    public void recibir(String mensaje){
        JOptionPane.showMessageDialog(null, nombre + " recibió: " + mensaje);
    }

    public String toString(){
        return nombre;
    }
}

interface Observer {
    void recibir(String mensaje);
}
