package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
/**
 * Clase que permite crear un panel, este caso el panel de juego
 *@author Oscar Moreno
 *@author Nicolas Camacho
 *@author Tomas Espitia
 *@author Nelson Fandiño
 *
 */
public class PanelJuego extends JPanel {
	/**
	 * Etiqueta donde aparece la posicion del jugador 1 y el texto introductorio al campo de texto al mismo
	 */
    private JLabel enumJ1;
    /**
	 * Etiqueta donde aparece la posicion del jugador 2 o la máquina y el texto introductorio al campo de texto al mismo, en caso de ser jugador vs jugador
	 */
    private JLabel enumJ2;
    /**
     * Campo de texto donde el jugador 1 ingresa sus números
     */
    private JTextField campoJ1;
    /**
     * Campo de texto donde el jugador 2 ingresa sus números
     */
    private JTextField campoJ2;
    /**
     * Botón que permite el ingreso del número del jugador 1
     */
    private JButton botonIngresarJ1;
    /**
     * Botón que permite el ingreso del número del jugador 2
     */
    private JButton botonIngresarJ2;
    /**
     * Botón que  permite acceder a las ayudas del jugador 1
     */
    private JButton botonPistaJ1;
    /**
     * Botón que  permite acceder a las ayudas del jugador 2
     */
    private JButton botonPistaJ2;
    /**
     * Botón que permite volver al panel de opciones
     */
    private JButton botonVolver;
    /**
     * Botón que permite mostrar las opciones elegidas previamente
     */
    private JButton botonInformacion;
    /**
	 * Nombres de cabecera de los espacios de la tabla del jugador 1
	 */
    private DefaultTableModel mod1;
    /**
     * Tabla jugador 1
     */
    private JTable tabla1;
    /**
	 * Permite que la tabla del jugador 1 tenga un scroll, si se necesita
	 */
    private JScrollPane scroll1;
    /**
   	 * Nombres de cabecera de los espacios de la tabla del jugador 2
   	 */
    private DefaultTableModel mod2;
    /**
     * Tabla jugador 2
     */
    private JTable tabla2;
    /**
	 * Permite que la tabla del jugador 2 tenga un scroll, si se necesita
	 */
    private JScrollPane scroll2;
    /**
	 * Genera un borde alrededor del panel
	 */
    private TitledBorder borde;
    /**
	 * Imagen que aparece sobre los botones que permiten el ingreso de los números
	 */
    private ImageIcon teclado;
    /**
	 * Imagen que aparece sobre los botones que permiten acceder a las pistas
	 */
    private ImageIcon pista;
    /**
     * Etiqueta que permite almacenar un gif
     */
    private JLabel gif;
    /**
     * Gif que aparece en la etiqueta (Modo jugador vs Máquina)
     */
    private ImageIcon gif1;
    /**
	 * Tipo de fuente usada en las tablas
	 */
    private Font font;
    /**
	 * Tipo de fuente usada en las etiquetas
	 */
    private Font font1; 
    /**
	 * Constructor de la clase PanelJuego
	 */
    public PanelJuego() {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }
    /**
     * Método que permite iniciar cada atributo del panel para ser añadido a este, además de permitir estilizarlo
     */
    public void inicializarComponentes() {
        setBackground(Color.CYAN);

        borde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));
        setBorder(borde);

        font = new Font("Century Gothic", Font.BOLD, 12);
        font1 = new Font("Century Gothic", Font.BOLD, 14);
        borde.setTitleFont(font);
        setBorder(borde);

        botonInformacion = new JButton("<html> Información de juego</html>");
        botonInformacion.setBounds(345, 15, 160, 20);
        botonInformacion.setActionCommand("INFORMACION_JUEGO");
        add(botonInformacion);

        botonVolver = new JButton("Rendirse");
        botonVolver.setBounds(375, 460, 100, 20);
        add(botonVolver);
        botonVolver.setActionCommand("RENDICION");

        //Gif
        gif = new JLabel();
        gif.setBounds(550, 15, 142, 80);
        gif1 = new ImageIcon("src/Images/robot2.gif");
        gif.setIcon(gif1);
        gif1.setImageObserver(gif);
        add(gif);

        // INTERFAZ JUGADOR 1
        enumJ1 = new JLabel("<html>Ladrón #1<br/>Ingrese un número:</html>");
        enumJ1.setBounds(25, 35, 200, 40);
        enumJ1.setFont(font1);
        add(enumJ1);

        campoJ1 = new JTextField();
        campoJ1.setFont(font);
        campoJ1.setBounds(25, 75, 200, 20);
        add(campoJ1);

        botonIngresarJ1 = new JButton();
        botonIngresarJ1.setFont(font);
        botonIngresarJ1.setBounds(229, 45, 85, 50);
        botonIngresarJ1.setToolTipText("¡Haz clic para ingresar el código!");
        botonIngresarJ1.setOpaque(false);
        botonIngresarJ1.setContentAreaFilled(false);
        botonIngresarJ1.setBorderPainted(false);
        teclado = new ImageIcon("src/Images/Cand.png");
        botonIngresarJ1.setIcon(new ImageIcon(teclado.getImage().getScaledInstance(botonIngresarJ1.getWidth(), botonIngresarJ1.getHeight(), Image.SCALE_SMOOTH)));
        botonIngresarJ1.setActionCommand("INGRESAR_J1");
        add(botonIngresarJ1);

        botonPistaJ1 = new JButton();
        botonPistaJ1.setFont(font);
        botonPistaJ1.setBounds(319, 45, 85, 50);
        botonPistaJ1.setToolTipText("¡Haz clic para obtener una pista a cambio de 10 puntos!");
        botonPistaJ1.setOpaque(false);
        botonPistaJ1.setContentAreaFilled(false);
        botonPistaJ1.setBorderPainted(false);
        pista = new ImageIcon("src/Images/Pista.png");
        botonPistaJ1.setIcon(new ImageIcon(pista.getImage().getScaledInstance(botonPistaJ1.getWidth(), botonPistaJ1.getHeight(), Image.SCALE_SMOOTH)));
        botonPistaJ1.setActionCommand("PISTA_J1");
        add(botonPistaJ1);

        mod1 = new DefaultTableModel(new String[]{"# Intento", "Número", "Picas", "Fijas"}, 0);
        tabla1 = new JTable(mod1);
        tabla1.setEnabled(false);
        tabla1.setFont(font);
        tabla1.getTableHeader().setReorderingAllowed(false);
        tabla1.getTableHeader().setResizingAllowed(false);
        scroll1 = new JScrollPane(tabla1);
        scroll1.setFont(font);
        scroll1.setBounds(25, 100, 380, 350);
        add(scroll1);

        // INTERFAZ JUGADOR 2
        enumJ2 = new JLabel("<html>JUGADOR 2<br/>Ingrese un número:</html>");
        enumJ2.setFont(font1);
        enumJ2.setBounds(445, 35, 200, 40);
        add(enumJ2);

        campoJ2 = new JTextField();
        campoJ2.setFont(font);
        campoJ2.setBounds(445, 75, 200, 20);
        add(campoJ2);

        botonIngresarJ2 = new JButton();
        botonIngresarJ2.setFont(font);
        botonIngresarJ2.setBounds(649, 45, 85, 50);
        botonIngresarJ2.setToolTipText("¡Haz clic para ingresar el código!");
        botonIngresarJ2.setOpaque(false);
        botonIngresarJ2.setContentAreaFilled(false);
        botonIngresarJ2.setBorderPainted(false);
        teclado = new ImageIcon("src/Images/Cand.png");
        botonIngresarJ2.setIcon(new ImageIcon(teclado.getImage().getScaledInstance(botonIngresarJ2.getWidth(), botonIngresarJ2.getHeight(), Image.SCALE_SMOOTH)));
        botonIngresarJ2.setActionCommand("INGRESAR_J2");
        add(botonIngresarJ2);

        botonPistaJ2 = new JButton();
        botonPistaJ2.setFont(font);
        botonPistaJ2.setBounds(739, 45, 85, 50);
        botonPistaJ2.setToolTipText("¡Haz clic para obtener una pista a cambio de 10 puntos!");
        botonPistaJ2.setOpaque(false);
        botonPistaJ2.setContentAreaFilled(false);
        botonPistaJ2.setBorderPainted(false);
        pista = new ImageIcon("src/Images/Pista.png");
        botonPistaJ2.setIcon(new ImageIcon(pista.getImage().getScaledInstance(botonPistaJ2.getWidth(), botonPistaJ2.getHeight(), Image.SCALE_SMOOTH)));
        botonPistaJ2.setActionCommand("PISTA_J2");
        add(botonPistaJ2);

        mod2 = new DefaultTableModel(new String[]{"# Intento", "Número", "Picas", "Fijas"}, 0);
        tabla2 = new JTable(mod2);
        tabla2.setEnabled(false);
        tabla2.setFont(font);
        tabla2.getTableHeader().setReorderingAllowed(false);
        tabla2.getTableHeader().setResizingAllowed(false);
        scroll2 = new JScrollPane(tabla2);
        scroll2.setFont(font);
        scroll2.setBounds(445, 100, 380, 350);
        add(scroll2);
    }
   
    /**
     * Método que permite llamar la tabla del jugador 1
     * @return tabla1
     */
    public JTable getTabla1() {
		return tabla1;
	}
    
    /**
     * Método que permite realizar cambios en la tabla del jugador 1
     * @param tabla1, simple setter
     */
	public void setTabla1(JTable tabla1) {
		this.tabla1 = tabla1;
	}
	
	/**
	 * Método que permite llamar el scroll pane del jugador 1
	 * @return scroll1
	 */
	public JScrollPane getScroll1() {
		return scroll1;
	}
	
	/**
	 * MMétodo que permite realizar cambios en el scroll pane del jugador 1
	 * @param scroll1, simple setter
	 */
	public void setScroll1(JScrollPane scroll1) {
		this.scroll1 = scroll1;
	}
	
	/**
	 * Método que permite cambiar la tabla del jugador 2
	 * @return tabla 2
	 */
	public JTable getTabla2() {
		return tabla2;
	}
	
	 /**
     * Método que permite realizar cambios en la tabla del jugador 2
     * @param tabla2, simple setter
     */
	public void setTabla2(JTable tabla2) {
		this.tabla2 = tabla2;
	}
	
	/**
	 * Método que permite llamar el scroll pane del jugador 2
	 * @return scroll2
	 */
	public JScrollPane getScroll2() {
		return scroll2;
	}
	
	/**
	 *Método que permite realizar cambios en el scroll pane del jugador 2
	 * @param scroll2, simple setter
	 */
	public void setScroll2(JScrollPane scroll2) {
		this.scroll2 = scroll2;
	}
	
	/**
	 * Método que permite llamar la imagen teclado
	 * @return teclado
	 */
	public ImageIcon getTeclado() {
		return teclado;
	}
	
	/**
	 *Método que permite realizar cambios en la imagen teclado
	 * @param teclado, simple setter
	 */
	public void setTeclado(ImageIcon teclado) {
		this.teclado = teclado;
	}
	
	/**
	 *  Método que permite llamar la imagen pista
	 * @return pista
	 */
	public ImageIcon getPista() {
		return pista;
	}
	
	/**
	 * Método que permite realizar cambios en la imagen pista
	 * @param pista, simple setter
	 */
	public void setPista(ImageIcon pista) {
		this.pista = pista;
	}
	
	/**
	 * Método que permite llamar el gif gif1
	 * @return gif1
	 */
	public ImageIcon getGif1() {
		return gif1;
	}
	
	/**
	 *Método que permite realizar cambios en el gif gif1
	 * @param gif1, simple setter
	 */
	public void setGif1(ImageIcon gif1) {
		this.gif1 = gif1;
	}
	
	/**
	 * Método que permite llamar la fuente font
	 * @return font1
	 */
	public Font getFont() {
		return font;
	}
	
	/**
	 * Método que permite realizar cambios en la fuente font
	 * @param font, simple setter
	 */
	public void setFont(Font font) {
		this.font = font;
	}
	
	/**
	 * Método que permite llamar la fuente font1
	 * @return font1
	 */
	public Font getFont1() {
		return font1;
	}
	
	/**
	 * Método que permite realizar cambios en la fuente font1
	 * @param font1, simple setter
	 */
	public void setFont1(Font font1) {
		this.font1 = font1;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta enumJ1
	 * @param enumJ1, simple setter
	 */
	public void setEnumJ1(JLabel enumJ1) {
		this.enumJ1 = enumJ1;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta enumJ2
	 * @param enumJ2, simple setter
	 */
	public void setEnumJ2(JLabel enumJ2) {
		this.enumJ2 = enumJ2;
	}
	
	/**
	 * Método que permite realizar cambios en el campo de texto campoJ1
	 * @param campoJ1, simple setter
	 */
	public void setCampoJ1(JTextField campoJ1) {
		this.campoJ1 = campoJ1;
	}
	
	/**
	 * Método que permite realizar cambios en el campo de texto campoJ2
	 * @param campoJ2, simple setter
	 */
	public void setCampoJ2(JTextField campoJ2) {
		this.campoJ2 = campoJ2;
	}
	
	/**
	 * Método que permite realizar cambios en el botón botonIngresarJ1
	 * @param botonIngresarJ1, simple setter
	 */
	public void setBotonIngresarJ1(JButton botonIngresarJ1) {
		this.botonIngresarJ1 = botonIngresarJ1;
	}
	
	/**
	 * Método que permite realizar cambios en el botón botonIngresarJ2
	 * @param botonIngresarJ2, simple setter
	 */
	public void setBotonIngresarJ2(JButton botonIngresarJ2) {
		this.botonIngresarJ2 = botonIngresarJ2;
	}
	
	/**
	 * Método que permite realizar cambios en el botón botonPistaJ1
	 * @param botonPistaJ1, simple setter
	 */
	public void setBotonPistaJ1(JButton botonPistaJ1) {
		this.botonPistaJ1 = botonPistaJ1;
	}
	
	/**
	 * Método que permite realizar cambios en el botón botonPistaJ2
	 * @param botonPistaJ2, simple setter
	 */
	public void setBotonPistaJ2(JButton botonPistaJ2) {
		this.botonPistaJ2 = botonPistaJ2;
	}
	
	/**
	 *Método que permite realizar cambios en el botón botonVolver
	 * @param botonVolver, simple setter
	 */
	public void setBotonVolver(JButton botonVolver) {
		this.botonVolver = botonVolver;
	}
	
	/**
	 * Método que permite realizar cambios en el botón botonInformacion
	 * @param botonInformacion, simple setter
	 */
	public void setBotonInformacion(JButton botonInformacion) {
		this.botonInformacion = botonInformacion;
	}
	
	/**
	 * Método que permite realizar cambios en la cabecera de la tabla del jugador 1
	 * @param mod1, simple setter
	 */
	public void setMod1(DefaultTableModel mod1) {
		this.mod1 = mod1;
	}
	
	/**
	 * Método que permite realizar cambios en la cabecera de la tabla del jugador 2
	 * @param mod2, simple setter
	 */
	public void setMod2(DefaultTableModel mod2) {
		this.mod2 = mod2;
	}
	
	/**
	 * Método que permite realizar cambios en el borde del panel
	 * @param borde, simple setter
	 */
	public void setBorde(TitledBorder borde) {
		this.borde = borde;
	}
	
	/**
	 * Método que permite realizar cambios en la etiqueta gif
	 * @param gif, simple setter
	 */
	public void setGif(JLabel gif) {
		this.gif = gif;
	}
	
	/**
     * Método que permite llamar la Etiqueta enumJ1
     * @return retorna la etiqueta enumj1
     */
    public JLabel getEnumJ1() {
        return enumJ1;
    }

    /**
     * Método que permite llamar la Etiqueta gif
     * @return retorna la etiqueta gif
     */
    public JLabel getGif() {
        return gif;
    }

    /**
     * Método que permite llamar el botón BotonVolver
     * @return retorna el botón botonvolver
     */
    public JButton getBotonVolver() {
        return botonVolver;
    }

    /**
     * Método que permite llamar el botón botoningresarJ1
     * @return retorna el botón botoningresarJ1
     */
    public JButton getBotonIngresarJ1() {
        return botonIngresarJ1;
    }
    
    /**
     * Método que permite llamar el botón botoningresarJ2
     * @return retorna el botón botoningresarJ2
     */
    public JButton getBotonIngresarJ2() {
        return botonIngresarJ2;
    }

    /**
     * Método que permite llamar el botón botonPistaJ1
     * @return retorna el botón botonPistaJ1
     */
    public JButton getBotonPistaJ1() {
        return botonPistaJ1;
    }
    
    /**
     * Método que permite llamar el botón botonPistaJ2
     * @return retorna el botón botonPistaJ2
     */
    public JButton getBotonPistaJ2() {
        return botonPistaJ2;
    }

    /**
     * Método que permite llamar la cabecera de tabla mod1
     * @return retorna la cabecera de tabla mod1
     */
    public DefaultTableModel getMod1() {
        return mod1;
    }
    
    /**
     * Método que permite llamar la cabecera de tabla mod2
     * @return retorna la cabecera de tabla mod2
     */
    public DefaultTableModel getMod2() {
        return mod2;
    }
    
    /**
     * Método que permite llamar el campo de texto del jugador 1
     * @return retorna campoJ1
     */
    public JTextField getCampoJ1() {
        return campoJ1;
    }

    /**
     * Método que permite llamar el campo de texto del jugador 2
     * @return retorna campoJ2
     */
    public JTextField getCampoJ2() {
        return campoJ2;
    }
    
    /**
     * Método que permite llamar el borde del panel
     * @return retorna borde
     */
    public TitledBorder getBorde() {
        return borde;
    }
    
    /**
     * Método que permite llamar la Etiqueta enumJ2
     * @return retorna la etiqueta enumj2
     */
    public JLabel getEnumJ2() {
        return enumJ2;
    }
    
    /**
     * Método que permite llamar el botón botonInformacion
     * @return retorna el botón botoninformacion
     */
    public JButton getBotonInformacion() {
        return botonInformacion;
    }
}