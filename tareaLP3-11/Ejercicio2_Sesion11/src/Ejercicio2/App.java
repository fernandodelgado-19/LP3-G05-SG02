package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class App extends JFrame {

    DefaultListModel<Producto> modelo = new DefaultListModel<>();
    JList<Producto> lista = new JList<>(modelo);

    CalculadoraDePrecios calc = new CalculadoraDePrecios();

    public App(){

        setTitle("Descuentos - Strategy");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Productos de ejemplo
        modelo.addElement(new Producto("Leche", 10));
        modelo.addElement(new Producto("Pan", 5));
        modelo.addElement(new Producto("Queso", 20));

        add(new JScrollPane(lista), BorderLayout.CENTER);

        // estrategias
        String[] opciones = {
                "Sin Descuento",
                "Descuento Fijo (10%)",
                "2 iguales 30%",
                "3 productos: 50% al más barato"
        };

        JComboBox<String> combo = new JComboBox<>(opciones);
        JButton btnCalcular = new JButton("Calcular Precio Final");

        JPanel abajo = new JPanel();
        abajo.add(combo);
        abajo.add(btnCalcular);
        add(abajo, BorderLayout.SOUTH);

        // Acción del boton
        btnCalcular.addActionListener(e -> {

            ArrayList<Producto> seleccionados = new ArrayList<>(lista.getSelectedValuesList());
            if(seleccionados.isEmpty()){
                JOptionPane.showMessageDialog(this, "Seleccione 1 o más productos.");
                return;
            }

            switch(combo.getSelectedIndex()){
                case 0: calc.setEstrategia(new SinDescuento()); break;
                case 1: calc.setEstrategia(new DescuentoFijo()); break;
                case 2: calc.setEstrategia(new DescuentoPorcentual()); break;
                case 3: calc.setEstrategia(new DescuentoPorcentualAcumulado()); break;
            }

            double total = calc.calcular(seleccionados);

            JOptionPane.showMessageDialog(this, 
                    "Total final: S/" + total);
        });

        setVisible(true);
    }
    public static void main(String[] args){
        new App();
    }
}
