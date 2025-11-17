package Actividad;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("BorderLayout - Grupo: Anderson Choque, Fernando Delgado ");
        ventana.setLayout(new BorderLayout());

        ventana.add(new JButton("Norte"), BorderLayout.NORTH);
        ventana.add(new JButton("Sur"), BorderLayout.SOUTH);
        ventana.add(new JButton("Este"), BorderLayout.EAST);
        ventana.add(new JButton("Oeste"), BorderLayout.WEST);
        ventana.add(new JButton("Centro"), BorderLayout.CENTER);

        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
