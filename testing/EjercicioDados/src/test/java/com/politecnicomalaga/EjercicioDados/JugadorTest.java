package com.politecnicomalaga.EjercicioDados;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    static private String nombre;
    static  Dado dado1;
    static  Dado dado2;
    static private int puntuacion;

    @BeforeAll
    public static void init() {
        nombre = "jugador";
        dado1 = new Dado();
        dado2 = new Dado();
    }

    @Test
    void constructorTest() {
        Jugador j = new Jugador(nombre);

        assertEquals(nombre, j.getNombre());
        assertEquals(1, dado1.getValor());
        assertEquals(1, dado2.getValor());
        assertEquals(0, puntuacion);
    }

    @Test
    void jugarTest() {
        Jugador j = new Jugador("jugador");

        j.jugar();

        int puntuacionFinal = j.getPuntuacion();

        assertTrue(puntuacionFinal >= 2 && puntuacionFinal <= 12);
        assertEquals(j.getPuntuacion(), j.getDado1().getValor() + j.getDado2().getValor());


    }
}