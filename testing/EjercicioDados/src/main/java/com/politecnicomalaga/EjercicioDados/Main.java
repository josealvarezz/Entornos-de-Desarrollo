package com.politecnicomalaga.EjercicioDados;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Jugador 1"));
        jugadores.add(new Jugador("Jugador 2"));
        int jugadorActual = 0;

        while (true) {
            System.out.println("Turno de " + jugadores.get(jugadorActual).getNombre());
            System.out.println("Pulsa enter para lanzar los dados");
            scanner.nextLine();

            jugadores.get(jugadorActual).jugar();
            System.out.println("Has sacado " + jugadores.get(jugadorActual).getDado1().getValor() + " y " + jugadores.get(jugadorActual).getDado2().getValor());

            if (jugadorActual == 0) {
                System.out.println("Puntuación del Jugador 1: " + jugadores.get(0).getPuntuacion());
                System.out.println("Puntuación del Jugador 2: " + jugadores.get(1).getPuntuacion());
            } else {
                System.out.println("Puntuación del Jugador 2: " + jugadores.get(1).getPuntuacion());
                System.out.println("Puntuación del Jugador 1: " + jugadores.get(0).getPuntuacion());
            }

            if (jugadorActual == 0) {
                jugadorActual = 1;
            } else {
                jugadorActual = 0;
            }

            if (jugadores.get(0).getPuntuacion() > jugadores.get(1).getPuntuacion()) {
                System.out.println("Gana Jugador 1");
            } else if (jugadores.get(1).getPuntuacion() > jugadores.get(0).getPuntuacion()) {
                System.out.println("Gana Jugador 2");
            } else {
                System.out.println("Empate");
            }

            System.out.println("Pulsa enter para continuar");
            scanner.nextLine();
        }
    }
}