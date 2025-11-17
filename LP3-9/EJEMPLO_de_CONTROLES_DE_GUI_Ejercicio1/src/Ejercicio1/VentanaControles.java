package Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaControles extends JFrame {
    private JTextField txtNombre;
    private JCheckBox chkMayorEdad;
    private JRadioButton rbMasculino, rbFemenino;
    private JComboBox<String> cbCiudad;
    private JList<String> listaIntereses;
    private JButton btnMostrar, btnSalir;
    private ButtonGroup grupoGenero;
    // aca laimagen
    ImageIcon icono = new ImageIcon("img/gat.png");

    public VentanaControles() {
        super("Controles de GUI - Anderson Choque y Fernando Delgado");
        setLayout(new FlowLayout());

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(10);
        add(txtNombre);

        chkMayorEdad = new JCheckBox("Soy mayor de edad");
        add(chkMayorEdad);

        add(new JLabel("Género:"));
        rbMasculino = new JRadioButton("Masculino");
        rbFemenino = new JRadioButton("Femenino");
        grupoGenero = new ButtonGroup();
        grupoGenero.add(rbMasculino);
        grupoGenero.add(rbFemenino);
        add(rbMasculino);
        add(rbFemenino);

        add(new JLabel("Ciudad:"));
        cbCiudad = new JComboBox<String>();
        cbCiudad.addItem("Arequipa");
        cbCiudad.addItem("Lima");
        cbCiudad.addItem("Cusco");
        cbCiudad.addItem("Tacna");
        add(cbCiudad);

        add(new JLabel("Intereses:"));
        String[] intereses = {"Música", "Deportes", "Lectesura", "Cine", "Viajes"};
        listaIntereses = new JList<String>(intereses);
        listaIntereses.setVisibleRowCount(3);
        add(new JScrollPane(listaIntereses));

        btnMostrar = new JButton("Mostrar Datos");
        btnSalir = new JButton("Salir");
        add(btnMostrar);
        add(btnSalir);

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void mostrarDatos() {
        String nombre = txtNombre.getText();
        String genero = rbMasculino.isSelected() ? "Masculino" :
                        rbFemenino.isSelected() ? "Femenino" : "No especificado";
        String ciudad = cbCiudad.getSelectedItem().toString();
        String interes = listaIntereses.getSelectedValue();
        String mayor = chkMayorEdad.isSelected() ? "Sí" : "No";
        String mensaje =
                "=== DATOS DEL USUARIO ===\n\n" +
                "Nombre: " + nombre +
                "\nGénero: " + genero +
                "\nCiudad: " + ciudad +
                "\nInterés: " + interes +
                "\nMayor de edad: " + mayor +
                "\n\n--- Thanks por usar el sistema ---";
        //  al del texto
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Resumen",
                JOptionPane.INFORMATION_MESSAGE,
                icono
        );
    }
}
