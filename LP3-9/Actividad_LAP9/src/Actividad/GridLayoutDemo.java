package Actividad;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("GridLayout - Grupo: Anderson Choque, Fernando Delgado");
        ventana.setLayout(new GridLayout(2, 3)); 

        ventana.add(new JButton("1"));
        ventana.add(new JButton("2"));
        ventana.add(new JButton("3"));
        ventana.add(new JButton("4"));
        ventana.add(new JButton("5"));
        ventana.add(new JButton("6"));

        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}