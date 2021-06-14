package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
/**
 * Clase que permite crear un panel, en este caso el panel de bienvenida del juego
 *@author Oscar Moreno
 *@author Nicolas Camacho
 *@author Tomas Espitia
 *@author Nelson Fandiño
 *
 */
public class PanelBienvenida extends JPanel {
	/**
	 * Botón que aparece en el panel
	 */
    private JButton botonAceptar;
    /**
     * Linea que rodea el panel 
     */
    private TitledBorder tituloBorde;
    /**
     * Etiqueta que aparece en el panel 
     */
    private JLabel enum1;
    /**
     * Etiqueta donde aperece los mensajes  "profesor", "materia" e "Integrantes"
     */
    private JLabel enum2;
    /**
     * Etiqueta donde aparece el nombre del profesor, integrantes y materia
     */
    private JLabel enum3;
    /**
     * Imagen que aparece en el botón del panel
     */
    private ImageIcon ak;
    /**
     * Método constructor de la clase PanelBienvenida
     */
    public PanelBienvenida() {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }
    /**
     * Método que permite iniciar cada atributo del panel para ser añadido a este, además de permitir estilizarlo
     */
    public void inicializarComponentes() {
        setBackground(Color.CYAN);

        tituloBorde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));
        setBorder(tituloBorde);

        enum1 = new JLabel("¿Lograrás descifrar el codigo?", SwingConstants.CENTER);
        enum1.setFont(new Font("", Font.BOLD, 14));
        enum1.setBounds(103, 10, 250, 20);
        add(enum1);

        enum2 = new JLabel("<html>Profesor:<br/><br/>Materia:<br/><br/>Integrantes:</html>");
        enum2.setFont(new Font("", Font.BOLD, 14));
        enum2.setBounds(82, 50, 200, 100);
        add(enum2);

        enum3 = new JLabel("<html>Helio Ramírez<br/><br/>Fundamentos de programacion<br/><br/>Oscar Moreno, Nelson Fandiño<br/>Tomas Espitia, Nicolas Camacho</html>");
        enum3.setFont(new Font("", -1, 14));
        enum3.setBounds(200, 10, 220, 200);
        add(enum3);

        botonAceptar = new JButton();
        botonAceptar.setBounds(150, 190, 150, 40);
        botonAceptar.setOpaque(false);
        botonAceptar.setContentAreaFilled(false);
        botonAceptar.setBorderPainted(false);
        botonAceptar.setToolTipText("¡Haz clic para comenzar a jugar!");
        botonAceptar.setActionCommand("VAMOS_A_ROBAR");
        ak = new ImageIcon("src/Images/Ak1.png");
        botonAceptar.setIcon(new ImageIcon(ak.getImage().getScaledInstance(botonAceptar.getWidth(), botonAceptar.getHeight(), Image.SCALE_SMOOTH)));
        add(botonAceptar);
    }

    /**
     * Método que permite llamar el botonAceptar
     * @return retorna el botonAceptar
     */
    public JButton getBotonAceptar() {
        return botonAceptar;    
    }
    
    /**
     * Método que permite llamar el borde del panel
     * @return retorna tituloborde
     */
	public TitledBorder getTituloBorde() {
		return tituloBorde;
	}
	
	 /**
     * Método que permite realizar cambios en el borde del panel
     * @param tituloBorde, simple setter
     */
	public void setTituloBorde(TitledBorder tituloBorde) {
		this.tituloBorde = tituloBorde;
	}
	
	 /**
     * Método que permite llamar la etiqueta enum1
     * @return enum1
     */
	public JLabel getEnum1() {
		return enum1;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta enum1
	 * @param enum1, simple setter
	 */
	public void setEnum1(JLabel enum1) {
		this.enum1 = enum1;
	}
	
	 /**
     * Método que permite llamar la etiqueta enum2
     * @return retorna enum2
     */
	public JLabel getEnum2() {
		return enum2;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta enum2
	 * @param enum2, simple setter
	 */
	public void setEnum2(JLabel enum2) {
		this.enum2 = enum2;
	}
	
	/**
     * Método que permite llamar la etiqueta enum3
     * @return retorna enum3
     */
	public JLabel getEnum3() {
		return enum3;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta enum3
	 * @param enum3, simple setter
	 */
	public void setEnum3(JLabel enum3) {
		this.enum3 = enum3;
	}
	
	/**
	 * Método que permite llamar la imagen ak
	 * @return ak
	 */
	public ImageIcon getAk() {
		return ak;
	}
	/**
	 * Método que permite realizar cambios en la imagen ak
	 * @param ak, simple setter
	 */
	public void setAk(ImageIcon ak) {
		this.ak = ak;
	}
	
	/**
	 * Método que permite realizar cambios en el botón botonAceptar
	 * @param botonAceptar, simple setter
	 */
	public void setBotonAceptar(JButton botonAceptar) {
		this.botonAceptar = botonAceptar;
	}
}
