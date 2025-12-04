package Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    DefaultListModel<Usuario> modeloUsuarios = new DefaultListModel<>();
    DefaultListModel<Usuario> modeloSubs = new DefaultListModel<>();

    JList<Usuario> listaUsuarios = new JList<>(modeloUsuarios);
    JList<Usuario> listaSubscritos = new JList<>(modeloSubs);

    Notificacion noti = new Notificacion();

    public App() {

        setTitle("Sistema de Notificaciones");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Usuarios)
        modeloUsuarios.addElement(new Usuario("Ana"));
        modeloUsuarios.addElement(new Usuario("Luis"));
        modeloUsuarios.addElement(new Usuario("Carlos"));

        // Lista
        JPanel centro = new JPanel(new GridLayout(1,2));
        centro.add(new JScrollPane(listaUsuarios));
        centro.add(new JScrollPane(listaSubscritos));
        add(centro, BorderLayout.CENTER);

        // boto
        JPanel botones = new JPanel();
        JButton btnSub = new JButton("Suscribir");
        JButton btnDes = new JButton("Desuscribir");
        JButton btnEnviar = new JButton("Enviar Notificación");

        botones.add(btnSub);
        botones.add(btnDes);
        botones.add(btnEnviar);
        add(botones, BorderLayout.SOUTH);


        // suscribir
        btnSub.addActionListener(e -> {
            Usuario u = listaUsuarios.getSelectedValue();
            if(u != null && !modeloSubs.contains(u)){
                modeloSubs.addElement(u);
                noti.suscribir(u);
            }
        });
        // quitar
        btnDes.addActionListener(e -> {
            Usuario u = listaSubscritos.getSelectedValue();
            if(u != null){
                modeloSubs.removeElement(u);
                noti.desuscribir(u);
            }
        });
        // enviar men
        btnEnviar.addActionListener(e -> {
            String m = JOptionPane.showInputDialog("Notificación:");
            if(m != null && m.length() > 0){
                noti.enviar(m);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
}