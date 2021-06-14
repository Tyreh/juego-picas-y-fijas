package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * Clase que permite crear un Jdialog para instruir sobre el juego
 *@author Oscar Moreno
 *@author Nicolas Camacho
 *@author Tomas Espitia
 *@author Nelson Fandiño
 *
 */
public class VentanaEntrenamiento2 extends JDialog {
	
	/**
	 * Etiqueta que muestra el titulo introductorio
	 */
    private JLabel eTutorialTitulo;
    /**
     * Etiqueta que contiene el mensaje de tutorial número 1
     */
    private JLabel eTutorial1;
    /**
     * Etiqueta que contiene parte del mensaje de tutorial número 1
     */
    private JLabel eTutorial2;
    /**
     * Etiqueta que contiene el mensaje de tutorial número 2
     */
    private JLabel eTutorial3;
    /**
     * Etiqueta que contiene el mensaje de tutorial número 3
     */
    private JLabel eTutorial4;
    /**
     * Etiqueta que contiene el mensaje de tutorial número 4
     */
    private JLabel eTutorial5;
    /**
     * Etiqueta que contiene el mensaje de tutorial número 5
     */
    private JLabel eTutorial6;
    /**
     * Etiqueta que contiene el mensaje de tutorial número 6
     */
    private JLabel eTutorial7;
    /**
     * Etiqueta que contiene el mensaje de tutorial número 7
     */
    private JLabel eTutorial8;
    /**
     * Etiqueta que contiene el mensaje de tutorial número 8
     */
    private JLabel eTutorial9;
    /**
     * Fuente usada en el titulo
     */
    private Font font;
    /**
     * Fuente usada en los mensajes
     */
    private Font font2;
    /**
     * Método que permite iniciar cada atributo del panel para ser añadido a este, además de permitir estilizarlo
     */
    public VentanaEntrenamiento2() {
        setTitle("Entrenamiento");

        setSize(555, 320);
        setLayout(null);
        getContentPane().setBackground(Color.cyan);
        inicializarComponentes();
        setVisible(false);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    public void inicializarComponentes() {
        font = new Font("Century Gothic", Font.ROMAN_BASELINE, 12);
        font2 = new Font("Century Gothic", Font.BOLD, 14);

        eTutorialTitulo = new JLabel("\u2660 Bienvenido a PICAS y FIJAS! \u2660 ");
        eTutorialTitulo.setFont(font2);
        eTutorialTitulo.setBounds(5, 0, 550, 20);
        add(eTutorialTitulo);

        eTutorial1 = new JLabel("-El juego PICAS y FIJAS consiste en adivinar un nï¿½mero entero, el cual es generado");
        eTutorial1.setFont(font);
        eTutorial1.setBounds(5, 30, 550, 20);
        add(eTutorial1);

        eTutorial2 = new JLabel(" aleatoriamente por el programa.");
        eTutorial2.setFont(font);
        eTutorial2.setBounds(5, 50, 550, 20);
        add(eTutorial2);

        eTutorial3 = new JLabel("- Las PICAS y FIJAS son unas ayudas que suministra el juego para adivinar el nï¿½mero.");
        eTutorial3.setFont(font);
        eTutorial3.setBounds(5, 80, 550, 20);
        add(eTutorial3);

        eTutorial4 = new JLabel("- Selecciona la cantidad de intentos que te gustarï¿½a tener");
        eTutorial4.setFont(font);
        eTutorial4.setBounds(5, 110, 550, 20);
        add(eTutorial4);

        eTutorial5 = new JLabel("- La FIJA se obtiene si se acierta el dï¿½gito y la posicion dentro del nï¿½mero.");
        eTutorial5.setFont(font);
        eTutorial5.setBounds(5, 140, 550, 20);
        add(eTutorial5);

        eTutorial6 = new JLabel("- La PICA se obtiene si se acierta el dï¿½gito pero no la posiciï¿½n dentro del nï¿½mero.");
        eTutorial6.setFont(font);
        eTutorial6.setBounds(5, 170, 550, 20);
        add(eTutorial6);

        eTutorial7 = new JLabel("- Hay un mínimo de 3 pistas dependiendo de la cantidad de dígitos dentro del número.");
        eTutorial7.setFont(font);
        eTutorial7.setBounds(5, 199, 550, 20);
        add(eTutorial7);

        eTutorial8 = new JLabel("- Para utilizar una pista, oprime el sombrero.");
        eTutorial8.setFont(font);
        eTutorial8.setBounds(5, 229, 550, 20);
        add(eTutorial8);

        eTutorial9 = new JLabel("- Para ingresar el nï¿½mero, dï¿½gita el nï¿½mero y oprime el candado.");
        eTutorial9.setFont(font);
        eTutorial9.setBounds(5, 257, 550, 20);
        add(eTutorial9);

    }

    /**
     * Método que permite obtener la etiqueta eTutorialTitulo
     * @return eTutorialTitulo
     */
	public JLabel geteTutorialTitulo() {
		return eTutorialTitulo;
	}

	/**
	 * Método que permite realizar cambios en la etiqueta eTutorialTitulo
	 * @param eTutorialTitulo, simple setter
	 */
	public void seteTutorialTitulo(JLabel eTutorialTitulo) {
		this.eTutorialTitulo = eTutorialTitulo;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial1
     * @return eTutorial1
     */
	public JLabel geteTutorial1() {
		return eTutorial1;
	}

	/**
	 * Método que permite realizar cambios en la etiqueta eTutorial1
	 * @param eTutorial1, simple setter
	 */
	public void seteTutorial1(JLabel eTutorial1) {
		this.eTutorial1 = eTutorial1;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial2
     * @return eTutorial2
     */
	public JLabel geteTutorial2() {
		return eTutorial2;
	}

	/**
	 * Método que permite realizar cambios en la etiqueta eTutorial2
	 * @param eTutorial2, simple setter
	 */
	public void seteTutorial2(JLabel eTutorial2) {
		this.eTutorial2 = eTutorial2;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial3
     * @return eTutorial3
     */
	public JLabel geteTutorial3() {
		return eTutorial3;
	}

	/**
	 * Método que permite realizar cambios en la etiqueta eTutorial3
	 * @param eTutorial3, simple setter
	 */
	public void seteTutorial3(JLabel eTutorial3) {
		this.eTutorial3 = eTutorial3;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial4
     * @return eTutorial4
     */
	public JLabel geteTutorial4() {
		return eTutorial4;
	}

	/**
	 * Método que permite realizar cambios en la etiqueta eTutorial4
	 * @param eTutorial4, simple setter
	 */
	public void seteTutorial4(JLabel eTutorial4) {
		this.eTutorial4 = eTutorial4;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial5
     * @return eTutorial5
     */
	public JLabel geteTutorial5() {
		return eTutorial5;
	}

	/**
	 * Método que permite realizar cambios en la etiqueta eTutorial5
	 * @param eTutorial5, simple setter
	 */
	public void seteTutorial5(JLabel eTutorial5) {
		this.eTutorial5 = eTutorial5;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial6
     * @return eTutorial6
     */
	public JLabel geteTutorial6() {
		return eTutorial6;
	}

	/**
	 * Método que permite realizar cambios en la etiqueta eTutorial6
	 * @param eTutorial6, simple setter
	 */
	public void seteTutorial6(JLabel eTutorial6) {
		this.eTutorial6 = eTutorial6;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial7
     * @return eTutorial7
     */
	public JLabel geteTutorial7() {
		return eTutorial7;
	}

	/**
	 *Método que permite realizar cambios en etiqueta eTutorial7
	 * @param eTutorial7, simple setter
	 */
	public void seteTutorial7(JLabel eTutorial7) {
		this.eTutorial7 = eTutorial7;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial8
     * @return eTutorial8
     */
	public JLabel geteTutorial8() {
		return eTutorial8;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta eTutorial8
	 * @param eTutorial8, simple setters
	 */
	public void seteTutorial8(JLabel eTutorial8) {
		this.eTutorial8 = eTutorial8;
	}

	/**
     * Método que permite obtener la etiqueta eTutorial9
     * @return eTutorial9
     */
	public JLabel geteTutorial9() {
		return eTutorial9;
	}

	/**
	 * Método que permite realizar cambios en la etiqueta eTutorial9
	 * @param eTutorial9, simple setter
	 */
	public void seteTutorial9(JLabel eTutorial9) {
		this.eTutorial9 = eTutorial9;
	}

	/**
	 * Método que permite obtener la fuente de letra font
	 * @return font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * Método que permite realizar cambios en la fuente de letra font
	 * @param font, simple setter
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * Método que permite obtener la fuente de letra font2
	 * @return font2
	 */
	public Font getFont2() {
		return font2;
	}

	/**
	 * Método que permite realizar cambios en la fuente de letra font2
	 * @param font2, simple setter
	 */
	public void setFont2(Font font2) {
		this.font2 = font2;
	}
    
    
}
