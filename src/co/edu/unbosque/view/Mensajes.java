package co.edu.unbosque.view;

import javax.swing.*;

public class Mensajes {
    public void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Juego de picas y fijas", JOptionPane.INFORMATION_MESSAGE);
    }
}
