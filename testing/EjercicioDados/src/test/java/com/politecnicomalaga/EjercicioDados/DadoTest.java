package com.politecnicomalaga.EjercicioDados;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DadoTest {
    private static int valor;

    @Test
    void testConstructor() {
        Dado d = new Dado();
        assertEquals(1, d.getValor());
    }

    @Test
    void GettersSettersTest() {
        Dado d = new Dado();
        d.setValor(2);
        assertEquals(2, d.getValor());
    }

    @Test
    void lanzarCambiaValor() {
        Dado d = new Dado();
        d.setValor(-6);

        for (int i = 0; i < 100; i++) {
            d.lanzar();
            assertNotEquals(-2, d.getValor());
        }
    }

    @RepeatedTest(1000)
    void dentroRangoTest() {
        Dado d = new Dado();

            d.lanzar();
            assertTrue(d.getValor() >= 1 && d.getValor() <= 6);
        }

    @Test
    void lanzarTest() {
        int[] counts = new int[6];
        Random random = new Random();

        // Lanzar el dado un gran número de veces (por ejemplo, 1 millón)
        int numLanzamientos = 999999999;
        for (int i = 0; i < numLanzamientos; i++) {
            int valor = random.nextInt(6) + 1;
            counts[valor - 1]++;
        }

        // Calcular la frecuencia esperada de cada número (aproximadamente 1/6)
        int frecuenciaEsperada = numLanzamientos / 6;
        int desviacionMaxima = (int) (frecuenciaEsperada * 0.05); // Desviación máxima permitida del 5%

        // Verificar que la frecuencia de cada número se encuentre dentro de la desviación permitida
        for (int i = 0; i < counts.length; i++) {
            int frecuencia = counts[i];
            assertTrue(Math.abs(frecuencia - frecuenciaEsperada) <= desviacionMaxima,
                    "Frecuencia fuera de la desviación permitida para el número " + (i + 1));
        }
    }
}
