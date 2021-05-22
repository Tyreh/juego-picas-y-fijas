package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Objects;

public class PanelOpciones extends JPanel {
    private JLabel enum1;
    private JLabel enum2;
    private JLabel enum3;
    private JLabel enum4;
    private JLabel enum5;
    private JButton botonAceptar;
    JComboBox<Integer> cantidadDigitos;
    JComboBox<String> repetirDigitos;
    JComboBox<Integer> cantidadIntentos;
    JComboBox<String> modoDeJuego;


    public PanelOpciones() {
        setLayout(null);
        inicializarComponentes();
        setVisible(true);
    }

    public void inicializarComponentes() {
        Font fuente = new Font("", -1, 14);

        TitledBorder tituloBorde = new TitledBorder(new LineBorder(new Color(184, 207, 229), 2, false));
        //tituloBorde.setTitleFont(new Font("", Font.BOLD, 13));
        setBorder(tituloBorde);

        enum1 = new JLabel("Seleccione sus opciones de juego");
        enum1.setFont(new Font("", Font.BOLD, 14));
        enum1.setBounds(105, 20, 250, 20);
        add(enum1);

        enum2 = new JLabel("Cantidad de dígitos: ");
        enum2.setFont(fuente);
        enum2.setBounds(82, 60, 200, 20);
        add(enum2);

        enum3 = new JLabel("Repetición de dígitos: ");
        enum3.setFont(fuente);
        enum3.setBounds(82, 90, 200, 20);
        add(enum3);

        enum4 = new JLabel("Cantidad de intentos: ");
        enum4.setFont(fuente);
        enum4.setBounds(82, 120, 200, 20);
        add(enum4);

        enum5 = new JLabel("Modo de juego: ");
        enum5.setFont(fuente);
        enum5.setBounds(82, 150, 200, 20);
        add(enum5);


        cantidadDigitos = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        cantidadDigitos.setBounds(243, 60, 140, 20);
        add(cantidadDigitos);

        repetirDigitos = new JComboBox<>(new String[]{"Si", "No"});
        repetirDigitos.setBounds(243, 90, 140, 20);
        add(repetirDigitos);

        Integer[] numeros = new Integer[(int) cantidadDigitos.getSelectedItem() * 5]; // array de 10 elementos
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }

        cantidadIntentos = new JComboBox<>(numeros);
        cantidadIntentos.setBounds(243, 120, 140, 20);
        add(cantidadIntentos);


       /* int auxInt = (int) cantidadDigitos.getSelectedItem() * 5;
        for (int i = 1; i <= auxInt; i++) {
            if (Integer.parseInt((String) Objects.requireNonNull(cantidadDigitos.getSelectedItem())) == i) {
                for (int j = 0; j < i; j++) {
                    cantidadIntentos.addItem(i);
                }
            }
            cantidadIntentos.addItem(i);
        }*/

        modoDeJuego = new JComboBox<>(new String[]{"Entrenamiento", "Jugador vs Jugador", "Jugador vs Máquina"});
        modoDeJuego.setBounds(243, 150, 140, 20);
        add(modoDeJuego);


        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(82, 190, 301, 20);
        botonAceptar.setActionCommand("CONFIRMAR_OPCIONES_DE_JUEGO");
        add(botonAceptar);
    }

    public JLabel getEnum1() {
        return enum1;
    }

    public JLabel getEnum2() {
        return enum2;
    }

    public JLabel getEnum3() {
        return enum3;
    }

    public JLabel getEnum4() {
        return enum4;
    }

    public JLabel getEnum5() {
        return enum5;
    }

    public JButton getBotonAceptar() {
        return botonAceptar;
    }

    public JComboBox<Integer> getCantidadDigitos() {
        return cantidadDigitos;
    }

    public JComboBox<String> getRepetirDigitos() {
        return repetirDigitos;
    }

    public JComboBox<Integer> getCantidadIntentos() {
        return cantidadIntentos;
    }

    public JComboBox<String> getModoDeJuego() {
        return modoDeJuego;
    }
}
