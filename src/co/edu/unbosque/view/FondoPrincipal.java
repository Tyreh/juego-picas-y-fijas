package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class FondoPrincipal extends JPanel {
    public void paint(Graphics g) {
        Image fondo = new ImageIcon("src/Images/Fondo2.jpg").getImage();
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
