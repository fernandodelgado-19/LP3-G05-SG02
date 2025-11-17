package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPasajes extends JFrame {
    private JTextField txtNombre, txtDni, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listaServicio;
    private JButton btnMostrar, btnLimpiar;
    private ButtonGroup grupoPisos;
    
    ImageIcon icono = new ImageIcon("img/amv.png");

    public VentanaPasajes() {
        super("Compra de Pasajes - Anderson Choque y Fernando Delgado");
        setLayout(new FlowLayout());

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField(10);
        add(txtNombre);

        add(new JLabel("DNI:"));
        txtDni = new JTextField(8);
        add(txtDni);

        add(new JLabel("Fecha de Viaje:"));
        txtFecha = new JTextField(8);
        add(txtFecha);

        add(new JLabel("Servicios opcionales:"));
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        add(chkAudifonos);
        add(chkManta);
        add(chkRevistas);

        add(new JLabel("Seleccione piso:"));
        rbPrimerPiso = new JRadioButton("1er Piso");
        rbSegundoPiso = new JRadioButton("2do Piso");
        grupoPisos = new ButtonGroup();
        grupoPisos.add(rbPrimerPiso);
        grupoPisos.add(rbSegundoPiso);
        add(rbPrimerPiso);
        add(rbSegundoPiso);

        add(new JLabel("Origen:"));
        cbOrigen = new JComboBox<String>();
        cbOrigen.addItem("Arequipa");
        cbOrigen.addItem("Lima");
        cbOrigen.addItem("Cusco");
        add(cbOrigen);

        add(new JLabel("Destino:"));
        cbDestino = new JComboBox<String>();
        cbDestino.addItem("Tacna");
        cbDestino.addItem("Puno");
        cbDestino.addItem("Trujillo");
        add(cbDestino);

        add(new JLabel("Calidad de servicio:"));
        String[] servicios = {"Económico", "Standard", "VIP"};
        listaServicio = new JList<String>(servicios);
        listaServicio.setVisibleRowCount(3);
        add(new JScrollPane(listaServicio));

        btnMostrar = new JButton("Mostrar Datos");
        btnLimpiar = new JButton("Limpiar");
        add(btnMostrar);
        add(btnLimpiar);

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void mostrarResumen() {
        String nombre = txtNombre.getText();
        String dni = txtDni.getText();
        String fecha = txtFecha.getText();

        String servicios = "";
        if (chkAudifonos.isSelected()) servicios += "Audífonos ";
        if (chkManta.isSelected()) servicios += "Manta ";
        if (chkRevistas.isSelected()) servicios += "Revistas ";

        String piso = rbPrimerPiso.isSelected() ? "1er Piso" :
                      rbSegundoPiso.isSelected() ? "2do Piso" : "No seleccionado";

        String origen = cbOrigen.getSelectedItem().toString();
        String destino = cbDestino.getSelectedItem().toString();

        String servicio = listaServicio.getSelectedValue();

        String mensaje = "=== RESUMEN DE COMPRA ===\n\n" +
                "Nombre: " + nombre +
                "\nDNI: " + dni +
                "\nFecha: " + fecha +
                "\nOrigen: " + origen +
                "\nDestino: " + destino +
                "\nPiso: " + piso +
                "\nServicio: " + servicio +
                "\nServicios opcionales: " + servicios;
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Resumen",
                JOptionPane.INFORMATION_MESSAGE,
                icono
        );
        JOptionPane.showMessageDialog(this, mensaje, "Resumen de Pasaje", JOptionPane.INFORMATION_MESSAGE);
    }
    private void limpiarCampos() {
        txtNombre.setText("");
        txtDni.setText("");
        txtFecha.setText("");
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        grupoPisos.clearSelection();
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        listaServicio.clearSelection();
    }
}
