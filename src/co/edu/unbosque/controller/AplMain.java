package co.edu.unbosque.controller;


import co.edu.unbosque.model.Numero;

import java.util.Scanner;

public class AplMain {
    public static void main(String[] args) {
        //algo();
        Controller control = new Controller();
    }

    public static void algo() {
        Scanner read = new Scanner(System.in);
        int num = read.nextInt();

        Numero numero = new Numero(9323);
        System.out.println("Numero generado:" + numero);
        System.out.println("Fijas: " + numero.contarFijas(String.valueOf(num),"9323"));
        System.out.println("Picas: " + numero.contarPicas(String.valueOf(num),"9323"));
        algo();
    }
}
