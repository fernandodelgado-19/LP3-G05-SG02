package Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlowLayoutDemo extends JFrame {
    private JButton btnIzquierda, btnCentro, btnDerecha;
    private FlowLayout layout;
    private Container contenedor;
    public FlowLayoutDemo() {
        super("FlowLayout - Anderson Choque y Fernando Delgado");

        layout = new FlowLayout();
        setLayout(layout);
        contenedor = getContentPane();

        ImageIcon iconoIzq = new ImageIcon("img/iz.png");
        ImageIcon iconoCen = new ImageIcon("img/cen.png");
        ImageIcon iconoDer = new ImageIcon("img/derech.png");

        btnIzquierda = new JButton("Izquierda", iconoIzq);
        btnCentro = new JButton("Centro", iconoCen);
        btnDerecha = new JButton("Derecha", iconoDer);

        btnIzquierda.setHorizontalTextPosition(SwingConstants.LEFT);
        btnCentro.setHorizontalTextPosition(SwingConstants.LEFT);
        btnDerecha.setHorizontalTextPosition(SwingConstants.LEFT);

        add(btnIzquierda);
        add(btnCentro);
        add(btnDerecha);

        btnIzquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.LEFT);
                layout.layoutContainer(contenedor);
            }
        });
        btnCentro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.CENTER);
                layout.layoutContainer(contenedor);
            }
        });
        btnDerecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.RIGHT);
                layout.layoutContainer(contenedor);
            }
        });
        setSize(600, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
