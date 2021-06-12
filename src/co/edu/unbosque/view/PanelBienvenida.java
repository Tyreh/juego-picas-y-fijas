package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelBienvenida extends JPanel {
    private JButton botonAceptar;
    public PanelBienvenida() {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() {
        TitledBorder tituloBorde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));
        setBorder(tituloBorde);

        JLabel enum1 = new JLabel("¿Lograras descifrar el codigo?", SwingConstants.CENTER);
        enum1.setFont(new Font("", Font.BOLD, 14));
        enum1.setBounds(103, 10, 250, 20);
        add(enum1);

        JLabel enum2 = new JLabel("<html>Profesor:<br/><br/>Materia:<br/><br/>Integrantes:</html>");
        enum2.setFont(new Font("", Font.BOLD, 14));
        enum2.setBounds(82, 50, 200, 100);
        add(enum2);

        JLabel enum3 = new JLabel("<html>Helio Ramirez<br/><br/>Fundamentos de programacion<br/><br/>Oscar Moreno, Nelson Fandino<br/>Tomas Espitia, Nicolas Camacho</html>");
        enum3.setFont(new Font("", -1, 14));
        enum3.setBounds(200, 10, 220, 200);
        add(enum3);

        botonAceptar = new JButton();
        botonAceptar.setBounds(150, 170, 150, 40);
        botonAceptar.setActionCommand("VAMOS_A_ROBAR");
        ImageIcon ak = new ImageIcon("src/Images/Ak1.png");
        botonAceptar.setIcon(new ImageIcon(ak.getImage().getScaledInstance(botonAceptar.getWidth(), botonAceptar.getHeight(), Image.SCALE_SMOOTH)));
        add(botonAceptar);
    }
   
    public JButton getBotonAceptar() {
        return botonAceptar;
    }
}
