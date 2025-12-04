package Ejercicio3;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class AppDescuentos extends JFrame {

    DefaultListModel<Producto> modelo = new DefaultListModel<>();
    JList<Producto> lista = new JList<>(modelo);

    JComboBox<Estrategia> combo;
    JTextArea resumen;

    public AppDescuentos(){

        setTitle("Sistema de Descuentos");
        setSize(700,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Titulo
        JLabel titulo = new JLabel("SISTEMA DE DESCUENTOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(titulo, BorderLayout.NORTH);

        // EstrategiaS
        combo = new JComboBox<>();
        combo.addItem(new SinDescuento());
        combo.addItem(new Descuento10());
        combo.addItem(new DosIguales30());
        combo.addItem(new Acumulado50());

        resumen = new JTextArea();
        resumen.setEditable(false);
        resumen.setFont(new Font("Consolas", Font.PLAIN, 14));
        resumen.setBorder(BorderFactory.createTitledBorder("Resumen de Compra"));

        lista.setBorder(BorderFactory.createTitledBorder("Productos Disponibles"));
        lista.setFont(new Font("Arial", Font.PLAIN, 14));

        // btones
        JButton add = new JButton("Agregar");
        JButton del = new JButton("Eliminar");
        JButton calc = new JButton("Calcular");
        JButton save = new JButton("Guardar");
        JButton load = new JButton("Cargar");

        JPanel abajo = new JPanel();
        abajo.add(add);
        abajo.add(del);
        abajo.add(calc);
        abajo.add(save);
        abajo.add(load);
        abajo.add(combo);

        // Division vertical
        JSplitPane division = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(lista),
                new JScrollPane(resumen)
        );

        division.setDividerLocation(300);
        division.setResizeWeight(0.5);

        add(division, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);

        // Eventos
        add.addActionListener(e -> agregar());
        del.addActionListener(e -> eliminar());
        calc.addActionListener(e -> calcular());
        save.addActionListener(e -> guardar());
        load.addActionListener(e -> cargar());

        setVisible(true);
    }

    void agregar(){
        String n = JOptionPane.showInputDialog("Nombre del producto:");
        String p = JOptionPane.showInputDialog("Precio:");

        if(n != null && p != null){
            try{
                double precio = Double.parseDouble(p);
                modelo.addElement(new Producto(n, precio));
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Precio inválido");
            }
        }
    }

    void eliminar(){
        Producto p = lista.getSelectedValue();
        if(p != null) modelo.removeElement(p);
    }

    void calcular(){
        ArrayList<Producto> sel = new ArrayList<>(lista.getSelectedValuesList());
        if(sel.isEmpty()){
            resumen.setText("Seleccione productos.\n");
            return;
        }

        Estrategia e = (Estrategia) combo.getSelectedItem();
        double total = e.calcular(sel);

        resumen.setText("");
        resumen.append("------- Detalle de Compra -------\n");
        for(Producto x : sel){
            resumen.append(x.nombre + "   S/" + x.precio + "\n");
        }
        resumen.append("---------------------------------\n");
        resumen.append("Estrategia: " + e.getNombre() + "\n");
        resumen.append("TOTAL FINAL: S/" + total + "\n");
    }

    void guardar(){
        try(PrintWriter pw = new PrintWriter("productos.txt")){
            for(int i = 0; i < modelo.size(); i++){
                Producto p = modelo.get(i);
                pw.println(p.nombre + ";" + p.precio);
            }
            resumen.append("Guardado.\n");
        }catch(Exception ex){
            resumen.append("Error al guardar.\n");
        }
    }

    void cargar(){
        modelo.clear();
        try(BufferedReader br = new BufferedReader(new FileReader("productos.txt"))){
            String lin;
            while((lin = br.readLine()) != null){
                String[] x = lin.split(";");
                modelo.addElement(new Producto(x[0], Double.parseDouble(x[1])));
            }
            resumen.append("Productos cargados.\n");
        }catch(Exception ex){
            resumen.append("No existe archivo.\n");
        }
    }

    public static void main(String[] args){
        new AppDescuentos();
    }
}
