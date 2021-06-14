package co.edu.unbosque.model;

import java.util.Arrays;
import java.util.Random;

public class Numero {
    private final int cantidadDigitos;
    private int digitoAleatorioGenerado;
    private StringBuilder numeroAleatorioGenerado;
    private Random numeroAleatorio;

    public Numero(int n) {
        cantidadDigitos = n;
    }

    public String generarNumeroAleatorio() {
        numeroAleatorioGenerado = new StringBuilder();
        numeroAleatorio = new Random();

        for (int i = 0; i <= cantidadDigitos - 1; i++) {
            digitoAleatorioGenerado = numeroAleatorio.nextInt(10);
            numeroAleatorioGenerado.append(digitoAleatorioGenerado);
        }
        return numeroAleatorioGenerado.toString();
    }

    public String generarNumeroAleatorioSinRepeticion() {
        numeroAleatorioGenerado = new StringBuilder();
        numeroAleatorio = new Random();

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
        numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(cantidadDigitos);
    }

    public int pista(String aleatorioGenerado) {
        int randomPrev = 0;
        char[] aleatorioArray = aleatorioGenerado.toCharArray();
        int digitoAleatorio = generarDigitoAleatorio();

        while (randomPrev == digitoAleatorio) {
            digitoAleatorio = generarDigitoAleatorio();
        }
        randomPrev = digitoAleatorio;

        return aleatorioArray[randomPrev];
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
        String[] test = new String[cantidadDigitos];
        String[] test2 = new String[cantidadDigitos];
        for (int i = 0; i < numeroIngresado.length(); i++) {
            test[i] = String.valueOf(numeroIngresado.charAt(i));
            test2[i] = String.valueOf(numeroAleatorio.charAt(i));
        }

        for (int i = 0; i < numeroAleatorio.length(); i++) {
            boolean esFija = numeroIngresado.charAt(i) == numeroAleatorio.charAt(i);
            if (esFija) {
                test[i] = "-1";
                test2[i] = "-1";
            } else if (Arrays.toString(test2).contains(test[i])) {
                //System.out.println(Arrays.toString(test2));
                for (int j = 0; j < test2.length; j++) {
                    if (test2[j].equals(test[i])) {
                        //test[i] = "-1";
                        test2[j] = "-1";
                        contadorPicas++;
                        break;
                    }
                }
/*                test[i] = null;
                contadorPicas++;*/
                /*            } else if (numeroAleatorio.contains(test[i])) {  *//*test[i].contains(String.valueOf(numeroAleatorio.charAt(i)))) {*//*
                test[i] = null;
                contadorPicas++;
            }*/
            }
        }
        return contadorPicas;
    }

/*        for (int i = 0; i < numeroIngresado.length(); i++) {
            boolean esFija = numeroIngresado.charAt(i) != numeroAleatorio.charAt(i);
            if (numeroIngresado.charAt(i) != numeroAleatorio.charAt(i) && numeroIngresado.contains(String.valueOf(numeroAleatorio.charAt(i)))) {
                contadorPicas++;
            }
        }
*//*        for (int i = 0; i < numeroIngresado.length(); i++) {
            list.add(numeroIngresado.charAt(i));
        }

        for (int i = 0; i < numeroIngresado.length(); i++) {
            if (numeroIngresado.charAt(i) != numeroAleatorio.charAt(i) && list.contains(i)) {
                contadorPicas++;
            }
        }*//*
        return contadorPicas;

    }*/
}
