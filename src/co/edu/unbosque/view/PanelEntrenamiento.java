package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelEntrenamiento extends JPanel 
{
	
	private JLabel ep1;
	private JLabel ep2;
	
	private JTextField cnum1;
	private JTextField cnum2;
	
	private JButton baceptar1;
	private JButton baceptar2;
	
	private JButton bayuda1;
	private JButton bayuda2;
	
	private JButton bvolver;
	private JButton btutorial;
	
	private DefaultTableModel mod1;
	private JTable tabla1;
	private JScrollPane scroll1;
	
	private DefaultTableModel mod2;
	private JTable tabla2;
	private JScrollPane scroll2;
	
	private TitledBorder borde;
	
	private ImageIcon teclado;
	private ImageIcon pista;
	
    public PanelEntrenamiento() 
    {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() 
    {
    	setBackground(Color.cyan);
    	
    	borde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));
        setBorder(borde);
        Font font = new Font("Century Gothic", Font.BOLD, 12);
    	Font font1 = new Font("Century Gothic", Font.BOLD, 14);
		borde.setTitleFont(font);
	
    	
		//Jugador1
		ep1 = new JLabel("<html>JUGADOR 1<br/>Ingrese un número:</html>");
		ep1.setBounds(25, 35, 200, 40);
		ep1.setFont(font1);
		add(ep1);
		
		cnum1 = new JTextField();
		cnum1.setFont(font);
		cnum1.setBounds(25, 75, 200, 20);
		add(cnum1);
		
		baceptar1 = new JButton();
		baceptar1.setFont(font);
		baceptar1.setBounds(229, 45, 85, 50);
		teclado = new ImageIcon("src/Images/Cand.png");
		baceptar1.setIcon(new ImageIcon(teclado.getImage().getScaledInstance(baceptar1.getWidth(), baceptar1.getHeight(), Image.SCALE_SMOOTH)));
		add(baceptar1);
		baceptar1.setActionCommand("ACE1_ENT");
		
		bayuda1 = new JButton();
		bayuda1.setFont(font);
		bayuda1.setBounds(319, 45, 85, 50);
		pista = new ImageIcon("src/Images/Pista.png");
		bayuda1.setIcon(new ImageIcon(pista.getImage().getScaledInstance(bayuda1.getWidth(), bayuda1.getHeight(), Image.SCALE_SMOOTH)));
		add(bayuda1);
		bayuda1.setActionCommand("AYU1_ENT");
		
		mod1 = new DefaultTableModel(new String[] {"# Intento","Número", "Picas", "Fijas"}, 0);
		tabla1 = new JTable(mod1);
		tabla1.setEnabled(false);
	    tabla1.setFont(font);
	    tabla1.getTableHeader().setReorderingAllowed(false);
	    tabla1.getTableHeader().setResizingAllowed(false);
		scroll1 = new JScrollPane(tabla1);
		scroll1.setFont(font);
		scroll1.setBounds(25, 100, 380, 350);
		add(scroll1);
		
		//Jugador2
		ep2 = new JLabel("<html>JUGADOR 2<br/>Ingrese un número:</html>");
		ep2.setFont(font1);
		ep2.setBounds(445, 35, 200, 40);
        add(ep2);
		
		cnum2 = new JTextField();
		cnum2.setFont(font);
		cnum2.setBounds(450 , 75 , 190 , 20);
		add(cnum2);		
		
		baceptar2 = new JButton();
		baceptar2.setFont(font);
		baceptar2.setBounds(649, 45, 85, 50);
		teclado = new ImageIcon("src/Images/Cand.png");
		baceptar2.setIcon(new ImageIcon(teclado.getImage().getScaledInstance(baceptar2.getWidth(), baceptar2.getHeight(), Image.SCALE_SMOOTH)));
		add(baceptar2);
		baceptar2.setActionCommand("ACE2_ENT");	
		
		bayuda2 = new JButton();
		bayuda2.setFont(font);
		bayuda2.setBounds(739, 45, 85, 50);
		pista = new ImageIcon("src/Images/Pista.png");
		bayuda2.setIcon(new ImageIcon(pista.getImage().getScaledInstance(bayuda2.getWidth(), bayuda2.getHeight(), Image.SCALE_SMOOTH)));
		add(bayuda2);
		bayuda2.setActionCommand("AYU2_ENT");
		
		mod2 = new DefaultTableModel(new String[] {"# Intento","Número", "Picas", "Fijas"}, 0);
		tabla2 = new JTable(mod2);
		tabla2.setEnabled(false);
		tabla2.setFont(font);
		tabla2.getTableHeader().setReorderingAllowed(false);
		tabla2.getTableHeader().setResizingAllowed(false);
		scroll2 = new JScrollPane(tabla2);
		scroll2.setFont(font);
		scroll2.setBounds(450, 100, 380, 350);
		add(scroll2);
		
		bvolver = new JButton("Volver");
		bvolver.setFont(font);
		bvolver.setBounds(450, 460, 80, 20);
		add(bvolver);
		bvolver.setActionCommand("VOLVER_ENT");
		
		btutorial = new JButton("Tutorial");
		btutorial.setFont(font);
		btutorial.setBounds(324, 460, 80, 20);
		add(btutorial);
		btutorial.setActionCommand("TUTORIAL");
		
		
			
    }

	public JLabel getEp1() {
		return ep1;
	}

	public void setEp1(JLabel ep1) {
		this.ep1 = ep1;
	}

	public JLabel getEp2() {
		return ep2;
	}

	public void setEp2(JLabel ep2) {
		this.ep2 = ep2;
	}

	public JTextField getCnum1() {
		return cnum1;
	}

	public void setCnum1(JTextField cnum1) {
		this.cnum1 = cnum1;
	}

	public JTextField getCnum2() {
		return cnum2;
	}

	public void setCnum2(JTextField cnum2) {
		this.cnum2 = cnum2;
	}

	public JButton getBaceptar1() {
		return baceptar1;
	}

	public void setBaceptar1(JButton baceptar1) {
		this.baceptar1 = baceptar1;
	}

	public JButton getBaceptar2() {
		return baceptar2;
	}

	public void setBaceptar2(JButton baceptar2) {
		this.baceptar2 = baceptar2;
	}

	public JButton getBayuda1() {
		return bayuda1;
	}

	public void setBayuda1(JButton bayuda1) {
		this.bayuda1 = bayuda1;
	}

	public JButton getBayuda2() {
		return bayuda2;
	}

	public void setBayuda2(JButton bayuda2) {
		this.bayuda2 = bayuda2;
	}

	public JButton getBvolver() {
		return bvolver;
	}

	public void setBvolver(JButton bvolver) {
		this.bvolver = bvolver;
	}

	public JButton getBtutorial() {
		return btutorial;
	}

	public void setBtutorial(JButton btutorial) {
		this.btutorial = btutorial;
	}

	public DefaultTableModel getMod1() {
		return mod1;
	}

	public void setMod1(DefaultTableModel mod1) {
		this.mod1 = mod1;
	}

	public JTable getTabla1() {
		return tabla1;
	}

	public void setTabla1(JTable tabla1) {
		this.tabla1 = tabla1;
	}

	public JScrollPane getScroll1() {
		return scroll1;
	}

	public void setScroll1(JScrollPane scroll1) {
		this.scroll1 = scroll1;
	}

	public DefaultTableModel getMod2() {
		return mod2;
	}

	public void setMod2(DefaultTableModel mod2) {
		this.mod2 = mod2;
	}

	public JTable getTabla2() {
		return tabla2;
	}

	public void setTabla2(JTable tabla2) {
		this.tabla2 = tabla2;
	}

	public JScrollPane getScroll2() {
		return scroll2;
	}

	public void setScroll2(JScrollPane scroll2) {
		this.scroll2 = scroll2;
	}

	public TitledBorder getBorde() {
		return borde;
	}

	public void setBorde(TitledBorder borde) {
		this.borde = borde;
	}

	public ImageIcon getTeclado() {
		return teclado;
	}

	public void setTeclado(ImageIcon teclado) {
		this.teclado = teclado;
	}

	public ImageIcon getPista() {
		return pista;
	}

	public void setPista(ImageIcon pista) {
		this.pista = pista;
	}

}
