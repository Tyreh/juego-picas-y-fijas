package co.edu.unbosque.model;

import java.util.Random;

public class Numero {
    private int numeroAleatorio;

    public Numero(int n) {
        numeroAleatorio = n;
    }

    public int generarNumeroAleatorio(int cantidadDigitos) { //Metodo para genear el numero aleatorio
        Random numeroAleatorio = new Random();
        int potencia = (int) Math.pow(10, cantidadDigitos - 1);
        return potencia + numeroAleatorio.nextInt(9 * potencia);
    }

/*    public Numero contarFijas(String numeroIngresado, String numeroAleatorio) {
        int contadorFijas = 0;
        int contadorPicas = 0;

        for (int i = 0; i < numeroIngresado.length(); i++) {
            if (numeroIngresado.charAt(i) == numeroAleatorio.charAt(i)) {
                contadorFijas++;
            } else if (numeroIngresado.contains(String.valueOf(numeroAleatorio.charAt(i)))) {
                contadorPicas++;
            }
        }
        return new Numero(contadorFijas,contadorPicas);
    }
    */

    public int contarFijas(String numeroIngresado, String numeroAleatorio) {
        int contadorFijas = 0;

        for (int i = 0; i < numeroIngresado.length(); i++) {
            if (numeroIngresado.charAt(i) == numeroAleatorio.charAt(i)) {
                contadorFijas++;
            }
        }
        return contadorFijas;
    }

    public int contarPicas(String numeroIngresado, String numeroAleatorio) {
        int contadorPicas = 0;
        int contadorFijas = 0;

        for (int i = 0; i < numeroIngresado.length(); i++) {

            if (numeroIngresado.charAt(i) != numeroAleatorio.charAt(i) && numeroAleatorio.contains(String.valueOf(numeroIngresado.charAt(i)))) {
                contadorPicas++;
            }

/*            if (numeroIngresado.charAt(i) == numeroAleatorio.charAt(i)) {
                contadorFijas++;
            } else if (numeroIngresado.contains(String.valueOf(numeroAleatorio.charAt(i)))) {
                contadorPicas++;
            }*/
        }
        return contadorPicas;
    }

/*    public int calcularFijas(String numeroIngresado, String numeroAleatorio) {
        int contadorFijas = 0;

        for (int i = 0; i < numeroIngresado.length(); i++) {
            if (numeroIngresado.charAt(i) == numeroAleatorio.charAt(i)) {
                contadorFijas++;
            } else if (numeroIngresado.contains(String.valueOf(numeroAleatorio.charAt(i)))) {
                contadorPicas++;
            }
        }
        return contadorFijas;
    }*/

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public void setNumeroAleatorio(int numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }

}
