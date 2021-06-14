package co.edu.unbosque.view;
import javax.swing.*;
import java.awt.*;
/**
 * Clase que permite a�adir una imagen al Frame principal.
 *@author Oscar Moreno
 *@author Nicolas Camacho
 *@author Tomas Espitia
 *@author Nelson Fandi�o
 */
public class FondoPrincipal extends JPanel {
	
	/**
	 * Este m�todo permite presentar una imagen
	 */
    public void paint(Graphics g) {
        Image fondo = new ImageIcon("src/Images/Fondo2.jpg").getImage();
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
