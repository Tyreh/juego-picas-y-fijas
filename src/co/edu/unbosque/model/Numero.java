package co.edu.unbosque.model;

import java.util.Random;

public class Numero {
    private int numeroAleatorio;

    public Numero() {
        numeroAleatorio = 0;
    }
    public Numero(int n) {
    	numeroAleatorio = n;
    }
    
    public Random generarNumeroAleatorio () { //Metodo para genear el numero aleatorio
    	Random numeroAleatorio = new Random();
    	int intAleatorio = numeroAleatorio.nextInt(1000000000); //Rango entre 0 y 999999999
		return numeroAleatorio;
		
    }
	
    
    public int getNumeroAleatorio() {
		return numeroAleatorio;
	}
	public void setNumeroAleatorio(int numeroAleatorio) {
		this.numeroAleatorio = numeroAleatorio;
	}
    
}
