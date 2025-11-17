package Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GridLayoutDemo extends JFrame implements ActionListener {

    private JButton[] botones;
    private GridLayout grid1, grid2;
    private Container contenedor;
    private boolean alternar = true;
    public GridLayoutDemo() {
        super("GridLayout - Anderson Choque y Fernando Delgado");

        grid1 = new GridLayout(2, 3, 5, 5);
        grid2 = new GridLayout(3, 2, 5, 5);

        contenedor = getContentPane();
        setLayout(grid1);

        ImageIcon uno  = new ImageIcon("img/uno.png");
        ImageIcon dos    = new ImageIcon("img/dos.png");
        ImageIcon tres   = new ImageIcon("img/tres.png");
        ImageIcon cuatro  = new ImageIcon("img/cuatro.png");
        ImageIcon cinco = new ImageIcon("img/cinco.png");

        botones = new JButton[6];
        botones[0] = new JButton("Uno", uno);
        botones[1] = new JButton("Dos", dos);
        botones[2] = new JButton("Tres", tres);
        botones[3] = new JButton("Cuatro", cuatro);
        botones[4] = new JButton("Cinco", cinco);
        botones[5] = new JButton("Seis", uno); 

        for (int i = 0; i < botones.length; i++) {
            botones[i].setHorizontalTextPosition(SwingConstants.LEFT);
            botones[i].addActionListener(this);
            add(botones[i]);
        }
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (alternar) {
            contenedor.setLayout(grid2);  // cam a 3x2
        } else {
            contenedor.setLayout(grid1);  // regre a 2x3
        }
        alternar = !alternar;
        contenedor.validate();  // un refres
    }
}
