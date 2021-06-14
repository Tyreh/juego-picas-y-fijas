package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private PanelBienvenida panelBienvenida;
    private PanelOpciones panelOpcionesJuego;
    private PanelEntrenamiento panelEntrena;
    private PanelJuego panelJuego;
    private Mensajes mensajes;
    private FondoPrincipal fondo;
    private VentanaEntrenamiento2 ventrena2;


    public VentanaPrincipal() {
        fondo = new FondoPrincipal();
        setTitle("Robo al banco");
        setSize(500, 280);
        setContentPane(fondo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        inicializarComponentes();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void inicializarComponentes() {

        panelBienvenida = new PanelBienvenida();
        panelBienvenida.setBounds(15, 15, 465, 250);
        getContentPane().add(panelBienvenida);

        panelOpcionesJuego = new PanelOpciones();
        panelOpcionesJuego.setBounds(15, 15, 465, 250);
        getContentPane().add(panelOpcionesJuego);

        panelJuego = new PanelJuego();
        panelJuego.setBounds(15, 15, 850, 490);
        getContentPane().add(panelJuego);

        panelEntrena = new PanelEntrenamiento();
        panelEntrena.setBounds(15, 15, 850, 490);
        getContentPane().add(panelEntrena);

        ventrena2 = new VentanaEntrenamiento2();
        ventrena2.setBounds(15, 15, 465, 220);

        mensajes = new Mensajes();
    }

    public VentanaEntrenamiento2 getVentrena2() {
        return ventrena2;
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

    public PanelEntrenamiento getPanelEntrena() {
        return panelEntrena;
    }


}
