package co.edu.unbosque.controller;


import co.edu.unbosque.model.Numero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplMain {
    public static void main(String[] args) {
        //algo();
        Controller control = new Controller();
    }



    public static void algo() {
        Numero numero = new Numero(5);
        System.out.println("Numero generado: 69879 ");

        Scanner read = new Scanner(System.in);
        int num = read.nextInt();

        //List<Character> generated = new ArrayList<>();
        //String numeroGenerado = "89977";
        //for (int i = 0; i < numeroGenerado.length(); i++) {
        //    generated.add(numeroGenerado.charAt(i));
        //}

        //int count = numero.count(generated, String.valueOf(num));
        //int count2 = numero.count2(generated, String.valueOf(num));

        System.out.println("Fijas: " + numero.contarFijas(String.valueOf(num),"69879"));
        System.out.println("Picas: " + numero.contarPicas(String.valueOf(num),"69879"));
        //System.out.println("count: " + count);
        //System.out.println("count2: " + count2);
        algo();
    }
}
