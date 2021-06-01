package co.edu.unbosque.controller;

import co.edu.unbosque.model.Numero;
import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
///PRUEBA DE GIT
public class Controller implements ActionListener {
// AAAAA
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

        ventanaPrincipal.getPanelJuego().getBotonIngresarJ1().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonPistaJ1().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonPistaJ2().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonVolver().addActionListener(this);
    }

    String auxString = "";

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        switch (comando) {
            case "VAMOS_A_ROBAR":
                ventanaPrincipal.getPanelBienvenida().setVisible(false);
                ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                break;
            case "EMPEZAR_EL_ROBO":
                ventanaPrincipal.getPanelOpcionesJuego().setVisible(false);
                ventanaPrincipal.setSize(900, 550);
                ventanaPrincipal.setLocationRelativeTo(null);
                ventanaPrincipal.getPanelJuego().setVisible(true);

                auxString = (String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem();
                switch (Objects.requireNonNull(auxString)) {
                    case "Jugador vs Jugador":
                        ventanaPrincipal.getPanelJuego().getBorde().setTitle("Jugador vs jugador");
                        break;
                    case "Jugador vs Maquina":
                        ventanaPrincipal.getPanelJuego().getBorde().setTitle("Jugador vs mÃ¡quina");
                        ventanaPrincipal.getPanelJuego().getCampoJ2().setVisible(false);
                        ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setVisible(false);
                        ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setVisible(false);
                        ventanaPrincipal.getPanelJuego().getEnumJ2().setText("<html>MÃ�QUINA</html>");
                        break;
                }
                break;
            case "VOLVER":
                ventanaPrincipal.getPanelJuego().setVisible(false);
                ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                ventanaPrincipal.setSize(500, 280);
                ventanaPrincipal.setLocationRelativeTo(null);
                break;
            case "INGRESAR_J1":
                try {
                    //numero.generarNumeroAleatorio(seleccionCantidadDigitos);
                    //int numeroAleatorioGenerado = numero.generarNumeroAleatorio(4);
                    int test = 5767;
                    System.out.println(test);
                    String textoIngresado = ventanaPrincipal.getPanelJuego().getCampoJ1().getText();

                    int contadorPicas = 0;
                    int contadorFijas = 0;
                    for (int i = 0; i < textoIngresado.length(); i++) {
                        if (textoIngresado.charAt(i) == Integer.toString(test).charAt(i)) {
                            contadorFijas++;
                        }
                    }
                    ventanaPrincipal.getPanelJuego().getMod1().addRow(new Integer[]{Integer.valueOf(textoIngresado), 0, contadorFijas});

                } catch (NumberFormatException exception) {
                    ventanaPrincipal.getMensajes().mostrarInfo("Error");
                }
        }

        seleccionCantidadDigitos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().getSelectedItem());

        ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().removeAllItems();
        for (int i = 1; i <= seleccionCantidadDigitos * 5; i++) {
            ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().addItem(i);
        }
        seleccionCantidadIntentos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().getSelectedItem());

        auxString = (String) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem());
        if (auxString.equals("Si")) {
            seleccionRepeticionDigitos = true;
        } else if (auxString.equals("No")) {
            seleccionRepeticionDigitos = false;
        }
    }
}
