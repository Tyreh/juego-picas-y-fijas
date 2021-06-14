package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class FondoPrincipal extends JPanel {
	/**
	 * Clase que permite a�adir una imagen al Frame principal.
	 *@author Oscar Moreno
	 *@author Nicolas Camacho
	 *@author Tomas Espitia
	 *@author Nelson Fandi�o
	 */
	
    public void paint(Graphics g) {
    	/**
    	 * Este m�todo permite presentar una imagen
    	 */
    	
        Image fondo = new ImageIcon("src/Images/Fondo2.jpg").getImage();
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
