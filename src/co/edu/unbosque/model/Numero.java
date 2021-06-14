package co.edu.unbosque.model;

import java.util.Arrays;
import java.util.Random;
/**
 * Clase encargada de las funciones
 *@author Oscar Dario Moreno
 *@author Nicolas Camacho Lesmes
 *@author Tomas Espitia Galindo
 *@author Nelson Fandi�o Diaz
 */
public class Numero {
	/**
	 * Objeto de tipo final int, contiene la cantidad de dígitos.
	 */
    private final int cantidadDigitos;
    /**
     * Objeto de tipo int, contiene el dígito aleatorio generado.
     */
    private int digitoAleatorioGenerado;
    /**
     * Objeto de tipo StringBuilder, contiene el número aleatorio generado.
     */
    private StringBuilder numeroAleatorioGenerado;
    /**
     * Objeto de tipo random, contiene el número aleatorio.
     */
    private Random numeroAleatorio;
    /**
     * Método constructor de la clase.
     * @param n Numero entero a evaluar.
     */
    public Numero(int n) {
        cantidadDigitos = n;
    }
    /**
     * Método encargado de generar un número aleatorio.
     * @return el número generado.
     */
    public String generarNumeroAleatorio() {
        numeroAleatorioGenerado = new StringBuilder();
        numeroAleatorio = new Random();

        for (int i = 0; i <= cantidadDigitos - 1; i++) {
            digitoAleatorioGenerado = numeroAleatorio.nextInt(10);
            numeroAleatorioGenerado.append(digitoAleatorioGenerado);
        }
        return numeroAleatorioGenerado.toString();
    }
    /**
     * Método encargado de generar un número aleatorio sin repetición
     * @return el número generado.
     */
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
    /**
     * Método encargado de generar un dígito aleatorio
     * @return el dígito generado.
     */
    public int generarDigitoAleatorio() {
        numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(cantidadDigitos);
    }
    /**
     * Método encargado de generar las pistas.
     * @param aleatorioGenerado a evaluar.
     * @return las pistas generadas.
     */
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
    /**
     * Método encargado de contar las fijas en base la número ingresado y el número aleatorio.
     * @param numeroIngresado a evaluar.
     * @param numeroAleatorio a evaluar.
     * @return el contador de fijas.
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
    /**
     * Método encargado de contar las picas en base la número ingresado y el número aleatorio.
     * @param numeroIngresado a evaluar.
     * @param numeroAleatorio a evaluar.
     * @return el contador de picas.
     */
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
