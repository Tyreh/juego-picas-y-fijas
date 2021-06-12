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
	
	
	public VentanaEntrenamiento2() {
		setTitle("Entrenamiento");
		
		setSize(500,280);
		setLayout(null);
		getContentPane().setBackground(new Color(211,255,249));
		inicializarComponentes();
		setVisible(false);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public void inicializarComponentes() {
		Font font = new Font("Century Gothic", Font.ROMAN_BASELINE, 12);
		Font font2 = new Font("Century Gothic", Font.BOLD, 14);
		
		eTutorialTitulo = new JLabel("\u2660 �Bienvenido a PICAS y FIJAS! \u2660 ");
		eTutorialTitulo.setFont(font2);
		eTutorialTitulo.setBounds(5, 0, 500, 20);
		add(eTutorialTitulo);
		
		eTutorial1 = new JLabel("- El juego PICAS y FIJAS consiste en adivinar un n�mero entero, el cual es generado ");
		eTutorial1.setFont(font);
		eTutorial1.setBounds(5, 30, 500, 20);
		add(eTutorial1);
		
		eTutorial2 = new JLabel(" aleatoriamente por el programa.");
		eTutorial2.setFont(font);
		eTutorial2.setBounds(5, 50, 500, 20);
		add(eTutorial2);
		
		eTutorial3 = new JLabel("- Las PICAS y FIJAS son unas ayudas que suministra el juego para adivinar el n�mero.");
		eTutorial3.setFont(font);
		eTutorial3.setBounds(5, 80, 500, 20);
		add(eTutorial3);
		
		eTutorial4 = new JLabel("- La cantidad de intentos depender� de la cantidad de d�gitos que contenga el n�mero");
		eTutorial4.setFont(font);
		eTutorial4.setBounds(5, 110, 500, 20);
		add(eTutorial4);
		
		eTutorial5 = new JLabel("- La FIJA se obtiene si se acierta el d�gito y la posicion dentro del n�mero.");
		eTutorial5.setFont(font);
		eTutorial5.setBounds(5, 140, 500, 20);
		add(eTutorial5);
		
		eTutorial6 = new JLabel("- La PICA se obtiene si se acierta el d�gito pero no la posici�n dentro del n�mero.");
		eTutorial6.setFont(font);
		eTutorial6.setBounds(5, 170, 500, 20);
		add(eTutorial6);
		
		eTutorial7 = new JLabel("- Hay un m�nimo de 3 pistas dependiendo de la cantidad de d�gitos dentro del n�mero. ");
		eTutorial7.setFont(font);
		eTutorial7.setBounds(5, 199, 500, 20);
		add(eTutorial7);

	}
}
