package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelOpciones extends JPanel {
    private JLabel enum1;
    private JLabel enum2;
    private JLabel enum3;
    private JLabel enum4;
    private JLabel enum5;
    private JLabel enum6;
    private JLabel enum7;
    private JTextField puntajeJ1;
    private JTextField puntajeJ2;
    private JButton botonEmpezarRobo;
    private JButton botonEntrenamiento;
    private JButton quitarMusica;
    private ImageIcon qmusica;
    private JButton ponerMusica;
    private ImageIcon pmusica;
    
    JComboBox<Integer> cantidadDigitos;
    JComboBox<String> repetirDigitos;
    JComboBox<Integer> cantidadIntentos;
    JComboBox<String> modoDeJuego;

    public PanelOpciones() {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
    	setBackground(Color.CYAN);
        Font fuente1 = new Font("Century Gothic", Font.BOLD, 11);
        Font fuente2 = new Font("Century Gothic", Font.BOLD, 13);

        TitledBorder borde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));
        setBorder(borde);

        enum1 = new JLabel("Seleccione sus opciones de juego");
        enum1.setFont(new Font("", Font.BOLD, 14));
        enum1.setFont(fuente2);
        enum1.setBounds(115, 40, 250, 20);
        add(enum1);

        enum2 = new JLabel("Puntaje ladrón #1: ");
        enum2.setFont(new Font("", Font.BOLD, 14));
        enum2.setFont(fuente2);
        enum2.setBounds(5, 5, 250, 20);
        add(enum2);

        enum3 = new JLabel("Puntaje ladrón #2: ");
        enum3.setFont(new Font("", Font.BOLD, 14));
        enum3.setFont(fuente2);
        enum3.setBounds(255, 5, 250, 20);
        add(enum3);

        enum4 = new JLabel("Cantidad de digitos: ");
        enum4.setFont(fuente2);
        enum4.setBounds(82, 80, 200, 20);
        add(enum4);

        enum5 = new JLabel("Repeticion de digitos: ");
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

        repetirDigitos = new JComboBox<>(new String[]{"Si", "No"});
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
        quitarMusica.setOpaque(false);
        quitarMusica.setContentAreaFilled(false);
        quitarMusica.setBorderPainted(false);
        qmusica = new ImageIcon("src/Images/QuitarMu.png");
        quitarMusica.setIcon(new ImageIcon(qmusica.getImage().getScaledInstance(quitarMusica.getWidth(), quitarMusica.getHeight(), Image.SCALE_SMOOTH)));
        quitarMusica.setActionCommand("QUITARSON");
        add(quitarMusica);
        
        ponerMusica = new JButton();
        ponerMusica.setBounds(410, 215, 30, 30);
        ponerMusica.setOpaque(false);
        ponerMusica.setContentAreaFilled(false);
        ponerMusica.setBorderPainted(false);
        ponerMusica.setVisible(false);
        pmusica = new ImageIcon("src/Images/PonerMu.png");
        ponerMusica.setIcon(new ImageIcon(pmusica.getImage().getScaledInstance(ponerMusica.getWidth(), ponerMusica.getHeight(), Image.SCALE_SMOOTH)));
        ponerMusica.setActionCommand("PONERSON");
        add(ponerMusica);
    }
    
    

    public JButton getPonerMusica() {
		return ponerMusica;
	}

	public JButton getQuitarMusica() {
		return quitarMusica;
	}

	public JButton getBotonEmpezarRobo() {
        return botonEmpezarRobo;
    }

    public JButton getBotonEntrenamiento() {
        return botonEntrenamiento;
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
