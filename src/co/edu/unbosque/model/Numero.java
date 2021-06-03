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

    public String generarNumeroAleatorioSinRepeticion(int cantidadDigitos) {
        Random numeroAleatorio = new Random();
        StringBuilder numeroSinRepeticion = new StringBuilder();
        int digitoAleatorioGenerado;

        for (int i = 0; i <= (cantidadDigitos - 1); i++) {
            digitoAleatorioGenerado = numeroAleatorio.nextInt(10);
            if (!numeroSinRepeticion.toString().contains(String.valueOf(digitoAleatorioGenerado))) {
                numeroSinRepeticion.append(digitoAleatorioGenerado);
            } else {
                i--;
            }
        }
        return numeroSinRepeticion.toString();
    }


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

        for (int i = 0; i < numeroIngresado.length(); i++) {
            if (numeroIngresado.charAt(i) != numeroAleatorio.charAt(i) && numeroAleatorio.contains(String.valueOf(numeroIngresado.charAt(i)))) {
                contadorPicas++;
            }
        }
        return contadorPicas;
    }
}
