package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private PanelBienvenida panelBienvenida;
    private PanelOpciones panelOpcionesJuego;
    private PanelJuego panelJuego;
    private Mensajes mensajes;

    public VentanaPrincipal() {
        setTitle("Robo al banco");
        setSize(500,280);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        inicializarComponentes();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void inicializarComponentes() {
        panelBienvenida = new PanelBienvenida();
        panelBienvenida.setBounds(15,15,465,220);
        getContentPane().add(panelBienvenida);

        panelOpcionesJuego = new PanelOpciones();
        panelOpcionesJuego.setBounds(15,15,465,220);
        getContentPane().add(panelOpcionesJuego);

        panelJuego = new PanelJuego();
        panelJuego.setBounds(15,15,465,220);
        getContentPane().add(panelJuego);


        mensajes = new Mensajes();
    }

    public PanelOpciones getPanelOpcionesJuego() {
        return panelOpcionesJuego;
    }

    public PanelJuego getPanelJuego() {
        return panelJuego;
    }

    public Mensajes getMensajes() {
        return mensajes;
    }

    public PanelBienvenida getPanelBienvenida() {
        return panelBienvenida;
    }
}
