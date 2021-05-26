package co.edu.unbosque.controller;

import co.edu.unbosque.model.Numero;
import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Controller implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;
    private Numero numero;
    private int seleccionCantidadIntentos;
    private int seleccionCantidadDigitos;
    private boolean seleccionRepeticionDigitos;
    private int seleccionModoJuego;

    public Controller() {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.getPanelBienvenida().setVisible(true);
        asignarOyentes();
    }

    public void asignarOyentes() {
        ventanaPrincipal.getPanelBienvenida().getBotonAceptar().addActionListener(this);

        ventanaPrincipal.getPanelOpcionesJuego().getBotonEmpezarRobo().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().addActionListener(this);
    }

    String auxString = "";

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("VAMOS_A_ROBAR")) {
            ventanaPrincipal.getPanelBienvenida().setVisible(false);
            ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
        } else if (comando.equals("EMPEZAR_EL_ROBO")) {
            ventanaPrincipal.getPanelOpcionesJuego().setVisible(false);
            ventanaPrincipal.getPanelJuego().setVisible(true);
        }

        seleccionCantidadDigitos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().getSelectedItem());
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().removeAllItems();

        for (int i = 1; i <= seleccionCantidadDigitos; i++) {
            ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().addItem(i);
            ventanaPrincipal.repaint();
        }

        seleccionCantidadIntentos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().getSelectedItem());

        auxString = (String) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem());
        if (auxString.equals("Si")) {
            seleccionRepeticionDigitos = true;
        } else if (auxString.equals("No")) {
            seleccionRepeticionDigitos = false;
        }

        auxString = (String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem();
        switch (Objects.requireNonNull(auxString)) {
            case "Jugador vs Jugador":
                seleccionModoJuego = 0;
                break;
            case "Jugador vs Máquina":
                seleccionModoJuego = 1;
                break;
        }
    }
}
