package Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaDragDrop extends JFrame {
    private JTextField campoTexto;
    private JButton botonSaludo;
    // imagen
    ImageIcon icono = new ImageIcon("img/images.png");

    public VentanaDragDrop() {
        super("GUI Arrastrar y Soltar - Anderson Choque y Fernando Delgado");
        setLayout(new FlowLayout());
        add(new JLabel("Escribe tu nombre:"));
        campoTexto = new JTextField(10);
        add(campoTexto);
        botonSaludo = new JButton("Saludar");
        add(botonSaludo);
        botonSaludo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarSaludo();
            }
        });
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void mostrarSaludo() {
        String nombre = campoTexto.getText();
        String mensaje =
                "Hola " + nombre + "\n";
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Saludo",
                JOptionPane.INFORMATION_MESSAGE,
                icono
        );
    }
}
