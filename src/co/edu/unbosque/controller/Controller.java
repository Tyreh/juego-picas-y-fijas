package co.edu.unbosque.controller;

import co.edu.unbosque.model.Numero;
import co.edu.unbosque.view.VentanaEntrenamiento2;
import co.edu.unbosque.view.VentanaPrincipal;

import java.awt.event.*;

import java.io.File;

import java.util.Objects;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
/**
 * Clase encargada de la ejecución.
 *@author Oscar Dario Moreno
 *@author Nicolas Camacho Lesmes
 *@author Tomas Espitia Galindo
 *@author Nelson Fandi�o Diaz
 */
public class Controller implements ActionListener {
	/**
	 * Objeto de tipo VentanaPrincipal, permite llamar a la ventana principal y sus paneles.
	 */
    private VentanaPrincipal ventanaPrincipal;
    /**
	 * Objeto de tipo VentanaEntrenamiento2, permite llamar a la ventana de entrenamiento
	 */
    private VentanaEntrenamiento2 ventrena2;
    /**
	 * Objeto de tipo Numero, permite llamar los métodos.
	 */
    private Numero numero;
    
    /**
	 * Objeto de tipo int, encargado de almacenar la cantidad de dígitos seleccionados.
	 */
    private int seleccionCantidadDigitos;
    /**
	 * Objeto de tipo String, encargado de almacenar el número aleatorio.
	 */
    private String aleatorioGenerado = "";
    /**
	 * Objeto de tipo String, encargado de almacenar el texto ingresado.
	 */
    private String textoIngresado = "";
    /**
	 * Objeto de tipo String, encargado de almacenar el número aleatorio generado por la maquina.
	 */
    private String numeroAleatorioMaquina;
    /**
	 * Objeto de tipo int, encargado de almacenar los intentos del jugador 2.
	 */
    private int contadorIntentosJ1 = 0;
    /**
	 * Objeto de tipo int, encargado de almacenar los intentos del jugador 2.
	 */
    private int contadorIntentosJ2 = 0;
    /**
	 * Objeto de tipo int, encargado de almacenar la cantidad de intentos seleccionados.
	 */
    private int seleccionCantidadIntentos;
    /**
	 * Objeto de tipo int, encargado de almacenar el puntaje del jugador 1.
	 */
    private int puntajeJ1 = 30;
    /**
	 * Objeto de tipo int, encargado de almacenar el puntaje del jugador 2.
	 */
    private int puntajeJ2 = 30;
    /**
	 * Objeto de tipo Clip, encargado de reproducir un sonido en el menu principal y dentro del juego.
	 */
    private Clip sonido;
    /**
	 * Objeto de tipo Clip, encargado de reproducir un sonido al ganar.
	 */
    private Clip sonidowin;
    /**
	 * Objeto de tipo Clip, encargado de reproducir un sonido al perder.
	 */
    private Clip sonidoloser;
    /**
	 * Método constructor de la clase
	 */
    public Controller() {
        ventrena2 = new VentanaEntrenamiento2();
        ventanaPrincipal = new VentanaPrincipal();
        ventanaPrincipal.getPanelBienvenida().setVisible(true);
        asignarOyentes();
    }
    /**
     * Método encargado de asignar las funciones a cada boton.
     */
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
        
        ventanaPrincipal.getVentrena2().getVolverOp().addActionListener(this);

    }
    /**
     * Método encargado de llamar la función para cada bóton.
     */
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
                    ventanaPrincipal.getPanelJuego().getCampoJ1().setToolTipText("¡Ingresa un número de " + seleccionCantidadDigitos + " dígitos para descifrar el código!");
                    ventanaPrincipal.getPanelJuego().getCampoJ2().setToolTipText("¡Ingresa un número de " + seleccionCantidadDigitos + " dígitos para descifrar el código!");
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
                    System.out.println("Opciones de juego: (DEBUG)");
                    System.out.println("    Numero aleatorio de " + seleccionCantidadDigitos + " generado: " + aleatorioGenerado);
                    System.out.println("    Cantidad de intentos: " + seleccionCantidadIntentos);
                    System.out.println("    Repeticion de digitos: " + Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem()));
                    System.out.println("    Modo de juego: " + Objects.requireNonNull((String) ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem()));
                    System.out.println("==========================================");
                    break;
                case "PLANEAR_ROBO":
                    ventanaPrincipal.getVentrena2().setTitle("Modo Entrenamiento");
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(false);
                    ventanaPrincipal.setSize(590, 400);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    ventanaPrincipal.getVentrena2().setVisible(true);
                    ventanaPrincipal.getVentrena2().setLocationRelativeTo(null);
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
                            ventanaPrincipal.getPanelJuego().getMod1().addRow(new String[]{(String.valueOf(contadorIntentosJ1 + 1)), textoIngresado, String.valueOf(numero.contarPicas(textoIngresado, aleatorioGenerado)), String.valueOf(numero.contarFijas(textoIngresado, aleatorioGenerado))});
                            ventanaPrincipal.getPanelJuego().getMod2().addRow(new String[]{String.valueOf((contadorIntentosJ2 + 1)), numeroAleatorioMaquina, String.valueOf(numero.contarPicas(numeroAleatorioMaquina, aleatorioGenerado)), String.valueOf(numero.contarFijas(numeroAleatorioMaquina, aleatorioGenerado))});
                            ventanaPrincipal.getPanelJuego().getCampoJ1().setText("");
                            contadorIntentosJ1++;
                            contadorIntentosJ2++;
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

                        ventanaPrincipal.getMensajes().mostrarGanador("¡El ladrón #1 ha descifrado el código " + aleatorioGenerado + "!\n\n+10 puntos para el ladrón #1\n-10 puntos para el ladrón #2");
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 310);
                        ventanaPrincipal.setLocationRelativeTo(null);
                        contadorIntentosJ1 = 0;
                        contadorIntentosJ2 = 0;
                        puntajeJ1 += 10;
                        puntajeJ2 -= 10;

                        sonidowin.stop();
                        sonido.start();
                        ventanaPrincipal.getPanelOpcionesJuego().getQuitarMusica().setVisible(true);

                    } else if (String.valueOf(numeroAleatorioMaquina).equals(aleatorioGenerado)) {
                        sonido.stop();
                        try {
                            sonidowin = AudioSystem.getClip();
                            sonidowin.open(AudioSystem.getAudioInputStream(new File("src/Music/Soundwin.wav")));
                            sonidowin.start();
                        } catch (Exception e1) {
                            System.out.println("" + e1);
                        }

                        ventanaPrincipal.getMensajes().mostrarGanador("¡La máquina ha descifrado el código " + aleatorioGenerado + "!\n\n-10 puntos para el ladrón #1");
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 310);
                        ventanaPrincipal.setLocationRelativeTo(null);
                        contadorIntentosJ1 = 0;
                        contadorIntentosJ2 = 0;
                        puntajeJ1 -= 10;

                        sonidowin.stop();
                        sonido.start();
                        ventanaPrincipal.getPanelOpcionesJuego().getQuitarMusica().setVisible(true);
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

                        ventanaPrincipal.getMensajes().mostrarGanador("¡El ladrón #2 ha descifrado el código " + aleatorioGenerado + "!\n\n+10 puntos para el ladrón #2\n-10 puntos para el ladrón #1");
                        ventanaPrincipal.getPanelJuego().setVisible(false);
                        ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                        ventanaPrincipal.setSize(500, 310);
                        ventanaPrincipal.setLocationRelativeTo(null);
                        contadorIntentosJ1 = 0;
                        contadorIntentosJ2 = 0;
                        puntajeJ2 += 10;
                        puntajeJ1 -= 10;

                        sonidowin.stop();
                        sonido.start();
                        ventanaPrincipal.getPanelOpcionesJuego().getQuitarMusica().setVisible(true);
                    }
                    break;
                case "PISTA_J1":
                    if (seleccionCantidadDigitos < 3) {
                        ventanaPrincipal.getMensajes().mostrarInfo("¡Debes seleccionar más de 3 dígitos para poder utilizar pistas!");
                    } else if (puntajeJ1 >= 10) {
                        puntajeJ1 -= 10;
                        ventanaPrincipal.getMensajes().mostrarInfo("¡-10 puntos! Ahora tienes " + puntajeJ1 + " puntos.\n\nEl código contiene el dígito " + Character.getNumericValue(numero.pista(aleatorioGenerado)));
                    } else {
                        ventanaPrincipal.getMensajes().mostrarInfo("¡Necesitas al menos 10 puntos para canjear una pista!");
                    }
                    break;
                case "PISTA_J2":
                    if (seleccionCantidadDigitos < 3) {
                        ventanaPrincipal.getMensajes().mostrarInfo("¡Debes seleccionar más de 3 dígitos para poder utilizar pistas!");
                    } else if (puntajeJ2 >= 10) {
                        puntajeJ2 -= 10;
                        ventanaPrincipal.getMensajes().mostrarInfo("¡-10 puntos! Ahora tienes " + puntajeJ2 + " puntos.\n\nEl código contiene el dígito " + Character.getNumericValue(numero.pista(aleatorioGenerado)));
                    } else {
                        ventanaPrincipal.getMensajes().mostrarInfo("¡Necesitas al menos 10 puntos para canjear una pista!");
                    }
                    break;
                case "INFORMACION_JUEGO":
                    ventanaPrincipal.getMensajes().mostrarInfo("Opciones de juego seleccionadas:\n" +
                            "  Cantidad de dígitos: " + seleccionCantidadDigitos + "\n" +
                            "  Cantidad de intentos: " + seleccionCantidadIntentos + "\n" +
                            "  Repetición de dígitos: " + ventanaPrincipal.getPanelOpcionesJuego().getRepetirDigitos().getSelectedItem() + "\n" +
                            "  Modo de juego: " + ventanaPrincipal.getPanelOpcionesJuego().getModoDeJuego().getSelectedItem());
                    break;
                    
                case "VOLVERME":
                    ventanaPrincipal.getVentrena2().setVisible(false);
                    ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
                    ventanaPrincipal.setSize(500, 310);
                    ventanaPrincipal.setLocationRelativeTo(null);
                    break;    
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException exception) {
            ventanaPrincipal.getMensajes().mostrarError("El código ingresado debe ser un numero entero de " + seleccionCantidadDigitos + " dígitos.");
        }

        if (seleccionCantidadIntentos == contadorIntentosJ1 && seleccionCantidadIntentos == contadorIntentosJ2 || comando.equals("RENDICION") || comando.equals("VOLVER_ENT")) {
            sonido.stop();
            try {
                sonidoloser = AudioSystem.getClip();
                sonidoloser.open(AudioSystem.getAudioInputStream(new File("src/Music/TitanicFlauta.wav")));
                sonidoloser.start();
            } catch (Exception e1) {
                System.out.println("" + e1);
            }

            ventanaPrincipal.getMensajes().mostrarSinIntentos("¡Ningún ladrón logró descifrar el código " + aleatorioGenerado + "!\n\n-10 puntos para ambos ladrones.");
            ventanaPrincipal.getPanelJuego().setVisible(false);
            ventanaPrincipal.getPanelOpcionesJuego().setVisible(true);
            ventanaPrincipal.setSize(500, 310);
            ventanaPrincipal.setLocationRelativeTo(null);
            contadorIntentosJ1 = 0;
            contadorIntentosJ2 = 0;
            puntajeJ1 -= 10;
            puntajeJ2 -= 10;

            sonidoloser.stop();
            sonido.start();
            ventanaPrincipal.getPanelOpcionesJuego().getQuitarMusica().setVisible(true);
        }

        ventanaPrincipal.getPanelOpcionesJuego().getPuntajeJ1().setText(String.valueOf(puntajeJ1));
        ventanaPrincipal.getPanelOpcionesJuego().getPuntajeJ2().setText(String.valueOf(puntajeJ2));
    }
}
