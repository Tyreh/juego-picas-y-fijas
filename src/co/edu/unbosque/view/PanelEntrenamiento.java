package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelEntrenamiento extends JPanel 
{
	
	private JLabel ej1;
	private JLabel ej2;
	private JLabel ep1;
	private JLabel ep2;
	
	private JTextField cnum1;
	private JTextField cnum2;
	
	private JButton baceptar1;
	private JButton baceptar2;
	private JButton bayuda1;
	private JButton bayuda2;
	private JButton bvolver;
	
	
	private String [] cabezera1 = {"# Jugador 1","Fijas","Picas"};
	private String [][] datos1 = 
		{
				{"1341","4","3"}
		};
	private DefaultTableModel mod1;
	private JTable tabla1;
	private JScrollPane scroll1;
	
	private String [] cabezera2 = {"# Jugador 1","Fijas","Picas"};
	private String [][] datos2 = 
		{
				{"1341","4","3"}
		};
	private DefaultTableModel mod2;
	private JTable tabla2;
	private JScrollPane scroll2;

	private TitledBorder borde;
	
    public PanelEntrenamiento() 
    {
        setLayout(null);
        inicializarComponentes();
        setVisible(false);
    }

    public void inicializarComponentes() 
    {
    	borde = new TitledBorder(new LineBorder(Color.BLACK, 1, false));
        setBorder(borde);
        Font font = new Font("Century Gothic", Font.BOLD, 12);
    	Font font1 = new Font("Century Gothic", Font.BOLD, 14);
		borde.setTitleFont(font);
		//setBorder(borde);
    	
    	ep1 = new JLabel("JUGADOR 1");
    	ep1.setFont(font1);
    	ep1.setBounds(25, 30, 200, 20);
		add(ep1);
    	ej1 = new JLabel("Ingrese un n�mero de x d�gitos: ");
    	ej1.setFont(font);
    	ej1.setBounds(25, 50, 200, 20);
		add(ej1);
		cnum1 = new JTextField();
		cnum1.setFont(font);
		cnum1.setBounds(25, 75, 200, 20);
		add(cnum1);
		baceptar1 = new JButton("Aceptar");
		baceptar1.setFont(font);
		baceptar1.setBounds(230, 75, 83, 20);
		add(baceptar1);
		baceptar1.setActionCommand("ACE1_ENT");
		bayuda1 = new JButton("Ayuda");
		bayuda1.setFont(font);
		bayuda1.setBounds(315, 75, 80, 20);
		add(bayuda1);
		bayuda1.setActionCommand("AYU1_ENT");
		
		ep2 = new JLabel("JUGADOR 2");
		ep2.setFont(font1);
    	ep2.setBounds(450, 30, 200, 20);
		add(ep2);		
		ej2 = new JLabel("Ingrese un n�mero de x d�gitos: ");
		ej2.setFont(font);
    	ej2.setBounds(450, 50, 200, 20);
		add(ej2);		
		cnum2 = new JTextField();
		cnum2.setFont(font);
		cnum2.setBounds(450 , 75 , 200 , 20);
		add(cnum2);		
		baceptar2 = new JButton("Aceptar");
		baceptar2.setFont(font);
		baceptar2.setBounds(655, 75, 83, 20);
		add(baceptar2);
		baceptar2.setActionCommand("ACE2_ENT");	
		bayuda2 = new JButton("Ayuda");
		bayuda2.setFont(font);
		bayuda2.setBounds(740, 75, 80, 20);
		add(bayuda2);
		bayuda2.setActionCommand("AYU2_ENT");
		
		bvolver = new JButton("Volver");
		bvolver.setFont(font);
		bvolver.setBounds(385, 460, 80, 20);
		add(bvolver);
		bvolver.setActionCommand("VOLVER_ENT");
		
		mod1 = new DefaultTableModel(new String[] {"# Intento","N�mero", "Picas", "Fijas"}, 0);
		tabla1 = new JTable(mod1);
		tabla1.setEnabled(false);
	    tabla1.setFont(font);
	    tabla1.getTableHeader().setReorderingAllowed(false);
	    tabla1.getTableHeader().setResizingAllowed(false);
		scroll1 = new JScrollPane(tabla1);
		scroll1.setFont(font);
		scroll1.setBounds(25, 100, 380, 350);
		add(scroll1);
		
		
		mod2 = new DefaultTableModel(new String[] {"# Intento","N�mero", "Picas", "Fijas"}, 0);
		tabla2 = new JTable(mod2);
		tabla2.setEnabled(false);
		tabla2.setFont(font);
		tabla2.getTableHeader().setReorderingAllowed(false);
		tabla2.getTableHeader().setResizingAllowed(false);
		scroll2 = new JScrollPane(tabla2);
		scroll2.setFont(font);
		scroll2.setBounds(450, 100, 380, 350);
		add(scroll2);
    }
     	
	public TitledBorder getBorde() {
		return borde;
	}

	public void setBorde(TitledBorder borde) {
		this.borde = borde;
	}

	public JLabel getEj1() {
		return ej1;
	}

	public void setEj1(JLabel ej1) {
		this.ej1 = ej1;
	}

	public JLabel getEj2() {
		return ej2;
	}

	public void setEj2(JLabel ej2) {
		this.ej2 = ej2;
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

	public String[] getCabezera1() {
		return cabezera1;
	}

	public void setCabezera1(String[] cabezera1) {
		this.cabezera1 = cabezera1;
	}

	public String[][] getDatos1() {
		return datos1;
	}

	public void setDatos1(String[][] datos1) {
		this.datos1 = datos1;
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

	public String[] getCabezera2() {
		return cabezera2;
	}

	public void setCabezera2(String[] cabezera2) {
		this.cabezera2 = cabezera2;
	}

	public String[][] getDatos2() {
		return datos2;
	}

	public void setDatos2(String[][] datos2) {
		this.datos2 = datos2;
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
    
    
}
