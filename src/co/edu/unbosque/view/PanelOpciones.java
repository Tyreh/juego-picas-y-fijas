package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
/**
 * Clase que permite crear un panel, este caso el panel de opciones del juego
 *@author Oscar Moreno
 *@author Nicolas Camacho
 *@author Tomas Espitia
 *@author Nelson Fandiño
 *
 */
public class PanelOpciones extends JPanel {
	/**
	 * Etiqueta que muestra un mensaje introductorio al panel
	 */
    private JLabel enum1;
    /**
     * Etiqueta con el que muestra el mensaje: "Puntaje jugador 1"
     */
    private JLabel enum2;
    /**
     *Etiqueta con el que muestra el mensaje: "Puntaje jugador 2"
     */
    private JLabel enum3;
    /**
     *Etiqueta con el que muestra el mensaje: "Cantidad de dígitos"
     */
    private JLabel enum4;
    /**
     *Etiqueta con el que muestra el mensaje: "Repetición dígitos"
     */
    private JLabel enum5;
    /**
     *Etiqueta con el que muestra el mensaje: "Cantidad de intentos"
     */
    private JLabel enum6;
    /**
     *Etiqueta con el que muestra el mensaje: "Modo de juego"
     */
    private JLabel enum7;
    /**
     * Campo que muestra el puntaje del jugador 1
     */
    private JTextField puntajeJ1;
    /**
     * Campo que muestra el puntaje del jugador 2
     */
    private JTextField puntajeJ2;
    /**
     * Botón que permite iniciar el juego
     */
    private JButton botonEmpezarRobo;
    /**
     * Botón que permite dar una introducción al juego
     */
    private JButton botonEntrenamiento;
    /**
     * Botón que permite quitar la música
     */
    private JButton quitarMusica;
    /**
     * Imagen que está sobre el botón quitar música
     */
    private ImageIcon qmusica;
    /**
     * Botón que permite poner la música
     */
    private JButton ponerMusica;
    /**
     * Imagen que está sobre el botón poner música
     */
    private ImageIcon pmusica;
    /**
     * Caja de selección de opción cantidad de dígitos
     */
    JComboBox<Integer> cantidadDigitos;
    /**
     * Caja de selección de opción repetir dígitos
     */
    JComboBox<String> repetirDigitos;
    /**
     * Caja de selección de opción cantidad de intentos
     */
    JComboBox<Integer> cantidadIntentos;
    /**
     * Caja de selección de opción modo de juego
     */
    JComboBox<String> modoDeJuego;
    /**
     * Fuente usada en las etiquetas
     */
    private Font fuente1;
    /**
     * Fuente usada en cajas de selección y botones
     */
    private Font fuente2;
    /**
     * Borde que aparece alrededor del panel
     */
    private TitledBorder borde;
    /**
     * 
     */
    public PanelOpciones() {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }
    /**
     * Método que permite iniciar cada atributo del panel para ser añadido a este, además de permitir estilizarlo
     */
    public void inicializarComponentes() {
        setBackground(Color.CYAN);

        fuente1 = new Font("Century Gothic", Font.BOLD, 11);
        fuente2 = new Font("Century Gothic", Font.BOLD, 13);

        borde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));
        setBorder(borde);

        enum1 = new JLabel("Selecciona tus opciones de juego");
        enum1.setFont(new Font("", Font.BOLD, 14));
        enum1.setFont(fuente2);
        enum1.setBounds(115, 40, 250, 20);
        add(enum1);

        enum2 = new JLabel("Puntos ladrÃ³n #1: ");
        enum2.setFont(new Font("", Font.BOLD, 14));
        enum2.setFont(fuente2);
        enum2.setBounds(5, 5, 250, 20);
        add(enum2);

        enum3 = new JLabel("Puntos ladrÃ³n #2: ");
        enum3.setFont(new Font("", Font.BOLD, 14));
        enum3.setFont(fuente2);
        enum3.setBounds(255, 5, 250, 20);
        add(enum3);

        enum4 = new JLabel("Cantidad de dÃ­gitos: ");
        enum4.setFont(fuente2);
        enum4.setBounds(82, 80, 200, 20);
        add(enum4);

        enum5 = new JLabel("RepeticiÃ³n de dÃ­gitos: ");
        enum5.setFont(fuente2);
        enum5.setBounds(82, 110, 200, 20);
        add(enum5);

        enum6 = new JLabel("Cantidad de intentos: ");
        enum6.setFont(fuente2);
        enum6.setBounds(82, 140, 200, 20);
        add(enum6);

        enum7 = new JLabel("Modo de juego: ");
        enum7.setFont(fuente2);
        enum7.setBounds(82, 170, 200, 20);
        add(enum7);

        puntajeJ1 = new JTextField("10");
        puntajeJ1.setEditable(false);
        puntajeJ1.setFont(fuente1);
        puntajeJ1.setBounds(140, 5, 70, 20);
        add(puntajeJ1);

        puntajeJ2 = new JTextField("10");
        puntajeJ2.setEditable(false);
        puntajeJ2.setFont(fuente1);
        puntajeJ2.setBounds(390, 5, 70, 20);
        add(puntajeJ2);

        cantidadDigitos = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        cantidadDigitos.setFont(fuente1);
        cantidadDigitos.setBounds(243, 80, 140, 20);
        cantidadDigitos.setActionCommand("REINICIAR_CANTIDAD_INTENTOS");
        add(cantidadDigitos);

        cantidadIntentos = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        cantidadIntentos.setFont(fuente1);
        cantidadIntentos.setBounds(243, 140, 140, 20);
        add(cantidadIntentos);

        repetirDigitos = new JComboBox<>(new String[]{"No", "Si"});
        repetirDigitos.setFont(fuente1);
        repetirDigitos.setBounds(243, 110, 140, 20);
        add(repetirDigitos);

        modoDeJuego = new JComboBox<>(new String[]{"Jugador vs Jugador", "Jugador vs Maquina"});
        modoDeJuego.setFont(fuente1);
        modoDeJuego.setBounds(243, 170, 140, 20);
        add(modoDeJuego);

        botonEmpezarRobo = new JButton("<html><center>Empezar<br>el robo</html>");
        botonEmpezarRobo.setFont(fuente1);
        botonEmpezarRobo.setBounds(82, 210, 120, 32);
        botonEmpezarRobo.setActionCommand("EMPEZAR_EL_ROBO");
        add(botonEmpezarRobo);

        botonEntrenamiento = new JButton("<html><center>Planear Robo<br>(Modo entrenamiento)</html>");
        botonEntrenamiento.setFont(fuente1);
        botonEntrenamiento.setBounds(223, 210, 160, 32);
        botonEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
        botonEntrenamiento.setActionCommand("PLANEAR_ROBO");
        add(botonEntrenamiento);

        quitarMusica = new JButton();
        quitarMusica.setBounds(410, 215, 30, 30);
        quitarMusica.setToolTipText("Â¡Haz clic para desactivar la mÃºsica!");
        quitarMusica.setOpaque(false);
        quitarMusica.setContentAreaFilled(false);
        quitarMusica.setBorderPainted(false);
        qmusica = new ImageIcon("src/Images/QuitarMu.png");
        quitarMusica.setIcon(new ImageIcon(qmusica.getImage().getScaledInstance(quitarMusica.getWidth(), quitarMusica.getHeight(), Image.SCALE_SMOOTH)));
        quitarMusica.setActionCommand("QUITARSON");
        add(quitarMusica);

        ponerMusica = new JButton();
        ponerMusica.setBounds(410, 215, 30, 30);
        ponerMusica.setToolTipText("Â¡Haz clic para activar la mÃºsica!");
        ponerMusica.setOpaque(false);
        ponerMusica.setContentAreaFilled(false);
        ponerMusica.setBorderPainted(false);
        ponerMusica.setVisible(false);
        pmusica = new ImageIcon("src/Images/PonerMu.png");
        ponerMusica.setIcon(new ImageIcon(pmusica.getImage().getScaledInstance(ponerMusica.getWidth(), ponerMusica.getHeight(), Image.SCALE_SMOOTH)));
        ponerMusica.setActionCommand("PONERSON");
        add(ponerMusica);
    }

    /**
     * Método que permite obtener la etiqueta enum1
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
	 * Método que permite obtener la etiqueta enum2
	 * @return enum2
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
	 * Método que permite obtener la etiqueta enum3
	 * @return enum3
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
	 * Método que permite obtener la etiqueta enum4
	 * @return enum4
	 */
	public JLabel getEnum4() {
		return enum4;
	}
	
	/**
	 *Método que permite realizar cambios en la etiqueta enum4
	 * @param enum4, simple setter
	 */
	public void setEnum4(JLabel enum4) {
		this.enum4 = enum4;
	}
	
	/**
	 * Método que permite obtener la etiqueta enum5
	 * @return enum5
	 */
	public JLabel getEnum5() {
		return enum5;
	}
	
	/**
	 *Método que permite realizar cambios en la etiqueta enum5
	 * @param enum5, simple setter
	 */
	public void setEnum5(JLabel enum5) {
		this.enum5 = enum5;
	}
	
	/**
	 * Método que permite obtener la etiqueta enum6
	 * @return enum6
	 */
	public JLabel getEnum6() {
		return enum6;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta enum6
	 * @param enum6, simple setter
	 */
	public void setEnum6(JLabel enum6) {
		this.enum6 = enum6;
	}
	
	/**
	 * Método que permite obtener la etiqueta enum7
	 * @return enum7
	 */
	public JLabel getEnum7() {
		return enum7;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta enum7
	 * @param enum7, simple setter
	 */
	public void setEnum7(JLabel enum7) {
		this.enum7 = enum7;
	}
	
	/**
	 * Método que permite obtener la imagen qmusica
	 * @return qmusica
	 */
	public ImageIcon getQmusica() {
		return qmusica;
	}
	
	/**
	 *Método que permite realizar cambios en la imagen qmusica
	 * @param qmusica, simple setter
	 */
	public void setQmusica(ImageIcon qmusica) {
		this.qmusica = qmusica;
	}
	
	/**
	 * Método que permite obtener la imagen pmusica
	 * @return pmusica
	 */
	public ImageIcon getPmusica() {
		return pmusica;
	}
	
	/**
	 * Método que permite realizar cambios en la imagen pmusica
	 * @param pmusica, simple setter
	 */
	public void setPmusica(ImageIcon pmusica) {
		this.pmusica = pmusica;
	}
	
	/**
	 * Método que permite obtener fuente de letra fuente1
	 * @return fuente1
	 */
	public Font getFuente1() {
		return fuente1;
	}
	
	/**
	 *Método que permite realizar cambios en la fuente de letra fuente1
	 * @param fuente1, simple setter
	 */
	public void setFuente1(Font fuente1) {
		this.fuente1 = fuente1;
	}
	
	/**
	 * Método que permite obtener fuente de letra fuente2
	 * @return fuente2
	 */
	public Font getFuente2() {
		return fuente2;
	}
	
	/**
	 *Método que permite realizar cambios en la fuente de letra fuente2
	 * @param fuente2, simple setter
	 */
	public void setFuente2(Font fuente2) {
		this.fuente2 = fuente2;
	}
	
	/**
	 * Método que permite realizar cambios en el borde del panel
	 * @return borde
	 */
	public TitledBorder getBorde() {
		return borde;
	}
	
	/**
	 * Método que permite realizar cambios en el borde del panel
	 * @param borde, simple setter
	 */
	public void setBorde(TitledBorder borde) {
		this.borde = borde;
	}
	
	/**
	 * Método que permite realizar cambios en el campo texto puntajeJ1
	 * @param puntajeJ1, simple setter
	 */
	public void setPuntajeJ1(JTextField puntajeJ1) {
		this.puntajeJ1 = puntajeJ1;
	}
	
	/**
	 * Método que permite realizar cambios en el campo texto puntajeJ2
	 * @param puntajeJ2, simple setters
	 */
	public void setPuntajeJ2(JTextField puntajeJ2) {
		this.puntajeJ2 = puntajeJ2;
	}
	
	/**
	 * Método que permite realizar cambios en el botón botonEmpezarRobo
	 * @param botonEmpezarRobo, simple setter
	 */
	public void setBotonEmpezarRobo(JButton botonEmpezarRobo) {
		this.botonEmpezarRobo = botonEmpezarRobo;
	}
	
	/**
	 * Método que permite realizar cambios en el botón botonEntrenamiento
	 * @param botonEntrenamiento, simple setter
	 */
	public void setBotonEntrenamiento(JButton botonEntrenamiento) {
		this.botonEntrenamiento = botonEntrenamiento;
	}
	
	/**
	 * Método que permite realizar cambios en el botón quitarMusica
	 * @param quitarMusica, simple setter
	 */
	public void setQuitarMusica(JButton quitarMusica) {
		this.quitarMusica = quitarMusica;
	}
	
	/**
	 * Método que permite realizar cambios en la botón ponerMusica
	 * @param ponerMusica, simple setter
	 */
	public void setPonerMusica(JButton ponerMusica) {
		this.ponerMusica = ponerMusica;
	}
	
	/**
	 * Método que permite realizar cambios en la caja de selección cantidadDigitos 
	 * @param cantidadDigitos, simple setter
	 */
	public void setCantidadDigitos(JComboBox<Integer> cantidadDigitos) {
		this.cantidadDigitos = cantidadDigitos;
	}
	
	/**
	 * Método que permite realizar cambios en la caja de selección repetirDigitos
	 * @param repetirDigitos, simple setter
	 */
	public void setRepetirDigitos(JComboBox<String> repetirDigitos) {
		this.repetirDigitos = repetirDigitos;
	}
	
	/**
	 * Método que permite realizar cambios en la caja de selección cantidadIntentos
	 * @param cantidadIntentos, simple setter
	 */
	public void setCantidadIntentos(JComboBox<Integer> cantidadIntentos) {
		this.cantidadIntentos = cantidadIntentos;
	}
	
	/**
	 * Método que permite realizar cambios en la caja de selección modoDeJuego
	 * @param modoDeJuego, simple setter
	 */
	public void setModoDeJuego(JComboBox<String> modoDeJuego) {
		this.modoDeJuego = modoDeJuego;
	}
	
	/**
	 * Método que permite obtener el botón ponerMusica
	 * @return ponerMusica
	 */
	public JButton getPonerMusica() {
        return ponerMusica;
    }

	/**
	 * Método que permite obtener el botón quitarMusica
	 * @return quitarMusica
	 */
    public JButton getQuitarMusica() {
        return quitarMusica;
    }

    /**
     * Método que permite obtener  el botón botonEmpezarRobo
     * @return botonEmpezarRobo
     */
    public JButton getBotonEmpezarRobo() {
        return botonEmpezarRobo;
    }

    /**
     * Método que permite obtener el botón botonEntrenamiento
     * @return botonEntrenamiento
     */
    public JButton getBotonEntrenamiento() {
        return botonEntrenamiento;
    }

    /**
     * Método que permite obtener la caja de selección cantidadDigitos
     * @return cantidadDigitos
     */
    public JComboBox<Integer> getCantidadDigitos() {
        return cantidadDigitos;
    }

    /**
     * Método que permite obtener la caja de selección repetirDigitos
     * @return repetirDigitos
     */
    public JComboBox<String> getRepetirDigitos() {
        return repetirDigitos;
    }

    /**
     * Método que permite obtener la caja de selección cantidadIntentos
     * @return cantidadIntentos
     */
    public JComboBox<Integer> getCantidadIntentos() {
        return cantidadIntentos;
    }

    /**
     * Método que permite obtener la caja de selección modoDeJuego
     * @return modoDeJuego
     */
    public JComboBox<String> getModoDeJuego() {
        return modoDeJuego;
    }

    /**
     * Método que permite obtener campo de texto puntajeJ1
     * @return puntajeJ1
     */
    public JTextField getPuntajeJ1() {
        return puntajeJ1;
    }

    /**
     * Método que permite obtener campo de texto puntajeJ1
     * @return puntajeJ2
     */
    public JTextField getPuntajeJ2() {
        return puntajeJ2;
    }
}
