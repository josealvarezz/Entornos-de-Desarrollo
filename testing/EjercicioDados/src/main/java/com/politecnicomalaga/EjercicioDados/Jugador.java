package com.politecnicomalaga.EjercicioDados;

public class Jugador {
    private String nombre;
    private Dado dado1;
    private Dado dado2;
    private int puntuacion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dado1 = new Dado();
        this.dado2 = new Dado();
        this.puntuacion = 0;
    }

    public void jugar() {
        try {
            dado1.lanzar();
            dado2.lanzar();

            int numSeises = 0;

            if (dado1.getValor() == 6) {
                numSeises++;
            }

            if (dado2.getValor() == 6) {
                numSeises++;
            }

            if (numSeises > 0) {
                if (numSeises > 1) {
                    puntuacion = 100;
                } else {
                    puntuacion = 50;
                }
            } else {
                puntuacion = dado1.getValor() + dado2.getValor();
            }
        } catch (Exception e) {
            System.out.println("Error al lanzar los dados: " + e.getMessage());
        }
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Dado getDado1() {
        return dado1;
    }

    public Dado getDado2() {
        return dado2;
    }
}
