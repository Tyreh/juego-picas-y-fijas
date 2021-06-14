package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
/**
 * Clase que permite crear un Frame, este caso el principal
 *@author Oscar Moreno
 *@author Nicolas Camacho
 *@author Tomas Espitia
 *@author Nelson Fandiño
 *
 */
public class VentanaPrincipal extends JFrame {
	/**
	 * Objeto de la clase PanelBienvenida, que permite traer el panel de bienvenida y mostrarlos en el frame
	 */
    private PanelBienvenida panelBienvenida;
    /**
     *Objeto de la clase PanelOpcionesJuego, que permite traer el panel de opciones del juego al frame y mostrarlo 
     */
    private PanelOpciones panelOpcionesJuego;
    /**
     *Objeto de la clase PanelEntrenamiento, que permite traer el panel del modo entrenamiento y mostrarlo
     */
    private PanelEntrenamiento panelEntrena;
    /**
     * Objeto de la clase PanelJuego, que permite traer el panel del juego principal y mostrarlo
     */
    private PanelJuego panelJuego;
    /**
     * Objeto de la clase Mensajes, que permite mostrar mensajes emergentes
     */
    private Mensajes mensajes;
    /**
     * Objeto de la clase FondoPrincipal, que permite mostrar una imagen en el frame
     */
    private FondoPrincipal fondo;
    /**
     * Objeto de la clase VentanaEntrenamiento2, que permite mostrar una ventana emergente
     */
    private VentanaEntrenamiento2 ventrena2;

    /**
     * Constructor de la clase
     */
    public VentanaPrincipal() {
        fondo = new FondoPrincipal();
        setTitle("Robo al banco");
        setSize(500, 310);
        setContentPane(fondo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        inicializarComponentes();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    /**
     * Método que permite iniciar cada objeto en el frame, además de permitir estilizarlo
     */
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
    
    /**
     * Método que permite obtener el JDialog ventrena2
     * @return ventrena2
     */
    public VentanaEntrenamiento2 getVentrena2() {
        return ventrena2;
    }

    /**
     * Método que permite obtener el panel panelOpcionesJuego
     * @return panelOpcionesJuego
     */ 
    public PanelOpciones getPanelOpcionesJuego() {
        return panelOpcionesJuego;
    }

    /**
     * Método que permite obtener el panel panelJuego
     * @return panelJuego
     */
    public PanelJuego getPanelJuego() {
        return panelJuego;
    }

    /**
     * Método que permite obtener mensajes emergentes en el frame 
     * @return mensajes
     */
    public Mensajes getMensajes() {
        return mensajes;
    }

    /**
     * Método que permite obtener el panel panelBienvenida
     * @return panelBienvenida
     */
    public PanelBienvenida getPanelBienvenida() {
        return panelBienvenida;
    }

    /**
     * Método que permite obtener el panel panelEntrena
     * @return panelEntrena
     */
    public PanelEntrenamiento getPanelEntrena() {
        return panelEntrena;
    }
    
    /**
     * Método que permite obtener la imagen de fondo en el frame
     * @return fondo
     */
	public FondoPrincipal getFondo() {
		return fondo;
	}
	
	/**
	 * Método que permite cambiar la imagen de fondo
	 * @param fondo, simple setter
	 */
	public void setFondo(FondoPrincipal fondo) {
		this.fondo = fondo;
	}
	
	/**
	 * Método que permite realizar cambios en panelBienvenida
	 * @param panelBienvenida, simple setter
	 */
	public void setPanelBienvenida(PanelBienvenida panelBienvenida) {
		this.panelBienvenida = panelBienvenida;
	}
	
	/**
	 * Método que permite realizar cambios en panelopcionesJuego
	 * @param panelOpcionesJuego, simple setter
	 */
	public void setPanelOpcionesJuego(PanelOpciones panelOpcionesJuego) {
		this.panelOpcionesJuego = panelOpcionesJuego;
	}
	
	/**
	 * Método que permite realizar cambios en panelEntrena
	 * @param panelEntrena, simple setter
	 */
	public void setPanelEntrena(PanelEntrenamiento panelEntrena) {
		this.panelEntrena = panelEntrena;
	}
	
	/**
	 * Método que permite realizar cambios en panelJuego
	 * @param panelJuego, simple setter
	 */
	public void setPanelJuego(PanelJuego panelJuego) {
		this.panelJuego = panelJuego;
	}
	
	/**
	 * Método que permite realizar cambios en mensajes
	 * @param mensajes, simple setter
	 */
	public void setMensajes(Mensajes mensajes) {
		this.mensajes = mensajes;
	}
	
	/**
	 * Método que permite realizar cambios en ventrena2
	 * @param ventrena2, simple setter
	 */
	public void setVentrena2(VentanaEntrenamiento2 ventrena2) {
		this.ventrena2 = ventrena2;
	}

    

}
