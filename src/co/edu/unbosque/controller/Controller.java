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

    public Controller() {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.getPanelBienvenida().setVisible(true);
        asignarOyentes();
    }

    public void borrar() {
        //prueba para commit, este mÃ©todo se pude borrar
    }

    public void asignarOyentes() {
        ventanaPrincipal.getPanelBienvenida().getBotonAceptar().addActionListener(this);

        ventanaPrincipal.getPanelOpcionesJuego().getBotonEmpezarRobo().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getBotonEntrenamiento().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().addActionListener(this);

        ventanaPrincipal.getPanelJuego().getBotonIngresarJ1().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonPistaJ1().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonPistaJ2().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonVolver().addActionListener(this);
        
        ventanaPrincipal.getPanelEntrena().getBvolver().addActionListener(this);
    }
    

    String auxString = "";
    String aleatorioGenerado = "";
    int contadorIntentosJ1 = 0;
    int contadorIntentosJ2 = 0;
    String textoIngresado = "";

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        seleccionCantidadDigitos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().getSelectedItem());

        ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().removeAllItems();
        for (int i = 1; i <= (seleccionCantidadDigitos * 5); i++) {
            ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().addItem(i);
        }
        seleccionCantidadIntentos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().getSelectedItem());

        try {
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

                    numero = new Numero(seleccionCantidadDigitos);
                    aleatorioGenerado = String.valueOf(numero.generarNumeroAleatorio(seleccionCantidadDigitos));
                    System.out.println("Numero aleatorio de " + seleccionCantidadDigitos + " generado: " + aleatorioGenerado);
                    System.out.println("EMPEZAR_ROBO  = Cantidad de intentos seleccionada:" + seleccionCantidadIntentos);

                    switch (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem())) {
                        case "Jugador vs Jugador":
                            ventanaPrincipal.getPanelJuego().getBorde().setTitle("Jugador vs jugador");
                            break;
                        case "Jugador vs Maquina":
                            ventanaPrincipal.getPanelJuego().getBorde().setTitle("Jugador vs maquina");
                            ventanaPrincipal.getPanelJuego().getCampoJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getEnumJ2().setText("<html>MAQUINA</html>");
                            break;
                    }
                    break;
                case "PLANEAR_ROBO":
                	ventanaPrincipal.getPanelEntrena().getBorde().setTitle("Jugador vs maquina");
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(false);
                    ventanaPrincipal.setSize(900, 550);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    ventanaPrincipal.getPanelEntrena().setVisible(true);
                    break;
                case "INGRESAR_J1":
                        textoIngresado = ventanaPrincipal.getPanelJuego().getCampoJ1().getText();

                        if (!textoIngresado.equals("")) {
                            if (seleccionCantidadIntentos > 0) {
                                contadorIntentosJ1++;
                                seleccionCantidadIntentos--;
                                ventanaPrincipal.getPanelJuego().getMod1().addRow(new Integer[]{contadorIntentosJ1, Integer.valueOf(textoIngresado), numero.contarPicas(textoIngresado, aleatorioGenerado), numero.contarFijas(textoIngresado, aleatorioGenerado)});
                                ventanaPrincipal.getPanelJuego().getCampoJ1().setText("");
                                ventanaPrincipal.getPanelJuego().getCampoJ1().setEnabled(false);
                                ventanaPrincipal.getPanelJuego().getCampoJ2().setEnabled(true);
                                System.out.println("Cantidad de intentos = " + seleccionCantidadIntentos);
                            } else {
                                ventanaPrincipal.getMensajes().mostrarInfo("No hay mas intentos.");
                            }
                        }

                        if (textoIngresado.equals(aleatorioGenerado)) {
                            ventanaPrincipal.getMensajes().mostrarInfo("jugador 1 gana");
                        }
                    break;
                case "INGRESAR_J2":
                    textoIngresado = ventanaPrincipal.getPanelJuego().getCampoJ2().getText();

                    if (!textoIngresado.equals("")) {
                        contadorIntentosJ2++;
                        ventanaPrincipal.getPanelJuego().getMod2().addRow(new Integer[]{contadorIntentosJ2, Integer.valueOf(textoIngresado), numero.contarPicas(textoIngresado, aleatorioGenerado), numero.contarFijas(textoIngresado, aleatorioGenerado)});
                        ventanaPrincipal.getPanelJuego().getCampoJ2().setText("");
                        ventanaPrincipal.getPanelJuego().getCampoJ2().setEnabled(false);
                        ventanaPrincipal.getPanelJuego().getCampoJ1().setEnabled(true);
                    }

                    if (textoIngresado.equals(aleatorioGenerado)) {
                        ventanaPrincipal.getMensajes().mostrarInfo("jugador 2 gana");
                    }
                    break;
                case "VOLVER":
                    ventanaPrincipal.getPanelJuego().setVisible(false);
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                    ventanaPrincipal.setSize(500, 280);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    break;
                case "VOLVER_ENT":
                    ventanaPrincipal.getPanelEntrena().setVisible(false);
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                    ventanaPrincipal.setSize(500, 280);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException exception) {
            ventanaPrincipal.getMensajes().mostrarInfo("El valor ingresado debe ser un nÃºmero entero de mÃ¡ximo " + seleccionCantidadDigitos + " dÃ­gitos.");
        }

        auxString = (String) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem());
        if (auxString.equals("Si")) {
            seleccionRepeticionDigitos = true;
        } else if (auxString.equals("No")) {
            seleccionRepeticionDigitos = false;
        }
    }
}
