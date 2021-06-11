package co.edu.unbosque.controller;

import co.edu.unbosque.model.Numero;
import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Controller implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;
    private Numero numero;
    private int seleccionCantidadDigitos;

    public Controller() {
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.getPanelBienvenida().setVisible(true);
        asignarOyentes();
    }

    public void asignarOyentes() {
        ventanaPrincipal.getPanelBienvenida().getBotonAceptar().addActionListener(this);

        ventanaPrincipal.getPanelOpcionesJuego().getBotonEmpezarRobo().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getBotonEntrenamiento().addActionListener(this);

        ventanaPrincipal.getPanelJuego().getBotonIngresarJ1().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonPistaJ1().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonPistaJ2().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonVolver().addActionListener(this);

        ventanaPrincipal.getPanelEntrena().getBvolver().addActionListener(this);
    }

    String aleatorioGenerado = "";
    String textoIngresado = "";
    int numeroAleatorioMaquina;
    int contadorIntentosJ1 = 1;
    int contadorIntentosJ2 = 1;
    int seleccionCantidadIntentos;
    int randomPrev = 0;

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        seleccionCantidadDigitos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().getSelectedItem());
        seleccionCantidadIntentos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().getSelectedItem());

        try {
            switch (comando) {
                case "VAMOS_A_ROBAR":
                    ventanaPrincipal.getPanelBienvenida().setVisible(false);
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                    
                    //Música
                    try {
                        
                        // Se obtiene un Clip de sonido
                        Clip sonido = AudioSystem.getClip();
                        
                        // Se carga con un fichero wav
                        sonido.open(AudioSystem.getAudioInputStream(new File("src/Music/CancionJuego.wav")));
                        
                        // Comienza la reproducción
                        sonido.start();
                        
                        sonido.loop(Clip.LOOP_CONTINUOUSLY); // reproduce el fichero de sonido una y otra vez sin parar.
                    } catch (Exception e1) {
                        System.out.println("" + e1);
                    }
                    
                    break;
                case "REINICIAR_CANTIDAD_INTENTOS":
                    ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().removeAllItems();
                    for (int i = 1; i <= (seleccionCantidadDigitos * 5); i++) {
                        ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().addItem(i);
                    }
                    break;
                case "EMPEZAR_EL_ROBO":
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(false);
                    ventanaPrincipal.setSize(900, 550);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    ventanaPrincipal.getPanelJuego().setVisible(true);
                    ventanaPrincipal.getPanelJuego().getCampoJ1().setEnabled(true);
                    ventanaPrincipal.getPanelJuego().getCampoJ2().setEnabled(false);
                    ventanaPrincipal.getPanelJuego().getCampoJ1().setText("");
                    ventanaPrincipal.getPanelJuego().getCampoJ2().setText("");
                    ventanaPrincipal.getPanelJuego().getMod1().setRowCount(0);
                    ventanaPrincipal.getPanelJuego().getMod2().setRowCount(0);
                    contadorIntentosJ1 = 1;
                    contadorIntentosJ2 = 1;

                    switch (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem())) {
                        case "Si":
                            numero = new Numero(seleccionCantidadDigitos);
                            aleatorioGenerado = String.valueOf(numero.generarNumeroAleatorio(seleccionCantidadDigitos));
                            break;
                        case "No":
                            numero = new Numero(seleccionCantidadDigitos);
                            aleatorioGenerado = numero.generarNumeroAleatorioSinRepeticion(seleccionCantidadDigitos);
                            break;
                    }

                    switch (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem())) {
                        case "Jugador vs Jugador":
                            ventanaPrincipal.getPanelJuego().getBorde().setTitle("Jugador vs  Jugador");

                            ventanaPrincipal.getPanelJuego().getGif().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getCampoJ2().setVisible(true);
                            ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setVisible(true);
                            ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setVisible(true);
                            ventanaPrincipal.getPanelJuego().getEnumJ2().setText("<html>JUGADOR 2<br/>Ingrese un nÃºmero:</html>");
                            break;
                        case "Jugador vs Maquina":
                            ventanaPrincipal.getPanelJuego().getBorde().setTitle("Jugador vs Maquina");
                            ventanaPrincipal.getPanelJuego().getCampoJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getEnumJ2().setText("<html>MAQUINA</html>");

                            ventanaPrincipal.getPanelJuego().getGif().setVisible(true);
                            break;
                    }

                    System.out.println("==========================================");
                    System.out.println("Opciones de juego: ");
                    System.out.println("    Numero aleatorio de " + seleccionCantidadDigitos + " generado: " + aleatorioGenerado);
                    System.out.println("    Cantidad de intentos: " + seleccionCantidadIntentos);
                    System.out.println("    Repeticion de digitos: " + Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem()));
                    System.out.println("    Modo de juego: " + Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem()));
                    System.out.println("==========================================");
                    break;
                case "PLANEAR_ROBO":
                    ventanaPrincipal.getPanelEntrena().getBorde().setTitle("Modo Entrenamiento");
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(false);
                    ventanaPrincipal.setSize(900, 550);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    ventanaPrincipal.getPanelEntrena().setVisible(true);
                    break;
                case "INGRESAR_J1":
                    textoIngresado = ventanaPrincipal.getPanelJuego().getCampoJ1().getText();
                    if (!textoIngresado.equals("")) {
                        if (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem()).equals("Jugador vs Jugador")) {
                            ventanaPrincipal.getPanelJuego().getMod1().addRow(new Integer[]{contadorIntentosJ1, Integer.valueOf(textoIngresado), numero.contarPicas(textoIngresado, aleatorioGenerado), numero.contarFijas(textoIngresado, aleatorioGenerado)});
                            ventanaPrincipal.getPanelJuego().getCampoJ1().setText("");
                            ventanaPrincipal.getPanelJuego().getCampoJ1().setEnabled(false);
                            ventanaPrincipal.getPanelJuego().getCampoJ2().setEnabled(true);
                            contadorIntentosJ1++;
                        } else if (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem()).equals("Jugador vs Maquina")) {
                            numeroAleatorioMaquina = numero.generarNumeroAleatorio(seleccionCantidadDigitos);
                            ventanaPrincipal.getPanelJuego().getMod1().addRow(new Integer[]{contadorIntentosJ1, Integer.valueOf(textoIngresado), numero.contarPicas(textoIngresado, aleatorioGenerado), numero.contarFijas(textoIngresado, aleatorioGenerado)});
                            ventanaPrincipal.getPanelJuego().getMod2().addRow(new Integer[]{contadorIntentosJ1, numeroAleatorioMaquina, numero.contarPicas(String.valueOf(numeroAleatorioMaquina), aleatorioGenerado), numero.contarFijas(String.valueOf(numeroAleatorioMaquina), aleatorioGenerado)});
                            contadorIntentosJ1++;
                            ventanaPrincipal.getPanelJuego().getCampoJ1().setText("");
                        }
                    }

                    if (textoIngresado.equals(aleatorioGenerado)) {
                        ventanaPrincipal.getMensajes().mostrarGanador("Jugador 1 gana");
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 280);
                        ventanaPrincipal.setLocationRelativeTo(null);
                    } else if (String.valueOf(numeroAleatorioMaquina).equals(aleatorioGenerado)) {
                        ventanaPrincipal.getMensajes().mostrarGanador("Maquina gana.");
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 280);
                        ventanaPrincipal.setLocationRelativeTo(null);
                    }
                    break;
                case "INGRESAR_J2":
                    textoIngresado = ventanaPrincipal.getPanelJuego().getCampoJ2().getText();

                    if (!textoIngresado.equals("")) {
                        ventanaPrincipal.getPanelJuego().getMod2().addRow(new Integer[]{contadorIntentosJ2, Integer.valueOf(textoIngresado), numero.contarPicas(textoIngresado, aleatorioGenerado), numero.contarFijas(textoIngresado, aleatorioGenerado)});
                        ventanaPrincipal.getPanelJuego().getCampoJ2().setText("");
                        ventanaPrincipal.getPanelJuego().getCampoJ2().setEnabled(false);
                        ventanaPrincipal.getPanelJuego().getCampoJ1().setEnabled(true);
                        contadorIntentosJ2++;
                    }

                    if (textoIngresado.equals(aleatorioGenerado)) {
                        ventanaPrincipal.getMensajes().mostrarGanador("Jugador 2 gana");
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 280);
                        ventanaPrincipal.setLocationRelativeTo(null);
                    }
                    break;
                case "PISTA_J1":
                    char[] aleatorioArray = aleatorioGenerado.toCharArray();
                    int digitoAleatorio = numero.generarDigitoAleatorio(seleccionCantidadDigitos - 1);

                    while (randomPrev == digitoAleatorio) {
                        digitoAleatorio = numero.generarDigitoAleatorio(seleccionCantidadDigitos - 1);
                    }
                    randomPrev = digitoAleatorio;

                    System.out.println(aleatorioArray[randomPrev]);
                    ventanaPrincipal.getMensajes().mostrarInfo("" + aleatorioArray[randomPrev]);
                    break;
                case "PISTA_J2":
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
            ventanaPrincipal.getMensajes().mostrarInfo("El valor ingresado debe ser un numero entero de maximo " + seleccionCantidadDigitos + " digitos.");
        }

        if (seleccionCantidadIntentos == (contadorIntentosJ1 - 1) && seleccionCantidadIntentos == (contadorIntentosJ2 - 1)) {
            ventanaPrincipal.getMensajes().mostrarSinIntentos("Sin intentos.\nEl nÃºmero era " + aleatorioGenerado);
            ventanaPrincipal.getPanelJuego().setVisible(false);
            ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
            ventanaPrincipal.setSize(500, 280);
            ventanaPrincipal.setLocationRelativeTo(null);
        }
    }

}
