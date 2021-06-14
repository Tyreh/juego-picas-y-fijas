package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class VentanaEntrenamiento2 extends JDialog {
    private JLabel eTutorialTitulo;
    private JLabel eTutorial1;
    private JLabel eTutorial2;
    private JLabel eTutorial3;
    private JLabel eTutorial4;
    private JLabel eTutorial5;
    private JLabel eTutorial6;
    private JLabel eTutorial7;
    private JLabel eTutorial8;
    private JLabel eTutorial9;


    public VentanaEntrenamiento2() {
        setTitle("Entrenamiento");

        setSize(550, 320);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);
        inicializarComponentes();
        setVisible(false);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    public void inicializarComponentes() {
        Font font = new Font("Century Gothic", Font.ROMAN_BASELINE, 12);
        Font font2 = new Font("Century Gothic", Font.BOLD, 14);

        eTutorialTitulo = new JLabel("\u2660 �Bienvenido a PICAS y FIJAS! \u2660 ");
        eTutorialTitulo.setFont(font2);
        eTutorialTitulo.setBounds(5, 0, 550, 20);
        add(eTutorialTitulo);

        eTutorial1 = new JLabel("- El juego PICAS y FIJAS consiste en adivinar un n�mero entero, el cual es generado");
        eTutorial1.setFont(font);
        eTutorial1.setBounds(5, 30, 550, 20);
        add(eTutorial1);

        eTutorial2 = new JLabel(" aleatoriamente por el programa.");
        eTutorial2.setFont(font);
        eTutorial2.setBounds(5, 50, 550, 20);
        add(eTutorial2);

        eTutorial3 = new JLabel("- Las PICAS y FIJAS son unas ayudas que suministra el juego para adivinar el n�mero.");
        eTutorial3.setFont(font);
        eTutorial3.setBounds(5, 80, 550, 20);
        add(eTutorial3);

        eTutorial4 = new JLabel("- Selecciona la cantidad de intentos que te gustar�a tener");
        eTutorial4.setFont(font);
        eTutorial4.setBounds(5, 110, 550, 20);
        add(eTutorial4);

        eTutorial5 = new JLabel("- La FIJA se obtiene si se acierta el d�gito y la posicion dentro del n�mero.");
        eTutorial5.setFont(font);
        eTutorial5.setBounds(5, 140, 550, 20);
        add(eTutorial5);

        eTutorial6 = new JLabel("- La PICA se obtiene si se acierta el d�gito pero no la posici�n dentro del n�mero.");
        eTutorial6.setFont(font);
        eTutorial6.setBounds(5, 170, 550, 20);
        add(eTutorial6);

        eTutorial7 = new JLabel("- Hay un m�nimo de 3 pistas dependiendo de la cantidad de d�gitos dentro del n�mero.");
        eTutorial7.setFont(font);
        eTutorial7.setBounds(5, 199, 550, 20);
        add(eTutorial7);

        eTutorial8 = new JLabel("- Para utilizar una pista, oprime el sombrero.");
        eTutorial8.setFont(font);
        eTutorial8.setBounds(5, 229, 550, 20);
        add(eTutorial8);

        eTutorial9 = new JLabel("- Para ingresar el n�mero, d�gita el n�mero y oprime el candado.");
        eTutorial9.setFont(font);
        eTutorial9.setBounds(5, 257, 550, 20);
        add(eTutorial9);

    }
}
