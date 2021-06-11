package co.edu.unbosque.view;

import javax.swing.*;

public class Mensajes {
	//Nuevo
	Icon ganador = new ImageIcon("src/Images/Trofeo.png");
	Icon Sinintentos = new ImageIcon("src/Images/Arresto.png");

	
    public void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void mostrarGanador(String mensaje) {
    	
    	JOptionPane.showMessageDialog(null, mensaje, "Ganador", JOptionPane.DEFAULT_OPTION, ganador);
    }
    
public void mostrarSinIntentos(String mensaje) {
    	
    	JOptionPane.showMessageDialog(null, mensaje, "Sin intentos", JOptionPane.DEFAULT_OPTION, Sinintentos);
    }
}
