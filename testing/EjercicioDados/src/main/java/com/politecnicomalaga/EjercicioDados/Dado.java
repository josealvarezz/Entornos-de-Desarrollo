package com.politecnicomalaga.EjercicioDados;
import java.util.Random;

public class Dado {
    private int valor;

    public Dado() {
        this.valor = 1;
    }

    public void lanzar() {
        Random random = new Random();
        this.valor = random.nextInt(6) + 1;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
