package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

//COMENTARIO
public class PanelOpciones extends JPanel {
    private JLabel enum1;
    private JLabel enum2;
    private JLabel enum3;
    private JLabel enum4;
    private JLabel enum5;
    private JButton botonEmpezarRobo;
    private JButton botonEntrenamiento;
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
    	
    	setBackground(Color.cyan);
    	
        Font fuente = new Font("", -1, 14);
        Font font = new Font("Century Gothic", Font.BOLD, 11);
        Font font1 = new Font("Century Gothic", Font.BOLD, 13);

        TitledBorder borde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));

        setBorder(borde);

        enum1 = new JLabel("Seleccione sus opciones de juego");
        enum1.setFont(new Font("", Font.BOLD, 14));
        enum1.setFont(font1);
        enum1.setBounds(105, 10, 250, 20);
        add(enum1);

        enum2 = new JLabel("Cantidad de digitos: ");
        enum2.setFont(font1);
        enum2.setBounds(82, 50, 200, 20);
        add(enum2);

        enum3 = new JLabel("Repeticion de digitos: ");
        enum3.setFont(font1);
        enum3.setBounds(82, 80, 200, 20);
        add(enum3);

        enum4 = new JLabel("Cantidad de intentos: ");
        enum4.setFont(font1);
        enum4.setBounds(82, 110, 200, 20);
        add(enum4);

        enum5 = new JLabel("Modo de juego: ");
        enum5.setFont(font1);
        enum5.setBounds(82, 140, 200, 20);
        add(enum5);

        cantidadDigitos = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        cantidadDigitos.setFont(font);
        cantidadDigitos.setBounds(243, 50, 140, 20);
        cantidadDigitos.setActionCommand("REINICIAR_CANTIDAD_INTENTOS");
        add(cantidadDigitos);

        cantidadIntentos = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        cantidadIntentos.setFont(font);
        cantidadIntentos.setBounds(243, 110, 140, 20);
        add(cantidadIntentos);

        repetirDigitos = new JComboBox<>(new String[]{"Si", "No"});
        repetirDigitos.setFont(font);
        repetirDigitos.setBounds(243, 80, 140, 20);
        add(repetirDigitos);

        modoDeJuego = new JComboBox<>(new String[]{"Jugador vs Jugador", "Jugador vs Maquina"});
        modoDeJuego.setFont(font);
        modoDeJuego.setBounds(243, 140, 140, 20);
        add(modoDeJuego);

        botonEmpezarRobo = new JButton("<html><center>Empezar<br>el robo</html>");
        botonEmpezarRobo.setFont(font);
        botonEmpezarRobo.setBounds(82, 180, 120, 32);
        botonEmpezarRobo.setActionCommand("EMPEZAR_EL_ROBO");
        add(botonEmpezarRobo);

        botonEntrenamiento = new JButton("<html><center>Planear Robo<br>(Modo entrenamiento)</html>");
        botonEntrenamiento.setFont(font);
        botonEntrenamiento.setBounds(223, 180, 160, 32);
        botonEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
        botonEntrenamiento.setActionCommand("PLANEAR_ROBO");
        add(botonEntrenamiento);
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
