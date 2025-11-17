package Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutDemo extends JFrame implements ActionListener {
    private JButton[] botones;
    private BorderLayout layout;
    private String[] nombres = {"Norte", "Sur", "Este", "Oeste", "Centro"};

    public BorderLayoutDemo() {
        super("BorderLayout - Anderson Choque y Fernando Delgado");
        layout = new BorderLayout(5, 5);
        setLayout(layout);

        botones = new JButton[nombres.length];
        
        botones[0] = new JButton(nombres[0], new ImageIcon("img/icono-norte.png"));
        botones[0].setHorizontalTextPosition(SwingConstants.LEFT);
        
        botones[1] = new JButton(nombres[1], new ImageIcon("img/incon-sud.png"));
        botones[1].setHorizontalTextPosition(SwingConstants.LEFT);
        
        botones[2] = new JButton(nombres[2], new ImageIcon("img/Este_icon.png"));
        botones[2].setHorizontalTextPosition(SwingConstants.LEFT);
        
        botones[3] = new JButton(nombres[3], new ImageIcon("img/W-icon.png"));
        botones[3].setHorizontalTextPosition(SwingConstants.LEFT);
        
        botones[4] = new JButton(nombres[4], new ImageIcon("img/Center-icon.png"));
        botones[4].setHorizontalTextPosition(SwingConstants.LEFT);

        add(botones[0], BorderLayout.NORTH);
        add(botones[1], BorderLayout.SOUTH);
        add(botones[2], BorderLayout.EAST);
        add(botones[3], BorderLayout.WEST);
        add(botones[4], BorderLayout.CENTER);

        for (JButton b : botones) {
            b.addActionListener(this);
        }

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (JButton b : botones) {
            if (e.getSource() == b) {
                b.setVisible(false);
            } else {
                b.setVisible(true);
            }
        }
        layout.layoutContainer(getContentPane());
    }
}
