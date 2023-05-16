package org.example;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        // Realiza tus pruebas aquí llamando a los métodos que desees probar

        int result = sum(2, 3);
        System.out.println("Resultado de la suma: " + result);

        boolean isEven = isEven(6);
        System.out.println("¿Es par? " + isEven);

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Jim");
        System.out.println("Tamaño de la lista de nombres: " + names.size());

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("¿La lista de frutas contiene Banana? " + fruits.contains("Banana"));
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
