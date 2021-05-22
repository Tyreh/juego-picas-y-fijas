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
        ventanaPrincipal.getMensajes().mostrarInfo("Fundamentos de programación - Juego de Picas y Fijas\n\nDesarrollado por:\n - Oscar Moreno\n - Nelson Fandiño\n - Tomas Espitia\n - Nicolas Camacho\n\nProfesor: Helio Ramirez");
        ventanaPrincipal.setVisible(true);
        asignarOyentes();
    }

    public void asignarOyentes() {
        ventanaPrincipal.getPanelOpcionesJuego().getBotonAceptar().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String auxString;
        seleccionCantidadDigitos = (int) ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().getSelectedItem();

        auxString = (String) ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem();
        assert auxString != null;
        if (auxString.equals("Si")) {
            seleccionRepeticionDigitos = true;
        } else if (auxString.equals("No")) {
            seleccionRepeticionDigitos = false;
        }

        auxString = (String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem();
        assert auxString != null;
        switch (auxString) {
            case "Entrenamiento":
                seleccionModoJuego = 0;
                break;
            case "Jugador vs Jugador":
                seleccionModoJuego = 1;
                break;
            case "Jugador vs Máquina":
                seleccionModoJuego = 2;
                break;
        }


/*        int auxInt;
        String auxString;

        seleccionCantidadDigitos = Integer.parseInt((String) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().getSelectedItem()));


        for (int i = 1; i <= 5; i++) {
            auxInt = Integer.parseInt((String) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().getSelectedItem()));
            if (i == auxInt) {
                seleccionCantidadIntentos = i;
            }
        }

        auxString = Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem()).toString();
        if (auxString.equals("Si")) {
            seleccionRepeticionDigitos = true;
        } else if (auxString.equals("No")) {
            seleccionRepeticionDigitos = false;
        }

        auxString = Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem()).toString();
        if (auxString.equals("Jugador vs Jugador")) {
            seleccionModoJuego = true;
        } else if (auxString.equals("Jugador vs Máquina")) {
            seleccionModoJuego = false;
        }

        if (e.getActionCommand().equals("CONFIRMAR_OPCIONES_DE_JUEGO")) {
            ventanaPrincipal.getPanelOpcionesJuego().setVisible(false);
            ventanaPrincipal.getPanelJuego().setVisible(true);
        }*/

        System.out.println("Cantidad de dígitos seleccionados: " + seleccionCantidadDigitos);
        System.out.println("Cantidad de intentos seleccionados: " + seleccionCantidadIntentos);
        System.out.println("Repetición de digitos: " + seleccionRepeticionDigitos);
        System.out.println("Modo de juego: " + seleccionModoJuego);
    }
}
