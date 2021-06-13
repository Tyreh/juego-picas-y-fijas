package co.edu.unbosque.model;

import java.util.Random;

public class Numero {
    private final int cantidadDigitos;
    private int digitoAleatorioGenerado;
    private StringBuilder numeroAleatorioGenerado;
    private Random numeroAleatorio;

    public Numero(int n) {
        cantidadDigitos = n;
        numeroAleatorioGenerado = new StringBuilder();
        numeroAleatorio = new Random();
    }

    public String generarNumeroAleatorio() {
        for (int i = 0; i <= cantidadDigitos - 1; i++) {
            digitoAleatorioGenerado = numeroAleatorio.nextInt(10);
            numeroAleatorioGenerado.append(digitoAleatorioGenerado);
        }
        return numeroAleatorioGenerado.toString();
    }

    public String generarNumeroAleatorioSinRepeticion() {
        for (int i = 0; i <= (cantidadDigitos - 1); i++) {
            digitoAleatorioGenerado = numeroAleatorio.nextInt(10);
            if (!numeroAleatorioGenerado.toString().contains(String.valueOf(digitoAleatorioGenerado))) {
                numeroAleatorioGenerado.append(digitoAleatorioGenerado);
            } else {
                i--;
            }
        }
        return numeroAleatorioGenerado.toString();
    }

    public int generarDigitoAleatorio() {
        return numeroAleatorio.nextInt(cantidadDigitos);
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
