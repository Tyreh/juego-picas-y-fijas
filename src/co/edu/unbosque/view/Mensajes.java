package co.edu.unbosque.view;

import javax.swing.*;

public class Mensajes {
    Icon ganador = new ImageIcon("src/Images/Trofeo.png");
    Icon sinIntentos = new ImageIcon("src/Images/Arresto.png");

    public void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Robo al banco", JOptionPane.PLAIN_MESSAGE);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Robo al banco", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarGanador(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Robo al banco", JOptionPane.PLAIN_MESSAGE, ganador);
    }

    public boolean mostrarSinIntentos(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Robo al banco", JOptionPane.PLAIN_MESSAGE, sinIntentos);
        return true;
    }

    public boolean mostrarInfoOpciones(String mensaje) {
        JOptionPane.showOptionDialog(null, mensaje, "Robo al banco", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        return true;
    }
}
