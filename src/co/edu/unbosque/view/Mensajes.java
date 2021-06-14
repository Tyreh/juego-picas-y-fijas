package co.edu.unbosque.view;

import javax.swing.*;

/**
 * Clase que permite mostrar diferentes tipos de mensajes por medio de un JOptionPane
 *@author Oscar Moreno
 *@author Nicolas Camacho
 *@author Tomas Espitia
 *@author Nelson Fandiño
 *
 */
public class Mensajes 
{
	/**
	 * Imagen que aparece al ganador
	 */
    private Icon ganador = new ImageIcon("src/Images/Trofeo.png");
    /**
     * Imagen que aparece cuando se rinde o se agotan los intentos
     */
    private Icon sinIntentos = new ImageIcon("src/Images/Arresto.png");
    
    /**
     * Método que permite mostrar un mensaje en pantalla por medio de una ventana emergente
     * @param mensaje, es el escrito que aparece en la ventana emergente
     */
    public void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Robo al banco", JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Método que permite mostrar un mensaje notificando un error por medio de una ventana emergente
     * @param mensaje, es el escrito que aparece en la ventana emergente
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Robo al banco", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Método que permite mostrar un mensaje con el ganador y una imagen por medio de una ventana emergente
     * @param mensaje, es el escrito que aparece en la ventana emergente junto a la imagen
     */
    public void mostrarGanador(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Robo al banco", JOptionPane.PLAIN_MESSAGE, ganador);
    }
    /**
     * Método que permite mostrar un mensaje cuando se agotan los intentos o se rinden los jugadores y una imagen por medio de una ventana emergente
     * @param mensaje, es el escrito que aparece en la ventana emergente junto a la imagen
     * @return retorna un valor boleano verdadero
     */
    public boolean mostrarSinIntentos(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Robo al banco", JOptionPane.PLAIN_MESSAGE, sinIntentos);
        return true;
    }
}
