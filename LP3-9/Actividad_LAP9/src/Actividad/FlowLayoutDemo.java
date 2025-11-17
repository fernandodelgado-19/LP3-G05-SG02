package Actividad;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("FlowLayout - Anderson Choque, Fernando Delgado");
        ventana.setLayout(new FlowLayout());

        ventana.add(new JButton("Botón 1"));
        ventana.add(new JButton("Botón 2"));
        ventana.add(new JButton("Botón 3"));
        ventana.add(new JButton("Botón 4"));
        ventana.add(new JButton("Botón 5"));

        ventana.setSize(400, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
