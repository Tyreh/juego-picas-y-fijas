package co.edu.unbosque.view;

import javax.swing.*;

public class PanelJuego extends JPanel {
    private JLabel enum1;
    private JButton botonAceptar;
    private JButton botonRendirse;

    public PanelJuego() {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
        botonAceptar = new JButton("Ingresar");
        botonAceptar.setBounds(100,100,100,100);
        botonAceptar.setActionCommand("INGRESAR");
        add(botonAceptar);

        botonRendirse = new JButton("Rendirse");
        botonRendirse.setBounds(100,200,100,100);
        botonRendirse.setActionCommand("RENDIRSE");
        add(botonRendirse);
    }
}
