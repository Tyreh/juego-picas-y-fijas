package co.edu.unbosque.view;

import javax.swing.*;

public class Mensajes {
    public void mostrarInfo(String mensaje, String titulo, int icono, String... botones) {
        JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, icono, null, botones, botones[0]);
    }
}
