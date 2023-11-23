package org.example.Logica;

public class Bus {
    private int pisos;
    private int asientosPorPiso;
    private Recorrido recorrido;

    public Bus(int pisos, int asientosPorPiso, Recorrido recorrido) {
        this.pisos = pisos;
        this.asientosPorPiso = asientosPorPiso;
        this.recorrido = recorrido;
    }

    public int getPisos() {
        return pisos;
    }

    public int getAsientosPorPiso() {
        return asientosPorPiso;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }
}
