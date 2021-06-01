package co.edu.unbosque.model;

import java.util.Random;

public class Numero {
    private int numeroAleatorio;

    public Numero(int n) {
        numeroAleatorio = n;
    }

    public int generarNumeroAleatorio(int cantidadDigitos) { //Metodo para genear el numero aleatorio
        Random numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(cantidadDigitos);
    }

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public void setNumeroAleatorio(int numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }

}
