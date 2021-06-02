package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelJuego extends JPanel {
    private JLabel enumJ1;
    private JLabel enumJ2;

    private JTextField campoJ1;
    private JTextField campoJ2;

    private JButton botonIngresarJ1;
    private JButton botonIngresarJ2;
    private JButton botonPistaJ1;
    private JButton botonPistaJ2;
    private JButton botonVolver;

    private DefaultTableModel mod1;
    private JTable tabla1;
    private JScrollPane scroll1;

    private DefaultTableModel mod2;
    private JTable tabla2;
    private JScrollPane scroll2;

    private TitledBorder borde;

    public PanelJuego() {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
        borde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));
        setBorder(borde);

        botonVolver = new JButton("Volver");
        botonVolver.setBounds(385, 460, 80, 20);
        add(botonVolver);
        botonVolver.setActionCommand("VOLVER");

        // INTERFAZ JUGADOR 1
        enumJ1 = new JLabel("<html>JUGADOR 1<br/>Ingrese un número:</html>");
        enumJ1.setBounds(25, 35, 200, 40);
        add(enumJ1);

        campoJ1 = new JTextField();
        campoJ1.setBounds(25, 75, 200, 20);
        add(campoJ1);

        botonIngresarJ1 = new JButton("Ingresar");
        botonIngresarJ1.setBounds(229, 75, 85, 19);
        botonIngresarJ1.setActionCommand("INGRESAR_J1");
        add(botonIngresarJ1);

        botonPistaJ1 = new JButton("Pista");
        botonPistaJ1.setBounds(319, 75, 85, 19);
        botonPistaJ1.setActionCommand("PISTA_J1");
        add(botonPistaJ1);

        mod1 = new DefaultTableModel(new String[] {"# Intento","Número", "Picas", "Fijas"}, 0);
        tabla1 = new JTable(mod1);
        tabla1.setEnabled(false);
        tabla1.getTableHeader().setReorderingAllowed(false);
        tabla1.getTableHeader().setResizingAllowed(false);
        scroll1 = new JScrollPane(tabla1);
        scroll1.setBounds(25, 100, 380, 350);
        add(scroll1);

        // INTERFAZ JUGADOR 2
        enumJ2 = new JLabel("<html>JUGADOR 2<br/>Ingrese un número:</html>");
        enumJ2.setBounds(445, 35, 200, 40);
        add(enumJ2);

        campoJ2 = new JTextField();
        campoJ2.setBounds(445, 75, 200, 20);
        add(campoJ2);

        botonIngresarJ2 = new JButton("Ingresar");
        botonIngresarJ2.setBounds(649, 75, 85, 19);
        botonIngresarJ2.setActionCommand("INGRESAR_J2");
        add(botonIngresarJ2);

        botonPistaJ2 = new JButton("Pista");
        botonPistaJ2.setBounds(739, 75, 85, 19);
        botonPistaJ2.setActionCommand("PISTA_J2");
        add(botonPistaJ2);

        mod2 = new DefaultTableModel(new String[] {"# Intento","Número", "Picas", "Fijas"}, 0);
        tabla2 = new JTable(mod2);
        tabla2.setEnabled(false);
        tabla2.getTableHeader().setReorderingAllowed(false);
        tabla2.getTableHeader().setResizingAllowed(false);
        scroll2 = new JScrollPane(tabla2);
        scroll2.setBounds(445, 100, 380, 350);
        add(scroll2);
    }

    public JButton getBotonVolver() {
        return botonVolver;
    }

    public JButton getBotonIngresarJ1() {
        return botonIngresarJ1;
    }

    public JButton getBotonIngresarJ2() {
        return botonIngresarJ2;
    }

    public JButton getBotonPistaJ1() {
        return botonPistaJ1;
    }

    public JButton getBotonPistaJ2() {
        return botonPistaJ2;
    }

    public DefaultTableModel getMod1() {
        return mod1;
    }

    public DefaultTableModel getMod2() {
        return mod2;
    }

    public JTextField getCampoJ1() {
        return campoJ1;
    }

    public JTextField getCampoJ2() {
        return campoJ2;
    }

    public TitledBorder getBorde() {
        return borde;
    }

    public JLabel getEnumJ2() {
        return enumJ2;
    }
}