package co.edu.unbosque.controller;

import co.edu.unbosque.model.Numero;
import co.edu.unbosque.view.VentanaEntrenamiento2;
import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.event.*;

import java.io.File;

import java.util.Objects;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Controller implements ActionListener {
    private VentanaPrincipal ventanaPrincipal;
    private VentanaEntrenamiento2 ventrena2;
    private Numero numero;

    private int seleccionCantidadDigitos;
    private String aleatorioGenerado = "";
    private String textoIngresado = "";
    private String numeroAleatorioMaquina;
    private int contadorIntentosJ1 = 0;
    private int contadorIntentosJ2 = 0;
    private int seleccionCantidadIntentos;
    private int randomPrev = 0;
    private Clip sonido;
    private Clip sonidowin;
    private Clip sonidoloser;

    public Controller() {
        ventrena2 = new VentanaEntrenamiento2();
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.getPanelBienvenida().setVisible(true);
        asignarOyentes();
    }

    public void asignarOyentes() {
        ventanaPrincipal.getPanelBienvenida().getBotonAceptar().addActionListener(this);

        ventanaPrincipal.getPanelOpcionesJuego().getBotonEmpezarRobo().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getBotonEntrenamiento().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getQuitarMusica().addActionListener(this);
        ventanaPrincipal.getPanelOpcionesJuego().getPonerMusica().addActionListener(this);

        ventanaPrincipal.getPanelJuego().getBotonIngresarJ1().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonPistaJ1().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonPistaJ2().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonVolver().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonInformacion().addActionListener(this);


        ventanaPrincipal.getPanelJuego().getEnumJ1().addMouseListener(new MouseAdapter() {
        });
        ventanaPrincipal.getPanelEntrena().getBvolver().addActionListener(this);
        ventanaPrincipal.getPanelEntrena().getBtutorial().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        seleccionCantidadDigitos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadDigitos().getSelectedItem());
        seleccionCantidadIntentos = (int) Objects.requireNonNull(ventanaPrincipal.getPanelOpcionesJuego().getCantidadIntentos().getSelectedItem());

        try {
            switch (comando) {
                case "VAMOS_A_ROBAR":
                    ventanaPrincipal.getPanelBienvenida().setVisible(false);
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);

                    //M�sica
                    try {
                        // Se obtiene un Clip de sonido
                        sonido = AudioSystem.getClip();
                        // Se carga con un fichero wav
                        sonido.open(AudioSystem.getAudioInputStream(new File("src/Music/CancionJuego.wav")));

                        // Comienza la reproducci�n
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

                case "QUITARSON":
                    sonido.stop();
                    ventanaPrincipal.getPanelOpcionesJuego().getQuitarMusica().setVisible(false);
                    ventanaPrincipal.getPanelOpcionesJuego().getPonerMusica().setVisible(true);
                    break;

                case "PONERSON":
                    sonido.start();
                    ventanaPrincipal.getPanelOpcionesJuego().getPonerMusica().setVisible(false);
                    ventanaPrincipal.getPanelOpcionesJuego().getQuitarMusica().setVisible(true);
                    break;

                case "EMPEZAR_EL_ROBO":
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(false);
                    ventanaPrincipal.setSize(885, 550);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    ventanaPrincipal.getPanelJuego().setVisible(true);
                    ventanaPrincipal.getPanelJuego().getCampoJ1().setEnabled(true);
                    ventanaPrincipal.getPanelJuego().getCampoJ2().setEnabled(false);
                    ventanaPrincipal.getPanelJuego().getCampoJ1().setText("");
                    ventanaPrincipal.getPanelJuego().getCampoJ2().setText("");
                    ventanaPrincipal.getPanelJuego().getBotonIngresarJ1().setEnabled(true);
                    ventanaPrincipal.getPanelJuego().getBotonPistaJ1().setEnabled(true);
                    ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setEnabled(false);
                    ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setEnabled(false);
                    ventanaPrincipal.getPanelJuego().getMod1().setRowCount(0);
                    ventanaPrincipal.getPanelJuego().getMod2().setRowCount(0);
                    contadorIntentosJ1 = 0;
                    contadorIntentosJ2 = 0;

                    switch (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem())) {
                        case "Si":
                            numero = new Numero(seleccionCantidadDigitos);
                            aleatorioGenerado = String.valueOf(numero.generarNumeroAleatorio());
                            break;
                        case "No":
                            numero = new Numero(seleccionCantidadDigitos);
                            aleatorioGenerado = numero.generarNumeroAleatorioSinRepeticion();
                            break;
                    }

                    switch (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem())) {
                        case "Jugador vs Jugador":
                            ventanaPrincipal.getPanelJuego().getBorde().setTitle("Jugador vs Jugador");
                            ventanaPrincipal.getPanelJuego().getGif().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getCampoJ2().setVisible(true);
                            ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setVisible(true);
                            ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setVisible(true);
                            ventanaPrincipal.getPanelJuego().getEnumJ2().setText("<html>Ladrón #2<br/>Ingrese un número:</html>");
                            break;
                        case "Jugador vs Maquina":
                            ventanaPrincipal.getPanelJuego().getBorde().setTitle("Jugador vs Máquina");
                            ventanaPrincipal.getPanelJuego().getCampoJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setVisible(false);
                            ventanaPrincipal.getPanelJuego().getEnumJ2().setText("<html>Ladrón #2</html>");

                            ventanaPrincipal.getPanelJuego().getGif().setVisible(true);
                            break;
                    }

                    System.out.println("==========================================");
                    System.out.println("Opciones de juego: ");
                    System.out.println("    Numero aleatorio de " + seleccionCantidadDigitos + " generado: " /*+ aleatorioGenerado*/);
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
                    ventrena2.setVisible(true);
                    break;
                case "INGRESAR_J1":
                    textoIngresado = ventanaPrincipal.getPanelJuego().getCampoJ1().getText();
                    if (!textoIngresado.equals("")) {
                        if (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem()).equals("Jugador vs Jugador")) {
                            ventanaPrincipal.getPanelJuego().getMod1().addRow(new String[]{(String.valueOf(contadorIntentosJ1 + 1)), textoIngresado, String.valueOf(numero.contarPicas(textoIngresado, aleatorioGenerado)), String.valueOf(numero.contarFijas(textoIngresado, aleatorioGenerado))});
                            ventanaPrincipal.getPanelJuego().getCampoJ1().setText("");
                            ventanaPrincipal.getPanelJuego().getCampoJ1().setEnabled(false);
                            ventanaPrincipal.getPanelJuego().getBotonIngresarJ1().setEnabled(false);
                            ventanaPrincipal.getPanelJuego().getBotonPistaJ1().setEnabled(false);
                            ventanaPrincipal.getPanelJuego().getCampoJ2().setEnabled(true);
                            ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setEnabled(true);
                            ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setEnabled(true);
                            contadorIntentosJ1++;
                        } else if (Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem()).equals("Jugador vs Maquina")) {
                            numeroAleatorioMaquina = numero.generarNumeroAleatorio();
                            System.out.println(seleccionCantidadDigitos);
                            System.out.println(numeroAleatorioMaquina);
                            System.out.println(textoIngresado);
                            ventanaPrincipal.getPanelJuego().getMod1().addRow(new String[]{(String.valueOf(contadorIntentosJ1 + 1)), textoIngresado, String.valueOf(numero.contarPicas(textoIngresado, aleatorioGenerado)), String.valueOf(numero.contarFijas(textoIngresado, aleatorioGenerado))});
                            ventanaPrincipal.getPanelJuego().getMod2().addRow(new String[]{String.valueOf((contadorIntentosJ2 + 1)), numeroAleatorioMaquina, String.valueOf(numero.contarPicas(numeroAleatorioMaquina, aleatorioGenerado)), String.valueOf(numero.contarFijas(numeroAleatorioMaquina, aleatorioGenerado))});

                            contadorIntentosJ1++;
                            contadorIntentosJ2++;
                            ventanaPrincipal.getPanelJuego().getCampoJ1().setText("");
                        }
                    }

                    if (textoIngresado.equals(aleatorioGenerado)) {
                        sonido.stop();
                        try {
                            sonidowin = AudioSystem.getClip();
                            sonidowin.open(AudioSystem.getAudioInputStream(new File("src/Music/Soundwin.wav")));
                            sonidowin.start();
                        } catch (Exception e1) {
                            System.out.println("" + e1);
                        }

                        ventanaPrincipal.getMensajes().mostrarGanador("¡El ladrón #1 ha descifrado el código!\nEl código era " + aleatorioGenerado);
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 310);
                        ventanaPrincipal.setLocationRelativeTo(null);
                        contadorIntentosJ1 = 0;
                        contadorIntentosJ2 = 0;

                        sonidowin.stop();
                        sonido.start();

                    } else if (String.valueOf(numeroAleatorioMaquina).equals(aleatorioGenerado)) {
                        sonido.stop();
                        try {
                            sonidowin = AudioSystem.getClip();
                            sonidowin.open(AudioSystem.getAudioInputStream(new File("src/Music/Soundwin.wav")));
                            sonidowin.start();
                        } catch (Exception e1) {
                            System.out.println("" + e1);
                        }

                        ventanaPrincipal.getMensajes().mostrarGanador("¡El ladrón #2 ha descifrado el código!\nEl código era " + aleatorioGenerado);
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 310);
                        ventanaPrincipal.setLocationRelativeTo(null);
                        contadorIntentosJ1 = 0;
                        contadorIntentosJ2 = 0;

                        sonidowin.stop();
                        sonido.start();
                    }
                    break;
                case "INGRESAR_J2":
                    textoIngresado = ventanaPrincipal.getPanelJuego().getCampoJ2().getText();

                    if (!textoIngresado.equals("")) {
                        ventanaPrincipal.getPanelJuego().getMod2().addRow(new String[]{String.valueOf((contadorIntentosJ2 + 1)), textoIngresado, String.valueOf(numero.contarPicas(textoIngresado, aleatorioGenerado)), String.valueOf(numero.contarFijas(textoIngresado, aleatorioGenerado))});
                        ventanaPrincipal.getPanelJuego().getCampoJ2().setText("");
                        ventanaPrincipal.getPanelJuego().getCampoJ2().setEnabled(false);
                        ventanaPrincipal.getPanelJuego().getCampoJ1().setEnabled(true);
                        ventanaPrincipal.getPanelJuego().getBotonIngresarJ1().setEnabled(true);
                        ventanaPrincipal.getPanelJuego().getBotonPistaJ1().setEnabled(true);
                        ventanaPrincipal.getPanelJuego().getBotonIngresarJ2().setEnabled(false);
                        ventanaPrincipal.getPanelJuego().getBotonPistaJ2().setEnabled(false);
                        contadorIntentosJ2++;
                    }

                    if (textoIngresado.equals(aleatorioGenerado)) {
                        sonido.stop();
                        try {
                            sonidowin = AudioSystem.getClip();
                            sonidowin.open(AudioSystem.getAudioInputStream(new File("src/Music/Soundwin.wav")));
                            sonidowin.start();
                        } catch (Exception e1) {
                            System.out.println("" + e1);
                        }

                        ventanaPrincipal.getMensajes().mostrarGanador("Jugador 2 gana");
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 310);
                        ventanaPrincipal.setLocationRelativeTo(null);
                        contadorIntentosJ1 = 0;
                        contadorIntentosJ2 = 0;

                        sonidowin.stop();
                        sonido.start();
                    }
                    break;
                case "PISTA_J1":
/*                    char[] aleatorioArray = aleatorioGenerado.toCharArray();
                    int digitoAleatorio = numero.generarDigitoAleatorio(seleccionCantidadDigitos - 1);

                    while (randomPrev == digitoAleatorio) {
                        digitoAleatorio = numero.generarDigitoAleatorio(seleccionCantidadDigitos - 1);
                    }
                    randomPrev = digitoAleatorio;

                    System.out.println(aleatorioArray[randomPrev]);
                    ventanaPrincipal.getMensajes().mostrarInfo("" + aleatorioArray[randomPrev]);*/
                    break;
                case "PISTA_J2":
                    break;
                case "INFORMACION_JUEGO":
                    ventanaPrincipal.getMensajes().mostrarInfo("Opciones de juego seleccionadas:\n" +
                            "  Cantidad de dígitos: " + seleccionCantidadDigitos + "\n" +
                            "  Cantidad de intentos: " + seleccionCantidadIntentos + "\n" +
                            "  Repetición de dígitos: " + ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem() + "\n" +
                            "  Modo de juego: " + ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem());
                    break;
                case "RENDICION":
                    sonido.stop();
                    try {
                        sonidoloser = AudioSystem.getClip();
                        sonidoloser.open(AudioSystem.getAudioInputStream(new File("src/Music/TitanicFlauta.wav")));
                        sonidoloser.start();
                    } catch (Exception e1) {
                        System.out.println("" + e1);
                    }

                    if (ventanaPrincipal.getMensajes().mostrarSinIntentos("¡Ningún ladrón logró descifrar el código!\nEl código era " + aleatorioGenerado)) {
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 310);
                        ventanaPrincipal.setLocationRelativeTo(null);
                        contadorIntentosJ1 = 0;
                        contadorIntentosJ2 = 0;

                        sonidoloser.stop();
                        sonido.start();
                    }
                    break;
                case "VOLVER_ENT":
                    ventanaPrincipal.getPanelEntrena().setVisible(false);
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                    ventanaPrincipal.setSize(500, 310);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    break;

                case "TUTORIAL":
                    ventrena2.setVisible(true);
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException exception) {
            ventanaPrincipal.getMensajes().mostrarError("El código ingresado debe ser un numero entero de " + seleccionCantidadDigitos + " dígitos.");
        }

        if (seleccionCantidadIntentos == contadorIntentosJ1 && seleccionCantidadIntentos == contadorIntentosJ2) {
            sonido.stop();
            try {
                sonidoloser = AudioSystem.getClip();
                sonidoloser.open(AudioSystem.getAudioInputStream(new File("src/Music/TitanicFlauta.wav")));
                sonidoloser.start();
            } catch (Exception e1) {
                System.out.println("" + e1);
            }

            ventanaPrincipal.getMensajes().mostrarSinIntentos("¡Ningún ladrón logró descifrar el código!\nEl código era " + aleatorioGenerado);
            ventanaPrincipal.getPanelJuego().setVisible(false);
            ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
            ventanaPrincipal.setSize(500, 310);
            ventanaPrincipal.setLocationRelativeTo(null);
            contadorIntentosJ1 = 0;
            contadorIntentosJ2 = 0;

            sonidoloser.stop();
            sonido.start();
        }
    }
}
